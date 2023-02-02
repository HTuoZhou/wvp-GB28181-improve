package com.gengersoft.iot.vmp.gb28181.transmit.cmd;

import com.gengersoft.iot.vmp.entity.bo.DeviceBO;

/**
 * @author hanzai
 * @date 2023/2/1
 */
public interface ISIPCommander {

    /**
     * 查询设备以及通道信息
     * @param deviceBO
     */
    void deviceInfoQuery(DeviceBO deviceBO);
}
