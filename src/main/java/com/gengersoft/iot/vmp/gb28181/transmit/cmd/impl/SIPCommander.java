package com.gengersoft.iot.vmp.gb28181.transmit.cmd.impl;

import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import com.gengersoft.iot.vmp.gb28181.SIPRunner;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPSender;
import com.gengersoft.iot.vmp.gb28181.transmit.cmd.ISIPCommander;
import com.gengersoft.iot.vmp.gb28181.transmit.cmd.SIPRequestHeaderProvider;
import com.gengersoft.iot.vmp.gb28181.util.SIPUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.message.Request;

/**
 * @author hanzai
 * @date 2023/2/1
 */
@Component
@Slf4j
public class SIPCommander implements ISIPCommander {

    @Autowired
    private SIPRequestHeaderProvider sipRequestHeaderProvider;

    @Autowired
    private SIPSender sipSender;

    @Autowired
    private SIPRunner sipRunner;

    @Override
    @SneakyThrows(Exception.class)
    public void deviceInfoQuery(DeviceBO deviceBO) {
        StringBuilder stringBuilder = new StringBuilder();
        String charset = deviceBO.getCharset();
        stringBuilder.append("<?xml version=\"  1.0\" encoding=\"" + charset + "\"?>\r\n");
        stringBuilder.append("<Query>\r\n");
        stringBuilder.append("<CmdType>DeviceInfo</CmdType>\r\n");
        stringBuilder.append("<SN>" + (int) ((Math.random() * 9 + 1) * 100000) + "</SN>\r\n");
        stringBuilder.append("<DeviceID>" + deviceBO.getDeviceId() + "</DeviceID>\r\n");
        stringBuilder.append("</Query>\r\n");

        Request request = sipRequestHeaderProvider.createMessageRequest(deviceBO, stringBuilder.toString(), SIPUtils.getNewViaTag(), SIPUtils.getNewFromTag(), null,sipSender.getNewCallIdHeader(sipRunner.getLocalIp(deviceBO.getLocalIp()),deviceBO.getTransport()));

        sipSender.transmitRequest(sipRunner.getLocalIp(deviceBO.getLocalIp()), request);
        log.info("[Message] [Message Query DeviceInfo Address:{}]",deviceBO.getHostAddress());
        log.debug("[Message] [Message Query DeviceInfo Content:{}]",request);
    }
}
