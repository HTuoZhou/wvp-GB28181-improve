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
@TableName("parent_platform")
public class ParentPlatformPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("enable")
    private Integer enable;

    @TableField("name")
    private String name;

    @TableField("serverGBId")
    private String serverGBId;

    @TableField("serverGBDomain")
    private String serverGBDomain;

    @TableField("serverIP")
    private String serverIP;

    @TableField("serverPort")
    private Integer serverPort;

    @TableField("deviceGBId")
    private String deviceGBId;

    @TableField("deviceIp")
    private String deviceIp;

    @TableField("devicePort")
    private String devicePort;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("expires")
    private String expires;

    @TableField("keepTimeout")
    private LocalDateTime keepTimeout;

    @TableField("transport")
    private String transport;

    @TableField("characterSet")
    private String characterSet;

    @TableField("catalogId")
    private String catalogId;

    @TableField("ptz")
    private Integer ptz;

    @TableField("rtcp")
    private Integer rtcp;

    @TableField("status")
    private Boolean status;

    @TableField("startOfflinePush")
    private Integer startOfflinePush;

    @TableField("administrativeDivision")
    private String administrativeDivision;

    @TableField("catalogGroup")
    private Integer catalogGroup;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("treeType")
    private String treeType;


}
