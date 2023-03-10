package com.gengersoft.iot.vmp.zlm.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gengersoft.iot.vmp.entity.po.MediaServerPO;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlm.vo.OnServerKeepAliveVO;
import com.gengersoft.iot.vmp.zlm.vo.OnServerStartedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author hanzai
 * @date 2022/12/23
 * zlm http hook控制器
 */
@RestController
@RequestMapping("/zlm/index/hook")
@Slf4j
public class ZLMHttpHookController {

    @Autowired
    private IMediaServerService mediaServerService;

    private static final JSONObject ZLM_RES_SUCCESS = new JSONObject();

    static {
        ZLM_RES_SUCCESS.put("code", 0);
        ZLM_RES_SUCCESS.put("msg", "success");
    }

    @PostMapping("/on_server_keepalive")
    public JSONObject onServerKeepAlive(@RequestBody OnServerKeepAliveVO onServerKeepAliveVO) {
        log.info("[ZLM HTTP HOOK] 收到 [ZLM ServerId：{}] 心跳", onServerKeepAliveVO.getMediaServerId());

        mediaServerService.update(Wrappers.<MediaServerPO>lambdaUpdate()
                .eq(MediaServerPO::getId,onServerKeepAliveVO.getMediaServerId())
                .set(MediaServerPO::getHookAliveLastTime, LocalDateTime.now())
                .set(MediaServerPO::getStatus,1));

        return ZLM_RES_SUCCESS;
    }

    @PostMapping("/on_server_started")
    public JSONObject onServerStarted(@RequestBody OnServerStartedVO onServerStartedVO) {
        log.info("[ZLM HTTP HOOK] 收到 [ZLM ServerId：{}] 启动", onServerStartedVO.getMediaServerId());

        mediaServerService.update(Wrappers.<MediaServerPO>lambdaUpdate()
                .eq(MediaServerPO::getId,onServerStartedVO.getMediaServerId())
                .set(MediaServerPO::getStatus,1));

        return ZLM_RES_SUCCESS;
    }

}
