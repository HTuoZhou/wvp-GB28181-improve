package com.gengersoft.iot.vmp.common.base;

import lombok.Data;

/**
 * @author HTuoZhou
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private String message;

    private Object data;

    public BusinessException() {
        this.code = ResultCodeEnum.ERROR.getCode();
        this.message = ResultCodeEnum.ERROR.getMessage();
    }

    public BusinessException(Object data) {
        this.code = ResultCodeEnum.ERROR.getCode();
        this.message = ResultCodeEnum.ERROR.getMessage();
        this.data = data;
    }

    public BusinessException(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }
}
