package com.gengersoft.iot.vmp.gb28181.transmit.event.response;

import javax.sip.ResponseEvent;

/**
 * @author hanzai
 * @date 2023/1/12
 */
public interface ISIPResponseProcessor {
    void process(ResponseEvent responseEvent);
}
