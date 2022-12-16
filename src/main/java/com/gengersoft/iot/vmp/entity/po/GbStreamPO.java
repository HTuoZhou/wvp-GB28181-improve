package com.gengersoft.iot.vmp.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@ApiModel(value = "GbStreamPO对象", description = "")
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
