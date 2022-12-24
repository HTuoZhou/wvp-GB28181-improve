package com.gengersoft.iot.vmp.common.base;

/**
 * @author HTuoZhou
 */
public enum ResultCodeEnum {

    /**
     * 请求成功
     */
    SUCCESS(2000000, "请求成功"),

    /**
     * 求失败
     */
    FAIL(2000001, "请求失败"),

    /**
     * 参数校验异常
     */
    PARAMETER(2000002, "参数校验异常");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态描述信息
     */
    private final String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
