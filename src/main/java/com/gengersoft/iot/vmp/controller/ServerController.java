package com.gengersoft.iot.vmp.controller;

import cn.hutool.core.collection.CollUtil;
import com.gengersoft.iot.vmp.common.base.ApiFinalResult;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import com.gengersoft.iot.vmp.entity.vo.MediaServerVO;
import com.gengersoft.iot.vmp.service.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hanzai
 * @date 2023/1/12
 */
@RestController
@RequestMapping("/api/server")
public class ServerController {

    @Autowired
    private IServerService serverService;

    /**
     * 流媒体服务列表
     * @return
     */
    @GetMapping(value = "/media_server/list")
    public ApiFinalResult<List<MediaServerVO>> list() {
        List<MediaServerBO> mediaServerBOList = serverService.list();

        if (CollUtil.isEmpty(mediaServerBOList)) {
            return ApiFinalResult.success(Collections.emptyList());
        }

        return ApiFinalResult.success(mediaServerBOList.stream().map(MediaServerBO::bo2vo).collect(Collectors.toList()));
    }

}
