package com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message;

import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import org.dom4j.Element;

import javax.sip.RequestEvent;

/**
 * @author hanzai
 * @date 2023/1/13
 */
public interface IMessageHandler {

    void process(RequestEvent requestEvent, DeviceBO deviceBO,Element rootElement);

}
