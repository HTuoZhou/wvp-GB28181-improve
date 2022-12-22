package com.gengersoft.iot.vmp.zlm;

import lombok.Data;
import org.json.JSONObject;

/**
 * @author hanzai
 * @date 2022/12/22
 */
@Data
public class ZLMResult {

    private Integer code;

    private String msg;

    private Integer result;

    private JSONObject data;

}
