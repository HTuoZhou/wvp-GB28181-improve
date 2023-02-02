package com.gengersoft.iot.vmp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gengersoft.iot.vmp.entity.bo.DeviceBO;
import com.gengersoft.iot.vmp.entity.po.DevicePO;
import com.gengersoft.iot.vmp.gb28181.transmit.cmd.ISIPCommander;
import com.gengersoft.iot.vmp.mapper.DeviceMapper;
import com.gengersoft.iot.vmp.service.IDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HTuoZhou
 * @since 2022-12-16
 */
@Service
@Slf4j
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DevicePO> implements IDeviceService {

    @Autowired
    private ISIPCommander sipCommander;

    @Override
    public DeviceBO getDevice(String deviceId) {
        DevicePO devicePO = this.getOne(Wrappers.<DevicePO>lambdaQuery().eq(DevicePO::getDeviceId, deviceId));
        return DeviceBO.po2bo(devicePO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void online(DeviceBO deviceBO) {
        log.info("[Device] [Device deviceId:{}] 设备上线", deviceBO.getDeviceId());

        // 第一次上线 或者设备之前是离线状态 查询设备以及通道信息
        if (Objects.isNull(deviceBO.getCreateTime())) {
            deviceBO.setOnline(1);
            log.info("[Device] [Device deviceId:{}] 设备首次注册,查询设备以及通道信息!", deviceBO.getDeviceId());
            this.saveOrUpdate(DevicePO.bo2po(deviceBO));

            try {
                sipCommander.deviceInfoQuery(deviceBO);
            } catch (Exception e) {
                log.error("[Device] [Device deviceId:{}] 查询设备以及通道信息失败!", deviceBO.getDeviceId());
            }
        } else {
            if (deviceBO.getOnline() == 0) {
                deviceBO.setOnline(1);

                log.info("[Device] [Device deviceId:{}] 设备离线状态下重新注册,查询设备以及通道信息!", deviceBO.getDeviceId());
                this.saveOrUpdate(DevicePO.bo2po(deviceBO));

                try {
                    sipCommander.deviceInfoQuery(deviceBO);
                } catch (Exception e) {
                    log.error("[Device] [Device deviceId:{}] 查询设备以及通道信息失败!", deviceBO.getDeviceId());
                }
            }
        }
    }

    @Override
    public void offline(DeviceBO deviceBO) {
        log.info("[Device] [Device deviceId:{}] 设备离线", deviceBO.getDeviceId());
    }
}
