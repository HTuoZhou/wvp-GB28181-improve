package com.gengersoft.iot.vmp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import com.gengersoft.iot.vmp.entity.po.MediaServerPO;
import com.gengersoft.iot.vmp.mapper.MediaServerMapper;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class MediaServerServiceImpl extends ServiceImpl<MediaServerMapper, MediaServerPO> implements IMediaServerService {

    @Override
    public Boolean saveOrUpdateMediaServer(MediaServerBO mediaServerBO) {
        MediaServerPO mediaServerPO = getOne(Wrappers.<MediaServerPO>lambdaQuery().eq(MediaServerPO::getDefaultServer, 1));
        if (Objects.isNull(mediaServerPO)) {
            mediaServerPO = mediaServerBO.bo2po();
        } else {
            mediaServerPO.bo2po(mediaServerBO);
        }
        return this.saveOrUpdate(mediaServerPO);
    }
}
