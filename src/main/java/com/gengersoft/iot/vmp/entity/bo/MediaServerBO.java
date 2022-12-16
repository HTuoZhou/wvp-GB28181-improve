package com.gengersoft.iot.vmp.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author HTuoZhou
 * @since 2022-12-16
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "MediaServerBO对象", description = "")
public class MediaServerBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String ip;

    private String hookIp;

    private String sdpIp;

    private String streamIp;

    private Integer httpPort;

    private Integer httpSSlPort;

    private Integer rtmpPort;

    private Integer rtmpSSlPort;

    private Integer rtpProxyPort;

    private Integer rtspPort;

    private Integer rtspSSLPort;

    private Integer autoConfig;

    private String secret;

    private Integer rtpEnable;

    private String rtpPortRange;

    private Integer recordAssistPort;

    private Integer defaultServer;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer hookAliveInterval;


}
