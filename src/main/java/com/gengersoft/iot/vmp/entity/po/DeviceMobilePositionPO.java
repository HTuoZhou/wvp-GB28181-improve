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
@TableName("device_mobile_position")
@ApiModel(value = "DeviceMobilePositionPO对象", description = "")
public class DeviceMobilePositionPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("deviceId")
    private String deviceId;

    @TableField("channelId")
    private String channelId;

    @TableField("deviceName")
    private String deviceName;

    @TableField("time")
    private LocalDateTime time;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("altitude")
    private Double altitude;

    @TableField("speed")
    private Double speed;

    @TableField("direction")
    private Double direction;

    @TableField("reportSource")
    private String reportSource;

    @TableField("longitudeGcj02")
    private Double longitudeGcj02;

    @TableField("latitudeGcj02")
    private Double latitudeGcj02;

    @TableField("longitudeWgs84")
    private Double longitudeWgs84;

    @TableField("latitudeWgs84")
    private Double latitudeWgs84;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
