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
@TableName("stream_proxy")
@ApiModel(value = "StreamProxyPO对象", description = "")
public class StreamProxyPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("type")
    private String type;

    @TableField("app")
    private String app;

    @TableField("stream")
    private String stream;

    @TableField("url")
    private String url;

    @TableField("src_url")
    private String srcUrl;

    @TableField("dst_url")
    private String dstUrl;

    @TableField("timeout_ms")
    private Integer timeoutMs;

    @TableField("ffmpeg_cmd_key")
    private String ffmpegCmdKey;

    @TableField("rtp_type")
    private String rtpType;

    @TableField("mediaServerId")
    private String mediaServerId;

    @TableField("enable_audio")
    private Boolean enableAudio;

    @TableField("enable_mp4")
    private Boolean enableMp4;

    @TableField("enable")
    private Boolean enable;

    @TableField("status")
    private Boolean status;

    @TableField("enable_remove_none_reader")
    private Boolean enableRemoveNoneReader;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("name")
    private String name;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("enable_disable_none_reader")
    private Boolean enableDisableNoneReader;


}
