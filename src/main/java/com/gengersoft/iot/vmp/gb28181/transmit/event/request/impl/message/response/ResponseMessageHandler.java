package com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message.response;

import com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.MessageRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message.AbstractMessageHandler;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message.IMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2023/2/1
 */
@Component
@Slf4j
public class ResponseMessageHandler extends AbstractMessageHandler implements InitializingBean, IMessageHandler {

    @Autowired
    private MessageRequestProcessor messageRequestProcessor;

    private static final String rootElement = "Response";

    @Override
    public void afterPropertiesSet() throws Exception {
        messageRequestProcessor.addMessageHandler(rootElement, this);
    }
}
