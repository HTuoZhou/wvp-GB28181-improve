package com.gengersoft.iot.vmp.entity.po;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("gb_stream")
public class GbStreamPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gbStreamId", type = IdType.AUTO)
    private Integer gbStreamId;

    @TableField("app")
    private String app;

    @TableField("stream")
    private String stream;

    @TableField("gbId")
    private String gbId;

    @TableField("name")
    private String name;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("streamType")
    private String streamType;

    @TableField("mediaServerId")
    private String mediaServerId;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
