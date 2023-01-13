package com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.notify;

import com.gengersoft.iot.vmp.gb28181.transmit.request.impl.MessageRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.AbstractMessageHandler;
import com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.IMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2023/1/13
 */
@Component
@Slf4j
public class NotifyMessageHandler extends AbstractMessageHandler implements InitializingBean, IMessageHandler {

    @Autowired
    private MessageRequestProcessor messageRequestProcessor;

    private static final String rootElement = "Notify";

    @Override
    public void afterPropertiesSet() throws Exception {
        messageRequestProcessor.addMessageHandler(rootElement, this);
    }
}
