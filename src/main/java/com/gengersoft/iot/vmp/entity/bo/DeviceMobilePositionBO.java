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
public class DeviceMobilePositionBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String deviceId;

    private String channelId;

    private String deviceName;

    private LocalDateTime time;

    private Double longitude;

    private Double latitude;

    private Double altitude;

    private Double speed;

    private Double direction;

    private String reportSource;

    private Double longitudeGcj02;

    private Double latitudeGcj02;

    private Double longitudeWgs84;

    private Double latitudeWgs84;

    private LocalDateTime createTime;


}
