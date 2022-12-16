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
@ApiModel(value = "GbStreamVO对象", description = "")
public class GbStreamVO implements Serializable {

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
