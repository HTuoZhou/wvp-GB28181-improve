package com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message.response.cmdType;

import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import com.gengersoft.iot.vmp.entity.po.DevicePO;
import com.gengersoft.iot.vmp.gb28181.transmit.SIPSender;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.AbstractSIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message.IMessageHandler;
import com.gengersoft.iot.vmp.gb28181.transmit.event.request.impl.message.response.ResponseMessageHandler;
import com.gengersoft.iot.vmp.gb28181.util.XmlUtils;
import com.gengersoft.iot.vmp.service.IDeviceService;
import gov.nist.javax.sip.RequestEventExt;
import gov.nist.javax.sip.message.SIPRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Element;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sip.RequestEvent;
import javax.sip.message.Response;

/**
 * @author hanzai
 * @date 2023/2/1
 */
@Component
@Slf4j
public class DeviceInfoResponseMessageHandler extends AbstractSIPRequestProcessor implements InitializingBean, IMessageHandler {

    private static final String cmdType = "DeviceInfo";

    @Autowired
    private ResponseMessageHandler responseMessageHandler;

    @Autowired
    private SIPSender sipSender;

    @Autowired
    private IDeviceService deviceService;

    @Override
    public void afterPropertiesSet() throws Exception {
        responseMessageHandler.addMessageHandler(cmdType, this);
    }

    @Override
    @SneakyThrows(Exception.class)
    public void process(RequestEvent requestEvent, DeviceBO deviceBO, Element rootElement) {
        SIPRequest request = (SIPRequest) requestEvent.getRequest();
        RequestEventExt requestEventExt = (RequestEventExt) requestEvent;
        String requestAddress = requestEventExt.getRemoteIpAddress() + ":" + requestEventExt.getRemotePort();
        log.info("[Message] [Message {} DeviceInfo Address:{}]", rootElement.getName(),requestAddress);
        log.debug("[Message] [Message {} DeviceInfo Content:\n{}]", rootElement.getName(),request);

        if (deviceBO.getOnline() != 0) {
            Response response = getMessageFactory().createResponse(Response.OK, request);
            sipSender.transmitRequest(request.getLocalAddress().getHostAddress(), response);
            log.info("[Message] [Message {} DeviceInfo Response Address:{}]",rootElement.getName(),requestAddress);
            log.debug("[Message] [Message {} DeviceInfo Response Content:\n{}]",rootElement.getName(),response);

            deviceBO.setName(XmlUtils.getText(rootElement, "DeviceName"));
            deviceBO.setManufacturer(XmlUtils.getText(rootElement, "Manufacturer"));
            deviceBO.setModel(XmlUtils.getText(rootElement, "Model"));
            deviceBO.setFirmware(XmlUtils.getText(rootElement, "Firmware"));
            deviceService.saveOrUpdate(DevicePO.bo2po(deviceBO));
        }
    }
}