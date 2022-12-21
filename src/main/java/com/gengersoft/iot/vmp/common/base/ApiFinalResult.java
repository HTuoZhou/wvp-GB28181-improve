package com.gengersoft.iot.vmp.common.base;

import lombok.Data;

/**
 * @author HTuoZhou
 */
@Data
public class ApiFinalResult<T> {

    private Integer code;

    private String message;

    private T data;

    public ApiFinalResult() {
    }

    public ApiFinalResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiFinalResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiFinalResult(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public ApiFinalResult(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }

    public static <T> ApiFinalResult<T> success(Integer code, String message) {
        return new ApiFinalResult<>(code, message);
    }

    public static <T> ApiFinalResult<T> success(Integer code, String message, T data) {
        return new ApiFinalResult<>(code, message, data);
    }

    public static <T> ApiFinalResult<T> success() {
        return new ApiFinalResult<>(ResultCodeEnum.SUCCESS);
    }

    public static <T> ApiFinalResult<T> success(T data) {
        return new ApiFinalResult<>(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> ApiFinalResult<T> error(Integer code, String message) {
        return new ApiFinalResult<>(code, message);
    }

    public static <T> ApiFinalResult<T> error(Integer code, String message, T data) {
        return new ApiFinalResult<>(code, message, data);
    }

    public static <T> ApiFinalResult<T> error(ResultCodeEnum resultCodeEnum) {
        return new ApiFinalResult<>(resultCodeEnum);
    }

    public static <T> ApiFinalResult<T> error(ResultCodeEnum resultCodeEnum, T data) {
        return new ApiFinalResult<>(resultCodeEnum, data);
    }

}
