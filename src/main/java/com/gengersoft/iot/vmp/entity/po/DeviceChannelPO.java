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
@TableName("device_channel")
@ApiModel(value = "DeviceChannelPO对象", description = "")
public class DeviceChannelPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("channelId")
    private String channelId;

    @TableField("name")
    private String name;

    @TableField("manufacture")
    private String manufacture;

    @TableField("model")
    private String model;

    @TableField("owner")
    private String owner;

    @TableField("civilCode")
    private String civilCode;

    @TableField("block")
    private String block;

    @TableField("address")
    private String address;

    @TableField("parentId")
    private String parentId;

    @TableField("safetyWay")
    private Integer safetyWay;

    @TableField("registerWay")
    private Integer registerWay;

    @TableField("certNum")
    private String certNum;

    @TableField("certifiable")
    private Integer certifiable;

    @TableField("errCode")
    private Integer errCode;

    @TableField("endTime")
    private LocalDateTime endTime;

    @TableField("secrecy")
    private String secrecy;

    @TableField("ipAddress")
    private String ipAddress;

    @TableField("port")
    private Integer port;

    @TableField("password")
    private String password;

    @TableField("PTZType")
    private Integer pTZType;

    @TableField("status")
    private Integer status;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("streamId")
    private String streamId;

    @TableField("deviceId")
    private String deviceId;

    @TableField("parental")
    private String parental;

    @TableField("hasAudio")
    private Boolean hasAudio;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("subCount")
    private Integer subCount;

    @TableField("longitudeGcj02")
    private Double longitudeGcj02;

    @TableField("latitudeGcj02")
    private Double latitudeGcj02;

    @TableField("longitudeWgs84")
    private Double longitudeWgs84;

    @TableField("latitudeWgs84")
    private Double latitudeWgs84;

    @TableField("businessGroupId")
    private String businessGroupId;

    @TableField("gpsTime")
    private LocalDateTime gpsTime;


}
