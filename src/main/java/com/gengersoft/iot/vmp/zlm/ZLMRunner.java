package com.gengersoft.iot.vmp.zlm;

import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlm.properties.ZLMProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@Order(2)
@Slf4j
public class ZLMRunner implements CommandLineRunner {

    @Autowired
    private ZLMProperties ZLMProperties;

    @Autowired
    private IMediaServerService mediaServerService;

    @Override
    public void run(String... args) throws Exception {
        MediaServerBO mediaServerBO = properties2bo();
        mediaServerService.saveOrUpdateMediaServer(mediaServerBO);

        
    }

    public MediaServerBO properties2bo() {
        MediaServerBO mediaServerBO = new MediaServerBO();

        mediaServerBO.setServerId(ZLMProperties.getServerId());
        mediaServerBO.setIp(ZLMProperties.getIp());
        mediaServerBO.setHookIp(ZLMProperties.getHookIp());
        mediaServerBO.setSdpIp(ZLMProperties.getSdpIp());
        mediaServerBO.setStreamIp(ZLMProperties.getStreamIp());
        mediaServerBO.setHttpPort(ZLMProperties.getHttpPort());
        mediaServerBO.setHttpSSlPort(ZLMProperties.getHttpSslPort());
        mediaServerBO.setRtmpPort(ZLMProperties.getRtmpPort());
        mediaServerBO.setRtmpSSlPort(ZLMProperties.getRtmpSslPort());
        mediaServerBO.setRtpProxyPort(ZLMProperties.getRtpProxyPort());
        mediaServerBO.setRtspPort(ZLMProperties.getRtspPort());
        mediaServerBO.setRtspSSLPort(ZLMProperties.getRtspSslPort());
        mediaServerBO.setAutoConfig(ZLMProperties.getAutoConfig() ? 1 : 0);
        mediaServerBO.setSecret(ZLMProperties.getSecret());
        mediaServerBO.setRtpEnable(ZLMProperties.getRtpEnable() ? 1 : 0);
        mediaServerBO.setRtpPortRange(ZLMProperties.getRtpPortRange());
        mediaServerBO.setRecordAssistPort(ZLMProperties.getRecordAssistPort());
        mediaServerBO.setDefaultServer(1);
        mediaServerBO.setHookAliveInterval(ZLMProperties.getHookAliveInterval());

        return mediaServerBO;
    }

}
