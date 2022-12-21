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
@TableName("log")
public class LogPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("type")
    private String type;

    @TableField("uri")
    private String uri;

    @TableField("address")
    private String address;

    @TableField("result")
    private String result;

    @TableField("timing")
    private Long timing;

    @TableField("username")
    private String username;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
