package com.gengersoft.iot.vmp.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
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
@TableName("media_server")
public class MediaServerPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("serverId")
    private String serverId;

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

    @TableField("hookAliveLastTime")
    private LocalDateTime hookAliveLastTime;

    public void bo2po(MediaServerBO mediaServerBO) {
        this.setServerId(mediaServerBO.getServerId());
        this.setIp(mediaServerBO.getIp());
        this.setHookIp(mediaServerBO.getHookIp());
        this.setSdpIp(mediaServerBO.getSdpIp());
        this.setStreamIp(mediaServerBO.getStreamIp());
        this.setHttpPort(mediaServerBO.getHttpPort());
        this.setHttpSSlPort(mediaServerBO.getHttpSSlPort());
        this.setRtmpPort(mediaServerBO.getRtmpPort());
        this.setRtmpSSlPort(mediaServerBO.getRtmpSSlPort());
        this.setRtpProxyPort(mediaServerBO.getRtpProxyPort());
        this.setRtspPort(mediaServerBO.getRtspPort());
        this.setRtspSSLPort(mediaServerBO.getRtspSSLPort());
        this.setAutoConfig(mediaServerBO.getAutoConfig());
        this.setSecret(mediaServerBO.getSecret());
        this.setRtpEnable(mediaServerBO.getRtpEnable());
        this.setRtpPortRange(mediaServerBO.getRtpPortRange());
        this.setRecordAssistPort(mediaServerBO.getRecordAssistPort());
        this.setDefaultServer(mediaServerBO.getDefaultServer());
        this.setHookAliveInterval(mediaServerBO.getHookAliveInterval());
    }

    public MediaServerBO po2vo() {
        MediaServerBO mediaServerBO = new MediaServerBO();

        mediaServerBO.setId(getId());
        mediaServerBO.setServerId(getServerId());
        mediaServerBO.setIp(getIp());
        mediaServerBO.setHookIp(getHookIp());
        mediaServerBO.setSdpIp(getSdpIp());
        mediaServerBO.setStreamIp(getStreamIp());
        mediaServerBO.setHttpPort(getHttpPort());
        mediaServerBO.setHttpSSlPort(getHttpSSlPort());
        mediaServerBO.setRtmpPort(getRtmpPort());
        mediaServerBO.setRtmpSSlPort(getRtmpSSlPort());
        mediaServerBO.setRtpProxyPort(getRtpProxyPort());
        mediaServerBO.setRtspPort(getRtspPort());
        mediaServerBO.setRtspSSLPort(getRtspSSLPort());
        mediaServerBO.setAutoConfig(getAutoConfig());
        mediaServerBO.setSecret(getSecret());
        mediaServerBO.setRtpEnable(getRtpEnable());
        mediaServerBO.setRtpPortRange(getRtpPortRange());
        mediaServerBO.setRecordAssistPort(getRecordAssistPort());
        mediaServerBO.setDefaultServer(getDefaultServer());
        mediaServerBO.setCreateTime(getCreateTime());
        mediaServerBO.setUpdateTime(getUpdateTime());
        mediaServerBO.setHookAliveInterval(getHookAliveInterval());
        mediaServerBO.setHookAliveLastTime(getHookAliveLastTime());

        return mediaServerBO;
    }

}
