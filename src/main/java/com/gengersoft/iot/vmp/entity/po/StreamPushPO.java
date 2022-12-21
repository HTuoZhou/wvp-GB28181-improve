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
@TableName("stream_push")
public class StreamPushPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("app")
    private String app;

    @TableField("stream")
    private String stream;

    @TableField("totalReaderCount")
    private String totalReaderCount;

    @TableField("originType")
    private Integer originType;

    @TableField("originTypeStr")
    private String originTypeStr;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("aliveSecond")
    private Integer aliveSecond;

    @TableField("mediaServerId")
    private String mediaServerId;

    @TableField("serverId")
    private String serverId;

    @TableField("pushTime")
    private LocalDateTime pushTime;

    @TableField("status")
    private Integer status;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("pushIng")
    private Integer pushIng;

    @TableField("self")
    private Integer self;


}
