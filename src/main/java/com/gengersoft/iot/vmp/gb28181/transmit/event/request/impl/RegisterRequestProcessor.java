package com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl;

import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import com.gengersoft.iot.vmp.gb28181.auth.DigestServerAuthenticationHelper;
import com.gengersoft.iot.vmp.gb28181.bean.WvpSIPDate;
import com.gengersoft.iot.vmp.gb28181.properties.SIPProperties;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPProcessorObserver;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPSender;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.ISIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.util.SIPUtils;
import com.gengersoft.iot.vmp.service.IDeviceService;
import gov.nist.javax.sip.RequestEventExt;
import gov.nist.javax.sip.header.SIPDateHeader;
import gov.nist.javax.sip.message.SIPRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.RequestEvent;
import javax.sip.header.AuthorizationHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.ViaHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

/**
 * @author hanzai
 * @date 2023/1/12
 */
@Component
@Slf4j
public class RegisterRequestProcessor extends AbstractSIPRequestProcessor implements InitializingBean, ISIPRequestProcessor {

    @Autowired
    private SIPProcessorObserver sipProcessorObserver;

    @Autowired
    private SIPProperties sipProperties;

    @Autowired
    private SIPSender sipSender;

    @Autowired
    private IDeviceService deviceService;

    @Override
    public void afterPropertiesSet() throws Exception {
        sipProcessorObserver.addRequestProcessor(Request.REGISTER,this);
    }

    @Override
    @SneakyThrows(Exception.class)
    public void process(RequestEvent requestEvent) {
        SIPRequest request = (SIPRequest) requestEvent.getRequest();
        RequestEventExt requestEventExt = (RequestEventExt) requestEvent;
        String requestAddress = requestEventExt.getRemoteIpAddress() + ":" + requestEventExt.getRemotePort();
        log.info("[REGISTER] [REGISTER Address:{}]",requestAddress);
        log.debug("[REGISTER] [REGISTER Content:\n{}]",request);

        AuthorizationHeader authorizationHeader = (AuthorizationHeader) request.getHeader(AuthorizationHeader.NAME);
        // 未认证,需要回复401
        if (Objects.isNull(authorizationHeader)) {
            Response response = getMessageFactory().createResponse(Response.UNAUTHORIZED, request);
            new DigestServerAuthenticationHelper().generateChallenge(getHeaderFactory(), response, sipProperties.getDomain());
            sipSender.transmitRequest(request.getLocalAddress().getHostAddress(), response);
            log.info("[REGISTER] [REGISTER 401] [REGISTER Response Address:{}]",requestAddress);
            log.debug("[REGISTER] [REGISTER 401] [REGISTER Response Content:\n{}]",response);
            return;
        }

        String deviceId = SIPUtils.getUserIdFromFromHeader(request);
        DeviceBO deviceBO = deviceService.getDevice(deviceId);
        String password = (Objects.nonNull(deviceBO) && StringUtils.isNotBlank(deviceBO.getPassword())) ? deviceBO.getPassword() : sipProperties.getPassword();

        // 密码不正确,需要回复403
        if (StringUtils.isBlank(password) || !new DigestServerAuthenticationHelper().doAuthenticatePlainTextPassword(request,password)) {
            Response response = getMessageFactory().createResponse(Response.FORBIDDEN, request);
            sipSender.transmitRequest(request.getLocalAddress().getHostAddress(), response);
            log.info("[REGISTER] [REGISTER 403] [REGISTER Response Address:{}]",requestAddress);
            log.debug("[REGISTER] [REGISTER 403] [REGISTER Response Content:\n{}]",response);
            return;
        }

        // 认证成功且密码正确,需要回复200
        Response response = getMessageFactory().createResponse(Response.OK, request);
        // 添加date头
        SIPDateHeader dateHeader = new SIPDateHeader();
        // 使用自己修改的 解决与国标时间格式不一致的问题
        WvpSIPDate wvpSipDate = new WvpSIPDate(Calendar.getInstance(Locale.ENGLISH).getTimeInMillis());
        dateHeader.setDate(wvpSipDate);
        response.addHeader(dateHeader);
        // 添加Contact头
        response.addHeader(request.getHeader(ContactHeader.NAME));
        // 添加Expires头
        response.addHeader(request.getExpires());

        sipSender.transmitRequest(request.getLocalAddress().getHostAddress(), response);
        log.info("[REGISTER] [REGISTER 200] [REGISTER Response Address:{}]",requestAddress);
        log.debug("[REGISTER] [REGISTER 200] [REGISTER Response Content:\n{}]",response);

        int expires = request.getExpires().getExpires();
        if (expires != 0) {
            // 开始注册
            if (deviceBO == null) {
                deviceBO = new DeviceBO();
                deviceBO.setDeviceId(deviceId);
                deviceBO.setStreamMode("UDP");
                deviceBO.setCharset("GB2312");
                deviceBO.setGeoCoordSys("WGS84");
                deviceBO.setTreeType("CivilCode");
            }

            ViaHeader viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);
            String transport = viaHeader.getTransport();
            deviceBO.setTransport("TCP".equalsIgnoreCase(transport) ? "TCP" : "UDP");
            deviceBO.setExpires(expires);
            deviceBO.setRegisterTime(LocalDateTime.now());
            deviceBO.setKeepaliveTime(LocalDateTime.now());
            deviceBO.setIp(request.getRemoteAddress().getHostAddress());
            deviceBO.setPort(request.getRemotePort());
            deviceBO.setHostAddress(request.getRemoteAddress().getHostAddress().concat(":").concat(String.valueOf(request.getRemotePort())));
            deviceBO.setLocalIp(request.getLocalAddress().getHostAddress());

            deviceService.online(deviceBO);
        } else {
            // 开始注销
            deviceBO.setOnline(0);

            deviceService.offline(deviceBO);
        }
    }
}
