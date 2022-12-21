package com.gengersoft.iot.vmp.zlmediakit;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gengersoft.iot.vmp.entity.po.MediaServerPO;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlmediakit.properties.ZLMediaKitProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@Order(2)
@Slf4j
public class ZLMediaKitRunner implements CommandLineRunner {

    @Autowired
    private ZLMediaKitProperties zlMediaKitProperties;

    @Autowired
    private IMediaServerService mediaServerService;

    @Override
    public void run(String... args) throws Exception {
        MediaServerPO mediaServerPO = Optional
                .ofNullable(mediaServerService.getOne(Wrappers.<MediaServerPO>lambdaQuery().eq(MediaServerPO::getDefaultServer, 1)))
                .orElse(new MediaServerPO());

        mediaServerPO.setServerId(zlMediaKitProperties.getServerId());
        mediaServerPO.setIp(zlMediaKitProperties.getIp());
        mediaServerPO.setHookIp(zlMediaKitProperties.getHookIp());
        mediaServerPO.setSdpIp(zlMediaKitProperties.getSdpIp());
        mediaServerPO.setStreamIp(zlMediaKitProperties.getStreamIp());
        mediaServerPO.setHttpPort(zlMediaKitProperties.getHttpPort());
        mediaServerPO.setHttpSSlPort(zlMediaKitProperties.getHttpSslPort());
        mediaServerPO.setRtmpPort(zlMediaKitProperties.getRtmpPort());
        mediaServerPO.setRtmpSSlPort(zlMediaKitProperties.getRtmpSslPort());
        mediaServerPO.setRtpProxyPort(zlMediaKitProperties.getRtpProxyPort());
        mediaServerPO.setRtspPort(zlMediaKitProperties.getRtspPort());
        mediaServerPO.setRtspSSLPort(zlMediaKitProperties.getRtspSslPort());
        mediaServerPO.setAutoConfig(zlMediaKitProperties.getAutoConfig() ? 1 : 0);
        mediaServerPO.setSecret(zlMediaKitProperties.getSecret());
        mediaServerPO.setRtpEnable(zlMediaKitProperties.getRtpEnable() ? 1 : 0);
        mediaServerPO.setRtpPortRange(zlMediaKitProperties.getRtpPortRange());
        mediaServerPO.setRecordAssistPort(zlMediaKitProperties.getRecordAssistPort());
        mediaServerPO.setDefaultServer(1);
        mediaServerPO.setHookAliveInterval(zlMediaKitProperties.getHookAliveInterval());

        mediaServerService.saveOrUpdate(mediaServerPO);
    }

}
