package com.gengersoft.iot.vmp.gb28181.event.request.impl;

import com.gengersoft.iot.vmp.gb28181.event.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.event.request.ISIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPProcessorObserver;
import gov.nist.javax.sip.RequestEventExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.RequestEvent;

/**
 * @author hanzai
 * @date 2023/1/12
 */
@Component
@Slf4j
public class RegisterRequestProcessor extends AbstractSIPRequestProcessor implements InitializingBean, ISIPRequestProcessor {

    public final String method = "REGISTER";
    @Autowired
    private SIPProcessorObserver sipProcessorObserver;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 添加 request 订阅
        sipProcessorObserver.addRequestProcessor(method,this);
    }

    @Override
    public void process(RequestEvent requestEvent) {
        RequestEventExt requestEventExt = (RequestEventExt) requestEvent;
        String requestAddress = requestEventExt.getRemoteIpAddress() + ":" + requestEventExt.getRemotePort();
        log.info("[Register] [Register Address:{}]", requestAddress);
    }
}
