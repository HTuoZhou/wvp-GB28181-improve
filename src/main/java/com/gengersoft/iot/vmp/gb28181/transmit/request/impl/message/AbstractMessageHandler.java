package com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message;

import com.gengersoft.iot.vmp.gb28181.transmit.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.util.XmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Element;

import javax.sip.RequestEvent;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanzai
 * @date 2023/1/13
 */
@Slf4j
public abstract class AbstractMessageHandler extends AbstractSIPRequestProcessor implements IMessageHandler {

    public Map<String, IMessageHandler> messageHandlerMap = new ConcurrentHashMap<>();

    public void addMessageHandler(String cmdType, IMessageHandler messageHandler) {
        messageHandlerMap.put(cmdType, messageHandler);
    }

    @Override
    public void handForDevice(RequestEvent requestEvent, Element element) {
        String cmdType = XmlUtils.getText(element, "CmdType");
        IMessageHandler messageHandler = messageHandlerMap.get(cmdType);
        if (Objects.isNull(messageHandler)) {
            log.warn("[Message] [Message CmdType:{}] 暂不支持", cmdType);
            return;
        }

        messageHandlerMap.get(cmdType).handForDevice(requestEvent,element);
    }


}
