package com.gengersoft.iot.vmp.gb28181.transmit.cmd;

import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import com.gengersoft.iot.vmp.gb28181.SIPRunner;
import com.gengersoft.iot.vmp.gb28181.properties.SIPProperties;
import com.gengersoft.iot.vmp.gb28181.util.SIPUtils;
import com.gengersoft.iot.vmp.service.IRedisService;
import com.gengersoft.iot.vmp.util.GitUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.address.Address;
import javax.sip.address.SipURI;
import javax.sip.header.*;
import javax.sip.message.Request;
import java.util.ArrayList;

/**
 * @author hanzai
 * @date 2023/2/1
 */
@Component
public class SIPRequestHeaderProvider {

    @Autowired
    private SIPRunner sipRunner;

    @Autowired
    private SIPProperties sipProperties;

    @Autowired
    private GitUtils gitUtils;

    @Autowired
    IRedisService redisService;

    @SneakyThrows(Exception.class)
    public Request createMessageRequest(DeviceBO deviceBO, String content, String viaTag, String fromTag, String toTag, CallIdHeader callIdHeader){
        Request request = null;
        // sipuri
        SipURI requestURI = sipRunner.getSipFactory().createAddressFactory().createSipURI(deviceBO.getDeviceId(), deviceBO.getHostAddress());
        // via
        ArrayList<ViaHeader> viaHeaders = new ArrayList<ViaHeader>();
        ViaHeader viaHeader = sipRunner.getSipFactory().createHeaderFactory().createViaHeader(sipRunner.getLocalIp(deviceBO.getLocalIp()), sipProperties.getPort(), deviceBO.getTransport(), viaTag);
        viaHeader.setRPort();
        viaHeaders.add(viaHeader);
        // from
        SipURI fromSipURI = sipRunner.getSipFactory().createAddressFactory().createSipURI(sipProperties.getId(), sipProperties.getDomain());
        Address fromAddress = sipRunner.getSipFactory().createAddressFactory().createAddress(fromSipURI);
        FromHeader fromHeader = sipRunner.getSipFactory().createHeaderFactory().createFromHeader(fromAddress, fromTag);
        // to
        SipURI toSipURI = sipRunner.getSipFactory().createAddressFactory().createSipURI(deviceBO.getDeviceId(), deviceBO.getHostAddress());
        Address toAddress = sipRunner.getSipFactory().createAddressFactory().createAddress(toSipURI);
        ToHeader toHeader = sipRunner.getSipFactory().createHeaderFactory().createToHeader(toAddress, toTag);

        // Forwards
        MaxForwardsHeader maxForwards = sipRunner.getSipFactory().createHeaderFactory().createMaxForwardsHeader(70);
        // ceq
        CSeqHeader cSeqHeader = sipRunner.getSipFactory().createHeaderFactory().createCSeqHeader(redisService.getCseq(), Request.MESSAGE);

        request = sipRunner.getSipFactory().createMessageFactory().createRequest(requestURI, Request.MESSAGE, callIdHeader, cSeqHeader, fromHeader,
                toHeader, viaHeaders, maxForwards);

        request.addHeader(SIPUtils.createUserAgentHeader(sipRunner.getSipFactory(), gitUtils));

        ContentTypeHeader contentTypeHeader = sipRunner.getSipFactory().createHeaderFactory().createContentTypeHeader("Application", "MANSCDP+xml");
        request.setContent(content, contentTypeHeader);
        return request;
    }

}
