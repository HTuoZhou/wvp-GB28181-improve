package com.gengersoft.iot.vmp.zlm.properties;

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
public class ZLMProperties {

    private String serverId;
    private String ip;
    private String hookIp;
    private String sdpIp;
    private String streamIp;
    private Integer httpPort;
    private Integer httpSslPort = 0;
    private Integer rtmpPort;
    private Integer rtmpSslPort = 0;
    private Integer rtspPort;
    private Integer rtspSslPort = 0;
    private Integer rtpProxyPort;
    private Boolean autoConfig;
    private String secret;
    private Boolean rtpEnable;
    private String rtpPortRange;
    private Integer recordAssistPort;
    private Integer hookAliveInterval;

}
