package com.gengersoft.iot.vmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import com.gengersoft.iot.vmp.entity.po.DevicePO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HTuoZhou
 * @since 2022-12-16
 */
public interface IDeviceService extends IService<DevicePO> {
    DeviceBO getDevice(String deviceId);

    void online(DeviceBO deviceBO);

    void offline(DeviceBO deviceBO);
}
