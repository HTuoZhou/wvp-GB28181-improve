package com.gengersoft.iot.vmp.zlm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gengersoft.iot.vmp.common.util.CommonUtils;
import com.gengersoft.iot.vmp.common.util.HttpUtils;
import com.gengersoft.iot.vmp.constant.CommonConstant;
import com.gengersoft.iot.vmp.constant.ZLMConstant;
import com.gengersoft.iot.vmp.entity.bo.MediaServerBO;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlm.properties.ZLMProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hanzai
 * @date 2022/12/22
 */
@Component
@Slf4j
public class ZLMManager {

    @Autowired
    private Environment environment;

    @Autowired
    private ZLMProperties zlmProperties;

    @Autowired
    private IMediaServerService mediaServerService;

    /**
     * 获取服务器配置
     */
    public String getServerConfig() {
        ZLMResult result = postForm(ZLMConstant.GET_SERVER_CONFIG);

        if (Objects.nonNull(result) && result.getCode() == 0) {
            log.info("[ZLM] [ZLM ServerId:{}] 获取服务器配置成功!", zlmProperties.getId());
            JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(result.getData()));
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(jsonArray.get(0)));
            return (String) jsonObject.get("general.mediaServerId");
        } else {
            log.error("[ZLM] [ZLM ServerId:{}] 获取服务器配置失败,请确认ZLM是否启动!", zlmProperties.getId());
        }

        return StringUtils.EMPTY;
    }

    /**
     * 设置服务器配置
     */
    public void setServerConfig() {
        String hookPrefix;
        String hookIp = zlmProperties.getHookIp();
        if (CommonConstant.LINUX_OS && Objects.equals(zlmProperties.getHookIp(), CommonConstant.DEFAULT_LOCAL_IP)) {
            hookIp = CommonUtils.localIP();
        }
        // hookPrefix = String.format(ZLMConstant.HOOK_URL_FMT, hookIp + ":" +
        //         environment.getProperty(CommonConstant.SERVER_PORT) +
        //         environment.getProperty(CommonConstant.SERVER_SERVLET_CONTEXT_PATH));

        hookPrefix = String.format(ZLMConstant.HOOK_URL_FMT, hookIp + ":" +
                environment.getProperty(CommonConstant.SERVER_PORT));

        Map<String, Object> param = new HashMap<>();
        param.put("api.secret", zlmProperties.getSecret());
        param.put("general.mediaServerId", zlmProperties.getId());
        param.put("hook.alive_interval", zlmProperties.getHookAliveInterval());
        param.put("hook.enable", "1");
        param.put("hook.on_flow_report", String.format("%s/on_flow_report", hookPrefix));
        param.put("hook.on_http_access", String.format("%s/on_http_access", hookPrefix));
        param.put("hook.on_play", String.format("%s/on_play", hookPrefix));
        param.put("hook.on_publish", String.format("%s/on_publish", hookPrefix));
        param.put("hook.on_record_mp4", String.format("%s/on_record_mp4", hookPrefix));
        param.put("hook.on_record_ts", String.format("%s/on_record_ts", hookPrefix));
        param.put("hook.on_rtp_server_timeout", String.format("%s/on_rtp_server_timeout", hookPrefix));
        param.put("hook.on_rtsp_auth", String.format("%s/on_rtsp_auth", hookPrefix));
        param.put("hook.on_rtsp_realm", String.format("%s/on_rtsp_realm", hookPrefix));
        param.put("hook.on_send_rtp_stopped", String.format("%s/on_send_rtp_stopped", hookPrefix));
        param.put("hook.on_server_keepalive", String.format("%s/on_server_keepalive", hookPrefix));
        param.put("hook.on_server_started", String.format("%s/on_server_started", hookPrefix));
        param.put("hook.on_shell_login", String.format("%s/on_shell_login", hookPrefix));
        param.put("hook.on_stream_changed", String.format("%s/on_stream_changed", hookPrefix));
        param.put("hook.on_stream_none_reader", String.format("%s/on_stream_none_reader", hookPrefix));
        param.put("hook.on_stream_not_found", String.format("%s/on_stream_not_found", hookPrefix));

        ZLMResult result = postForm(ZLMConstant.SET_SERVER_CONFIG, param);

        if (Objects.nonNull(result) && result.getCode() == 0) {
            if (result.getChanged() > 0) {
                log.info("[ZLM] [ZLM ServerId:{}] 设置服务器配置成功,存在配置变更,需要重启以保证配置生效!", zlmProperties.getId());
                restartServer();
            } else {
                log.info("[ZLM] [ZLM ServerId:{}] 设置服务器配置成功,不存在配置变更", zlmProperties.getId());
            }
        } else {
            log.error("[ZLM] [ZLM ServerId:{}] 设置服务器配置失败,请确认ZLM是否启动!", zlmProperties.getId());
        }
    }

    /**
     * 重启服务器，只有Daemon方式才能重启，否则是直接关闭
     */
    public void restartServer() {
        ZLMResult result = postForm(ZLMConstant.RESTART_SERVER, new HashMap<>());

        if (Objects.nonNull(result) && result.getCode() == 0) {
            log.info("[ZLM] [ZLM ServerId:{}] 重启服务器成功,{}!", zlmProperties.getId(), result.getMsg());

            MediaServerBO mediaServerBO = properties2bo();
            mediaServerService.saveOrUpdateMediaServer(mediaServerBO);
        } else {
            log.error("[ZLM] [ZLM ServerId:{}] 重启服务器失败,请确认ZLM是否启动!", zlmProperties.getId());
        }
    }

    public ZLMResult postForm(String apiName) {
        Map<String, Object> param = new HashMap<>();
        param.put("secret", zlmProperties.getSecret());
        return HttpUtils.zlmPostForm(getZLMUrl(apiName), param);
    }
    
    public ZLMResult postForm(String apiName, Map<String, Object> param) {
        param.put("secret", zlmProperties.getSecret());
        return HttpUtils.zlmPostForm(getZLMUrl(apiName), param);
    }

    private String getZLMUrl(String apiName) {
        return String.format(ZLMConstant.URL_FMT, zlmProperties.getIp(), zlmProperties.getHttpPort(), apiName);
    }

    public MediaServerBO properties2bo() {
        MediaServerBO mediaServerBO = new MediaServerBO();

        mediaServerBO.setId(zlmProperties.getId());
        mediaServerBO.setIp(zlmProperties.getIp());
        mediaServerBO.setHookIp(zlmProperties.getHookIp());
        mediaServerBO.setSdpIp(zlmProperties.getSdpIp());
        mediaServerBO.setStreamIp(zlmProperties.getStreamIp());
        mediaServerBO.setHttpPort(zlmProperties.getHttpPort());
        mediaServerBO.setHttpSSlPort(zlmProperties.getHttpSslPort());
        mediaServerBO.setRtmpPort(zlmProperties.getRtmpPort());
        mediaServerBO.setRtmpSSlPort(zlmProperties.getRtmpSslPort());
        mediaServerBO.setRtpProxyPort(zlmProperties.getRtpProxyPort());
        mediaServerBO.setRtspPort(zlmProperties.getRtspPort());
        mediaServerBO.setRtspSSLPort(zlmProperties.getRtspSslPort());
        mediaServerBO.setAutoConfig(zlmProperties.getAutoConfig() ? 1 : 0);
        mediaServerBO.setSecret(zlmProperties.getSecret());
        mediaServerBO.setRtpEnable(zlmProperties.getRtpEnable() ? 1 : 0);
        mediaServerBO.setRtpPortRange(zlmProperties.getRtpPortRange());
        mediaServerBO.setRecordAssistPort(zlmProperties.getRecordAssistPort());
        mediaServerBO.setDefaultServer(1);
        mediaServerBO.setHookAliveInterval(zlmProperties.getHookAliveInterval());

        return mediaServerBO;
    }

}
