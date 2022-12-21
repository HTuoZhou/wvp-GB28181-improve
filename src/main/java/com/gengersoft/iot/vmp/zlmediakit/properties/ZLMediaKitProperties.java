package com.gengersoft.iot.vmp.zlmediakit.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@ConfigurationProperties(prefix = "zlm")
@Data
public class ZLMediaKitProperties {

    private String serverId;
    private String ip;
    private String hookIp;
    private String sdpIp;
    private String streamIp;
    private Integer httpPort;
    private Integer httpSslPort;
    private Integer rtmpPort;
    private Integer rtmpSslPort;
    private Integer rtspPort;
    private Integer rtspSslPort;
    private Integer rtpProxyPort;
    private Boolean autoConfig;
    private String secret;
    private Boolean rtpEnable;
    private String rtpPortRange;
    private Integer recordAssistPort;
    private Integer hookAliveInterval;

}
