package com.gengersoft.iot.vmp.gb28181.event.request;

import lombok.extern.slf4j.Slf4j;

import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

/**
 * @author hanzai
 * @date 2023/1/12
 */
@Slf4j
public abstract class AbstractSIPRequestProcessor {

    public AddressFactory getAddressFactory() {
        try {
            return SipFactory.getInstance().createAddressFactory();
        } catch (PeerUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HeaderFactory getHeaderFactory() {
        try {
            return SipFactory.getInstance().createHeaderFactory();
        } catch (PeerUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MessageFactory getMessageFactory() {
        try {
            return SipFactory.getInstance().createMessageFactory();
        } catch (PeerUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

}
