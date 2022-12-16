package com.gengersoft.iot.vmp.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value = "PlatformGbStreamBO对象", description = "")
public class PlatformGbStreamBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String platformId;

    private String catalogId;

    private Integer gbStreamId;


}
