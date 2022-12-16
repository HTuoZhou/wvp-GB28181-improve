package com.gengersoft.iot.vmp.common.base;

/**
 * @author HTuoZhou
 */
public enum ResultCodeEnum {

    /**
     * 请求成功
     */
    SUCCESS(200, "成功"),
    /**
     * 未认证
     */
    FAILED_UN_AUTHENTICATION(401, "未认证"),
    /**
     * 未授权
     */
    FAILED_UN_AUTHORIZATION(403, "未授权"),
    /**
     * 请求失败
     */
    ERROR(500, "失败"),
    /**
     * 参数校验异常
     */
    FAILED_PARAMETER(600, "参数校验异常");


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
