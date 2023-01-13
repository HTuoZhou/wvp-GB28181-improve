package com.gengersoft.iot.vmp.gb28181.transmit.request.impl.message;

import org.dom4j.Element;

import javax.sip.RequestEvent;

/**
 * @author hanzai
 * @date 2023/1/13
 */
public interface IMessageHandler {

    void handForDevice(RequestEvent requestEvent, Element element);

}
