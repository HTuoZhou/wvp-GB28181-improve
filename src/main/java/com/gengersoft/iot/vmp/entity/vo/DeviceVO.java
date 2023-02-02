package com.gengersoft.iot.vmp.entity.vo;

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
public class DeviceVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String deviceId;

    private String name;

    private String manufacturer;

    private String model;

    private String firmware;

    private String transport;

    private String streamMode;

    private Integer online;

    private LocalDateTime registerTime;

    private LocalDateTime keepaliveTime;

    private String ip;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer port;

    private Integer expires;

    private Integer subscribeCycleForCatalog;

    private String hostAddress;

    private String charset;

    private Integer subscribeCycleForMobilePosition;

    private Integer mobilePositionSubmissionInterval;

    private Integer subscribeCycleForAlarm;

    private Integer ssrcCheck;

    private String geoCoordSys;

    private String treeType;

    private String customName;

    private String password;

    private String sdpIp;

    private String localIp;


}
