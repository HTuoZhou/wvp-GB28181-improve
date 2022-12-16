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
@ApiModel(value = "DeviceAlarmBO对象", description = "")
public class DeviceAlarmBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String deviceId;

    private String channelId;

    private String alarmPriority;

    private String alarmMethod;

    private LocalDateTime alarmTime;

    private String alarmDescription;

    private Double longitude;

    private Double latitude;

    private String alarmType;

    private LocalDateTime createTime;


}
