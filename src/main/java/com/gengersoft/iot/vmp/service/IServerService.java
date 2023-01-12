package com.gengersoft.iot.vmp.service;

import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;

import java.util.List;

/**
 * @author hanzai
 * @date 2023/1/12
 */
public interface IServerService {

    /**
     * 流媒体服务列表
     * @return
     */
    List<MediaServerBO> list();
}
