package com.gengersoft.iot.vmp.gb28181.bean;

import javax.sip.Dialog;
import java.util.EventObject;

/**
 * @author hanzai
 * @date 2023/1/13
 */
public class DeviceNotFoundEvent extends EventObject {

    private String callId;

    /**
     * Constructs a prototypical Event.
     *
     * @param dialog
     * @throws IllegalArgumentException if source is null.
     */
    public DeviceNotFoundEvent(Dialog dialog) {
        super(dialog);
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }
}