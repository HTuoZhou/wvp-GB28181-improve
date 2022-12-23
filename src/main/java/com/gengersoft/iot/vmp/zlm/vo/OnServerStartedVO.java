package com.gengersoft.iot.vmp.zlm.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author hanzai
 * @date 2022/12/23
 */
@Data
public class OnServerStartedVO {

    @JSONField(name = "general.mediaServerId")
    private String mediaServerId;

}
