package com.gengersoft.iot.vmp.entity.vo;

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
@ApiModel(value = "LogVO对象", description = "")
public class LogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String type;

    private String uri;

    private String address;

    private String result;

    private Long timing;

    private String username;

    private LocalDateTime createTime;


}
