package com.gengersoft.iot.vmp.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

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
@TableName("media_server")
public class MediaServerPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
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

    @TableField("httpSslPort")
    private Integer httpSslPort;

    @TableField("rtmpPort")
    private Integer rtmpPort;

    @TableField("rtmpSslPort")
    private Integer rtmpSslPort;

    @TableField("rtpProxyPort")
    private Integer rtpProxyPort;

    @TableField("rtspPort")
    private Integer rtspPort;

    @TableField("rtspSslPort")
    private Integer rtspSslPort;

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

    @TableField("hookAliveLastTime")
    private LocalDateTime hookAliveLastTime;

    @TableField("status")
    private Integer status;

    public void bo2po(MediaServerBO bo) {
        this.setIp(bo.getId());
        this.setIp(bo.getIp());
        this.setHookIp(bo.getHookIp());
        this.setSdpIp(bo.getSdpIp());
        this.setStreamIp(bo.getStreamIp());
        this.setHttpPort(bo.getHttpPort());
        this.setHttpSslPort(bo.getHttpSslPort());
        this.setRtmpPort(bo.getRtmpPort());
        this.setRtmpSslPort(bo.getRtmpSslPort());
        this.setRtpProxyPort(bo.getRtpProxyPort());
        this.setRtspPort(bo.getRtspPort());
        this.setRtspSslPort(bo.getRtspSslPort());
        this.setAutoConfig(bo.getAutoConfig());
        this.setSecret(bo.getSecret());
        this.setRtpEnable(bo.getRtpEnable());
        this.setRtpPortRange(bo.getRtpPortRange());
        this.setRecordAssistPort(bo.getRecordAssistPort());
        this.setDefaultServer(bo.getDefaultServer());
        this.setHookAliveInterval(bo.getHookAliveInterval());
    }

    public MediaServerBO po2bo() {
        MediaServerBO bo = new MediaServerBO();
        BeanUtils.copyProperties(this,bo);

        return bo;
    }

}
