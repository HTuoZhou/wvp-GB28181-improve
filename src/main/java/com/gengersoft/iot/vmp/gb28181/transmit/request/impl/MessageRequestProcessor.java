package com.gengersoft.iot.vmp.gb28181.transmit.request.impl;

import com.gengersoft.iot.vmp.gb28181.transmit.SIPProcessorObserver;
import com.gengersoft.iot.vmp.gb28181.transmit.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.request.ISIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message.IMessageHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Element;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.RequestEvent;
import javax.sip.message.Request;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanzai
 * @date 2023/1/13
 */
@Component
@Slf4j
public class MessageRequestProcessor extends AbstractSIPRequestProcessor implements InitializingBean, ISIPRequestProcessor {

    @Autowired
    private SIPProcessorObserver sipProcessorObserver;

    private static Map<String, IMessageHandler> messageHandlerMap = new ConcurrentHashMap<>();

    public void addMessageHandler(String name, IMessageHandler handler) {
        messageHandlerMap.put(name, handler);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        sipProcessorObserver.addRequestProcessor(Request.MESSAGE,this);
    }

    @Override
    @SneakyThrows(Exception.class)
    public void process(RequestEvent requestEvent) {
        Element rootElement = getRootElement(requestEvent);
        String name = getRootElement(requestEvent).getName();
        IMessageHandler messageHandler = messageHandlerMap.get(name);
        if (Objects.isNull(messageHandler)) {
            log.warn("[Message] [Message RootElement:{}] 暂不支持", name);
            return;
        }

        messageHandlerMap.get(name).handForDevice(requestEvent,rootElement);
    }
}
