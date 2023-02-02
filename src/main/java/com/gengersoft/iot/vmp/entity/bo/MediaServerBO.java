package com.gengersoft.iot.vmp.entity.bo;

import com.gengersoft.iot.vmp.entity.po.MediaServerPO;
import com.gengersoft.iot.vmp.entity.vo.MediaServerVO;
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
public class MediaServerBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String ip;

    private String hookIp;

    private String sdpIp;

    private String streamIp;

    private Integer httpPort;

    private Integer httpSslPort;

    private Integer rtmpPort;

    private Integer rtmpSslPort;

    private Integer rtpProxyPort;

    private Integer rtspPort;

    private Integer rtspSslPort;

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
        MediaServerPO po = new MediaServerPO();
        BeanUtils.copyProperties(this,po);

        return po;
    }

    public MediaServerVO bo2vo() {
        MediaServerVO vo = new MediaServerVO();
        BeanUtils.copyProperties(this,vo);

        return vo;
    }
}
