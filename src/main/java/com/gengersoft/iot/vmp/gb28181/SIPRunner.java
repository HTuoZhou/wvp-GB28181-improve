package com.gengersoft.iot.vmp.gb28181;

import com.gengersoft.iot.vmp.gb28181.properties.DefaultProperties;
import com.gengersoft.iot.vmp.gb28181.properties.SIPProperties;
import com.gengersoft.iot.vmp.gb28181.transmit.ISIPProcessorObserver;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.SipStackImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sip.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@Order(1)
@Slf4j
public class SIPRunner implements CommandLineRunner {

    @Autowired
    private SIPProperties sipProperties;

    @Autowired
    private ISIPProcessorObserver sipProcessorObserver;

    private SipFactory sipFactory;

    private final Map<String, SipProviderImpl> tcpSipProviderMap = new ConcurrentHashMap<>();
    private final Map<String, SipProviderImpl> udpSipProviderMap = new ConcurrentHashMap<>();

    @Override
    public void run(String... args) throws Exception {
        List<String> monitorIps = new ArrayList<>();
        // 使用逗号分割多个ip
        String separator = ",";
        if (sipProperties.getIp().indexOf(separator) > 0) {
            String[] split = sipProperties.getIp().split(separator);
            monitorIps.addAll(Arrays.asList(split));
        }else {
            monitorIps.add(sipProperties.getIp());
        }

        sipFactory = SipFactory.getInstance();
        sipFactory.setPathName("gov.nist");
        if (monitorIps.size() > 0) {
            for (String monitorIp : monitorIps) {
                addListeningPoint(monitorIp, sipProperties.getPort());
            }
            if (udpSipProviderMap.size() + tcpSipProviderMap.size() == 0) {
                System.exit(1);
            }
        }
    }

    private void addListeningPoint(String monitorIp, int port){
        SipStackImpl sipStack;
        try {
            sipStack = (SipStackImpl)sipFactory.createSipStack(DefaultProperties.getProperties(monitorIp, false));
        } catch (PeerUnavailableException e) {
            log.error("[Sip Server] SIP服务启动失败， 监听地址{}失败,请检查ip是否正确", monitorIp);
            return;
        }

        try {
            ListeningPoint tcpListeningPoint = sipStack.createListeningPoint(monitorIp, port, "TCP");
            SipProviderImpl tcpSipProvider = (SipProviderImpl)sipStack.createSipProvider(tcpListeningPoint);

            tcpSipProvider.setDialogErrorsAutomaticallyHandled();
            tcpSipProvider.addSipListener(sipProcessorObserver);
            tcpSipProviderMap.put(monitorIp, tcpSipProvider);

            log.info("[Sip Server] tcp://{}:{} 启动成功", monitorIp, port);
        } catch (TransportNotSupportedException
                 | TooManyListenersException
                 | ObjectInUseException
                 | InvalidArgumentException e) {
            log.error("[Sip Server] tcp://{}:{} SIP服务启动失败,请检查端口是否被占用或者ip是否正确"
                    , monitorIp, port);
        }

        try {
            ListeningPoint udpListeningPoint = sipStack.createListeningPoint(monitorIp, port, "UDP");

            SipProviderImpl udpSipProvider = (SipProviderImpl)sipStack.createSipProvider(udpListeningPoint);
            udpSipProvider.addSipListener(sipProcessorObserver);

            udpSipProviderMap.put(monitorIp, udpSipProvider);

            log.info("[Sip Server] udp://{}:{} 启动成功", monitorIp, port);
        } catch (TransportNotSupportedException
                 | TooManyListenersException
                 | ObjectInUseException
                 | InvalidArgumentException e) {
            log.error("[Sip Server] udp://{}:{} SIP服务启动失败,请检查端口是否被占用或者ip是否正确"
                    , monitorIp, port);
        }
    }
}
