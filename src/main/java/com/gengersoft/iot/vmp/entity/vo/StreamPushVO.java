package com.gengersoft.iot.vmp.entity.vo;

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
public class StreamPushVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String app;

    private String stream;

    private String totalReaderCount;

    private Integer originType;

    private String originTypeStr;

    private LocalDateTime createTime;

    private Integer aliveSecond;

    private String mediaServerId;

    private String serverId;

    private LocalDateTime pushTime;

    private Integer status;

    private LocalDateTime updateTime;

    private Integer pushIng;

    private Integer self;


}
