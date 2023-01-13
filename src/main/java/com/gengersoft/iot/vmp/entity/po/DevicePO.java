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
@TableName("device")
public class DevicePO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("deviceId")
    private String deviceId;

    @TableField("name")
    private String name;

    @TableField("manufacturer")
    private String manufacturer;

    @TableField("model")
    private String model;

    @TableField("firmware")
    private String firmware;

    @TableField("transport")
    private String transport;

    @TableField("streamMode")
    private String streamMode;

    @TableField("online")
    private Integer online;

    @TableField("registerTime")
    private LocalDateTime registerTime;

    @TableField("keepaliveTime")
    private LocalDateTime keepaliveTime;

    @TableField("ip")
    private String ip;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("port")
    private Integer port;

    @TableField("expires")
    private Integer expires;

    @TableField("subscribeCycleForCatalog")
    private Integer subscribeCycleForCatalog;

    @TableField("hostAddress")
    private String hostAddress;

    @TableField("charset")
    private String charset;

    @TableField("subscribeCycleForMobilePosition")
    private Integer subscribeCycleForMobilePosition;

    @TableField("mobilePositionSubmissionInterval")
    private Integer mobilePositionSubmissionInterval;

    @TableField("subscribeCycleForAlarm")
    private Integer subscribeCycleForAlarm;

    @TableField("ssrcCheck")
    private Integer ssrcCheck;

    @TableField("geoCoordSys")
    private String geoCoordSys;

    @TableField("treeType")
    private String treeType;

    @TableField("customName")
    private String customName;

    @TableField("password")
    private String password;

    @TableField("sdpIp")
    private String sdpIp;

    @TableField("localIp")
    private String localIp;


}
