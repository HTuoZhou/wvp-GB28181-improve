package com.gengersoft.iot.vmp.gb28181.transmit;

import com.gengersoft.iot.vmp.gb28181.SIPRunner;
import com.gengersoft.iot.vmp.gb28181.event.Event;
import com.gengersoft.iot.vmp.gb28181.util.SIPUtils;
import com.gengersoft.iot.vmp.util.GitUtils;
import gov.nist.javax.sip.SipProviderImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.sip.SipException;
import javax.sip.header.CallIdHeader;
import javax.sip.header.UserAgentHeader;
import javax.sip.header.ViaHeader;
import javax.sip.message.Message;
import javax.sip.message.Request;
import javax.sip.message.Response;
import java.text.ParseException;
import java.util.Objects;

/**
 * @author hanzai
 * @date 2023/1/13
 */
@Component
@Slf4j
public class SIPSender {

    @Autowired
    private SIPRunner sipRunner;

    @Autowired
    private GitUtils gitUtils;

    public void transmitRequest(String ip, Message message) throws SipException, ParseException {
        transmitRequest(ip, message, null, null);
    }

    public void transmitRequest(String ip, Message message, Event errorEvent) throws SipException, ParseException {
        transmitRequest(ip, message, errorEvent, null);
    }

    public void transmitRequest(String ip, Message message, Event errorEvent, Event okEvent) throws SipException, ParseException {
        String transport = "UDP";

        ViaHeader viaHeader = (ViaHeader)message.getHeader(ViaHeader.NAME);
        if (Objects.isNull(viaHeader)) {
            log.warn("[SIPSender] ViaHeader缺失,使用默认的UDP方式处理数据");
        }else {
            transport = viaHeader.getTransport();
        }

        if (Objects.isNull(message.getHeader(UserAgentHeader.NAME))) {
            try {
                message.addHeader(SIPUtils.createUserAgentHeader(sipRunner.getSipFactory(), gitUtils));
            } catch (ParseException e) {
                log.error("[SIPSender] UserAgentHeader添加失败", e);
            }
        }

        CallIdHeader callIdHeader = (CallIdHeader) message.getHeader(CallIdHeader.NAME);

        if ("TCP".equals(transport)) {
            SipProviderImpl tcpSipProvider = sipRunner.getTcpSipProvider(ip);
            if (tcpSipProvider == null) {
                log.error("[SIPSender] 发送信息失败,未找到tcp://{}的监听信息", ip);
                return;
            }
            if (message instanceof Request) {
                tcpSipProvider.sendRequest((Request)message);
            }else if (message instanceof Response) {
                tcpSipProvider.sendResponse((Response)message);
            }

        } else if ("UDP".equals(transport)) {
            SipProviderImpl sipProvider = sipRunner.getUdpSipProvider(ip);
            if (sipProvider == null) {
                log.error("[SIPSender] 发送信息失败,未找到udp://{}的监听信息", ip);
                return;
            }
            if (message instanceof Request) {
                sipProvider.sendRequest((Request)message);
            }else if (message instanceof Response) {
                sipProvider.sendResponse((Response)message);
            }
        }
    }

    public CallIdHeader getNewCallIdHeader(String ip, String transport){
        if (ObjectUtils.isEmpty(transport)) {
            return sipRunner.getUdpSipProvider().getNewCallId();
        }
        SipProviderImpl sipProvider;
        if (ObjectUtils.isEmpty(ip)) {
            sipProvider = transport.equalsIgnoreCase("TCP") ? sipRunner.getTcpSipProvider()
                    : sipRunner.getUdpSipProvider();
        }else {
            sipProvider = transport.equalsIgnoreCase("TCP") ? sipRunner.getTcpSipProvider(ip)
                    : sipRunner.getUdpSipProvider(ip);
        }

        if (sipProvider == null) {
            sipProvider = sipRunner.getUdpSipProvider();
        }

        if (sipProvider != null) {
            return sipProvider.getNewCallId();
        }else {
            log.warn("[SIPSender] 新建CallIdHeader失败,ip={},transport={}", ip, transport);
            return null;
        }
    }

}
