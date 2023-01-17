package com.gengersoft.iot.vmp.zlm;

import lombok.Data;

/**
 * @author hanzai
 * @date 2022/12/22
 */
@Data
public class ZLMResult {

    private Integer code;

    private Integer changed;

    private String msg;

    private Integer result;

    private Object data;

}
