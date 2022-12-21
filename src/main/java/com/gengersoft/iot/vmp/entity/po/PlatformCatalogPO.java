package com.gengersoft.iot.vmp.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("platform_catalog")
public class PlatformCatalogPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("platformId")
    private String platformId;

    @TableField("name")
    private String name;

    @TableField("parentId")
    private String parentId;

    @TableField("civilCode")
    private String civilCode;

    @TableField("businessGroupId")
    private String businessGroupId;


}
