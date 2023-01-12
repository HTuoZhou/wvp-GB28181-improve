package com.gengersoft.iot.vmp.gb28181.event.request;

import javax.sip.RequestEvent;

/**
 * @author hanzai
 * @date 2023/1/12
 */
public interface ISIPRequestProcessor {
    void process(RequestEvent requestEvent);
}
