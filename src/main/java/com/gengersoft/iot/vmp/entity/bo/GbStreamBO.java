package com.gengersoft.iot.vmp.entity.bo;

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
public class GbStreamBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer gbStreamId;

    private String app;

    private String stream;

    private String gbId;

    private String name;

    private Double longitude;

    private Double latitude;

    private String streamType;

    private String mediaServerId;

    private LocalDateTime createTime;


}
