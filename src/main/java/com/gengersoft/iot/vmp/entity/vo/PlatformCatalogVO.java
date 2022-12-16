package com.gengersoft.iot.vmp.entity.vo;

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
@ApiModel(value = "PlatformCatalogVO对象", description = "")
public class PlatformCatalogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String platformId;

    private String name;

    private String parentId;

    private String civilCode;

    private String businessGroupId;


}
