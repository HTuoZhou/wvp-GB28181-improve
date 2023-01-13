package com.gengersoft.iot.vmp.gb28181.transmit.request.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gengersoft.iot.vmp.entity.po.DevicePO;
import com.gengersoft.iot.vmp.gb28181.auth.DigestServerAuthenticationHelper;
import com.gengersoft.iot.vmp.gb28181.bean.WvpSIPDate;
import com.gengersoft.iot.vmp.gb28181.properties.SIPProperties;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPProcessorObserver;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPSender;
import com.gengersoft.iot.vmp.gb28181.transmit.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.request.ISIPRequestProcessor;
import com.gengersoft.iot.vmp.service.IDeviceService;
import gov.nist.javax.sip.RequestEventExt;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.SipUri;
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
import javax.sip.header.FromHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;
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
            log.info("[REGISTER] [REGISTER Response Address:{}] 未认证,需要回复401",requestAddress);
            log.debug("[REGISTER] [REGISTER 401] [REGISTER Response Content:\n{}]",response);
            return;
        }

        FromHeader fromHeader = (FromHeader) request.getHeader(FromHeader.NAME);
        AddressImpl address = (AddressImpl) fromHeader.getAddress();
        SipUri uri = (SipUri) address.getURI();
        String deviceId = uri.getUser();
        DevicePO devicePO = deviceService.getOne(Wrappers.<DevicePO>lambdaQuery().eq(DevicePO::getDeviceId, deviceId));
        String password = (Objects.nonNull(devicePO) && StringUtils.isNotBlank(devicePO.getPassword())) ? devicePO.getPassword() : sipProperties.getPassword();

        // 密码不正确,需要回复403
        if (StringUtils.isBlank(password) || !new DigestServerAuthenticationHelper().doAuthenticatePlainTextPassword(request,password)) {
            Response response = getMessageFactory().createResponse(Response.FORBIDDEN, request);
            sipSender.transmitRequest(request.getLocalAddress().getHostAddress(), response);
            log.info("[REGISTER] [REGISTER Response Address:{}] 密码不正确,需要回复403",requestAddress);
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
        log.debug("[REGISTER] [REGISTER 200] [REGISTER Response Content:\n{}]",response);

        if (request.getExpires().getExpires() != 0) {
            // 注册
            log.info("[REGISTER] [REGISTER Address:{}] 开始注册",requestAddress);
        } else {
            // 注销
            log.info("[REGISTER] [REGISTER Address:{}] 开始注销",requestAddress);
        }
    }
}
