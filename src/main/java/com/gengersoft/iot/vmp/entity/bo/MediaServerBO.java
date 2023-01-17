package com.gengersoft.iot.vmp.entity.bo;

import com.gengersoft.iot.vmp.entity.po.MediaServerPO;
import com.gengersoft.iot.vmp.entity.vo.MediaServerVO;
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
public class MediaServerBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String ip;

    private String hookIp;

    private String sdpIp;

    private String streamIp;

    private Integer httpPort;

    private Integer httpSSlPort;

    private Integer rtmpPort;

    private Integer rtmpSSlPort;

    private Integer rtpProxyPort;

    private Integer rtspPort;

    private Integer rtspSSLPort;

    private Integer autoConfig;

    private String secret;

    private Integer rtpEnable;

    private String rtpPortRange;

    private Integer recordAssistPort;

    private Integer defaultServer;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer hookAliveInterval;

    private LocalDateTime hookAliveLastTime;

    private Integer status;

    public MediaServerPO bo2po() {
        MediaServerPO mediaServerPO = new MediaServerPO();

        mediaServerPO.setId(getId());
        mediaServerPO.setIp(getIp());
        mediaServerPO.setHookIp(getHookIp());
        mediaServerPO.setSdpIp(getSdpIp());
        mediaServerPO.setStreamIp(getStreamIp());
        mediaServerPO.setHttpPort(getHttpPort());
        mediaServerPO.setHttpSSlPort(getHttpSSlPort());
        mediaServerPO.setRtmpPort(getRtmpPort());
        mediaServerPO.setRtmpSSlPort(getRtmpSSlPort());
        mediaServerPO.setRtpProxyPort(getRtpProxyPort());
        mediaServerPO.setRtspPort(getRtspPort());
        mediaServerPO.setRtspSSLPort(getRtspSSLPort());
        mediaServerPO.setAutoConfig(getAutoConfig());
        mediaServerPO.setSecret(getSecret());
        mediaServerPO.setRtpEnable(getRtpEnable());
        mediaServerPO.setRtpPortRange(getRtpPortRange());
        mediaServerPO.setRecordAssistPort(getRecordAssistPort());
        mediaServerPO.setDefaultServer(getDefaultServer());
        mediaServerPO.setHookAliveInterval(getHookAliveInterval());

        return mediaServerPO;
    }

    public MediaServerVO bo2vo() {
        MediaServerVO mediaServerVO = new MediaServerVO();

        mediaServerVO.setId(getId());
        mediaServerVO.setIp(getIp());
        mediaServerVO.setHookIp(getHookIp());
        mediaServerVO.setSdpIp(getSdpIp());
        mediaServerVO.setStreamIp(getStreamIp());
        mediaServerVO.setHttpPort(getHttpPort());
        mediaServerVO.setHttpSSlPort(getHttpSSlPort());
        mediaServerVO.setRtmpPort(getRtmpPort());
        mediaServerVO.setRtmpSSlPort(getRtmpSSlPort());
        mediaServerVO.setRtpProxyPort(getRtpProxyPort());
        mediaServerVO.setRtspPort(getRtspPort());
        mediaServerVO.setRtspSSLPort(getRtspSSLPort());
        mediaServerVO.setAutoConfig(getAutoConfig());
        mediaServerVO.setSecret(getSecret());
        mediaServerVO.setRtpEnable(getRtpEnable());
        mediaServerVO.setRtpPortRange(getRtpPortRange());
        mediaServerVO.setRecordAssistPort(getRecordAssistPort());
        mediaServerVO.setDefaultServer(getDefaultServer());
        mediaServerVO.setCreateTime(getCreateTime());
        mediaServerVO.setUpdateTime(getUpdateTime());
        mediaServerVO.setHookAliveInterval(getHookAliveInterval());
        mediaServerVO.setHookAliveLastTime(getHookAliveLastTime());
        mediaServerVO.setStatus(getStatus());

        return mediaServerVO;
    }
}
