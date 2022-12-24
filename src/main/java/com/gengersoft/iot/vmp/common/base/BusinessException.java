package com.gengersoft.iot.vmp.common.base;

import lombok.Data;

/**
 * @author HTuoZhou
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private String msg;

    private Object data;

    public BusinessException() {
        this.code = ResultCodeEnum.FAIL.getCode();
        this.msg = ResultCodeEnum.FAIL.getMsg();
    }

    public BusinessException(Object data) {
        this.code = ResultCodeEnum.FAIL.getCode();
        this.msg = ResultCodeEnum.FAIL.getMsg();
        this.data = data;
    }

    public BusinessException(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }
}
