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
@TableName("device_alarm")
public class DeviceAlarmPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("deviceId")
    private String deviceId;

    @TableField("channelId")
    private String channelId;

    @TableField("alarmPriority")
    private String alarmPriority;

    @TableField("alarmMethod")
    private String alarmMethod;

    @TableField("alarmTime")
    private LocalDateTime alarmTime;

    @TableField("alarmDescription")
    private String alarmDescription;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("alarmType")
    private String alarmType;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
