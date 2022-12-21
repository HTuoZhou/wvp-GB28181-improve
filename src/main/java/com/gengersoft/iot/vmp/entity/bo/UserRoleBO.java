package com.gengersoft.iot.vmp.entity.bo;

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
public class UserRoleBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String authority;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
