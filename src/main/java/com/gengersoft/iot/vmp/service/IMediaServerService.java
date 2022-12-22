package com.gengersoft.iot.vmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import com.gengersoft.iot.vmp.entity.po.MediaServerPO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HTuoZhou
 * @since 2022-12-16
 */
public interface IMediaServerService extends IService<MediaServerPO> {

    Boolean saveOrUpdateMediaServer(MediaServerBO mediaServerBO);

}
