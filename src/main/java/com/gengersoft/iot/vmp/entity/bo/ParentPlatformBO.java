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
@ApiModel(value = "ParentPlatformBO对象", description = "")
public class ParentPlatformBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer enable;

    private String name;

    private String serverGBId;

    private String serverGBDomain;

    private String serverIP;

    private Integer serverPort;

    private String deviceGBId;

    private String deviceIp;

    private String devicePort;

    private String username;

    private String password;

    private String expires;

    private LocalDateTime keepTimeout;

    private String transport;

    private String characterSet;

    private String catalogId;

    private Integer ptz;

    private Integer rtcp;

    private Boolean status;

    private Integer startOfflinePush;

    private String administrativeDivision;

    private Integer catalogGroup;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String treeType;


}
