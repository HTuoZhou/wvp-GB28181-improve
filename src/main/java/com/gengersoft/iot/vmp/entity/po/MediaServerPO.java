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
@TableName("media_server")
@ApiModel(value = "MediaServerPO对象", description = "")
public class MediaServerPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("ip")
    private String ip;

    @TableField("hookIp")
    private String hookIp;

    @TableField("sdpIp")
    private String sdpIp;

    @TableField("streamIp")
    private String streamIp;

    @TableField("httpPort")
    private Integer httpPort;

    @TableField("httpSSlPort")
    private Integer httpSSlPort;

    @TableField("rtmpPort")
    private Integer rtmpPort;

    @TableField("rtmpSSlPort")
    private Integer rtmpSSlPort;

    @TableField("rtpProxyPort")
    private Integer rtpProxyPort;

    @TableField("rtspPort")
    private Integer rtspPort;

    @TableField("rtspSSLPort")
    private Integer rtspSSLPort;

    @TableField("autoConfig")
    private Integer autoConfig;

    @TableField("secret")
    private String secret;

    @TableField("rtpEnable")
    private Integer rtpEnable;

    @TableField("rtpPortRange")
    private String rtpPortRange;

    @TableField("recordAssistPort")
    private Integer recordAssistPort;

    @TableField("defaultServer")
    private Integer defaultServer;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("hookAliveInterval")
    private Integer hookAliveInterval;


}
