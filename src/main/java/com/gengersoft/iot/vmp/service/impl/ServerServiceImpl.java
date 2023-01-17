package com.gengersoft.iot.vmp.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import com.gengersoft.iot.vmp.entity.po.MediaServerPO;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.service.IServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hanzai
 * @date 2023/1/12
 */
@Service
@Slf4j
public class ServerServiceImpl implements IServerService {

    @Autowired
    private IMediaServerService mediaServerService;

    /**
     * 流媒体服务列表
     * @return
     */
    @Override
    public List<MediaServerBO> list() {
        List<MediaServerPO> mediaServerPOList = mediaServerService.list(Wrappers.emptyWrapper());

        if (CollUtil.isEmpty(mediaServerPOList)) {
            return Collections.emptyList();
        }

        return mediaServerPOList.stream().map(MediaServerPO::po2bo).collect(Collectors.toList());
    }
}
