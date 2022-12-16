package com.gengersoft.iot.vmp.entity.vo;

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
@ApiModel(value = "StreamProxyVO对象", description = "")
public class StreamProxyVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String type;

    private String app;

    private String stream;

    private String url;

    private String srcUrl;

    private String dstUrl;

    private Integer timeoutMs;

    private String ffmpegCmdKey;

    private String rtpType;

    private String mediaServerId;

    private Boolean enableAudio;

    private Boolean enableMp4;

    private Boolean enable;

    private Boolean status;

    private Boolean enableRemoveNoneReader;

    private LocalDateTime createTime;

    private String name;

    private LocalDateTime updateTime;

    private Boolean enableDisableNoneReader;


}
