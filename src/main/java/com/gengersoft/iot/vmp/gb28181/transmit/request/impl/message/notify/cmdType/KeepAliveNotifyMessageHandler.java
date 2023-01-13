package com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.notify.cmdType;

import com.gengersoft.iot.vmp.gb28181.transmit.SIPSender;
import com.gengersoft.iot.vmp.gb28181.transmit.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.IMessageHandler;
import com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.notify.NotifyMessageHandler;
import gov.nist.javax.sip.RequestEventExt;
import gov.nist.javax.sip.message.SIPRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Element;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.RequestEvent;
import javax.sip.message.Response;

/**
 * @author hanzai
 * @date 2023/1/13
 */
@Component
@Slf4j
public class KeepAliveNotifyMessageHandler extends AbstractSIPRequestProcessor implements InitializingBean, IMessageHandler {

    private static final String cmdType = "Keepalive";

    @Autowired
    private NotifyMessageHandler notifyMessageHandler;

    @Autowired
    private SIPSender sipSender;

    @Override
    public void afterPropertiesSet() throws Exception {
        notifyMessageHandler.addMessageHandler(cmdType,this);
    }

    @Override
    @SneakyThrows(Exception.class)
    public void handForDevice(RequestEvent requestEvent, Element element) {
        SIPRequest request = (SIPRequest) requestEvent.getRequest();
        RequestEventExt requestEventExt = (RequestEventExt) requestEvent;
        String requestAddress = requestEventExt.getRemoteIpAddress() + ":" + requestEventExt.getRemotePort();
        log.info("[Message] [Message Keepalive Address:{}]",requestAddress);
        log.debug("[Message] [Message Keepalive Content:\n{}]",request);

        Response response = getMessageFactory().createResponse(Response.OK, request);
        sipSender.transmitRequest(request.getLocalAddress().getHostAddress(), response);
        log.info("[Message] [Message Keepalive Response Address:{}]",requestAddress);
        log.debug("[Message] [Message Keepalive Response Content:\n{}]",response);
    }
}
