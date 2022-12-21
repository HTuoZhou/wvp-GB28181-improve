package com.gengersoft.iot.vmp.gb28181.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@ConfigurationProperties(prefix = "sip")
@Data
public class SIPProperties {

    private String ip;
    private Integer port;
    private String domain;
    private String id;
    private String password;
    private Integer registerTimeInterval;
    private Integer ptzSpeed;
    private Boolean alarm;

}
