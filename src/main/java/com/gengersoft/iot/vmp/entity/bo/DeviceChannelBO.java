package com.gengersoft.iot.vmp.entity.bo;

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
public class DeviceChannelBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String channelId;

    private String name;

    private String manufacture;

    private String model;

    private String owner;

    private String civilCode;

    private String block;

    private String address;

    private String parentId;

    private Integer safetyWay;

    private Integer registerWay;

    private String certNum;

    private Integer certifiable;

    private Integer errCode;

    private LocalDateTime endTime;

    private String secrecy;

    private String ipAddress;

    private Integer port;

    private String password;

    private Integer pTZType;

    private Integer status;

    private Double longitude;

    private Double latitude;

    private String streamId;

    private String deviceId;

    private String parental;

    private Boolean hasAudio;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer subCount;

    private Double longitudeGcj02;

    private Double latitudeGcj02;

    private Double longitudeWgs84;

    private Double latitudeWgs84;

    private String businessGroupId;

    private LocalDateTime gpsTime;


}
