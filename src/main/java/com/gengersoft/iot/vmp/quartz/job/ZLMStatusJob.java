package com.gengersoft.iot.vmp.quartz.job;

import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlm.ZLMManager;
import com.gengersoft.iot.vmp.zlm.properties.ZLMProperties;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author hanzai
 * @date 2023/1/17
 */
@Slf4j
public class ZLMStatusJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ZLMProperties zlmProperties = (ZLMProperties) jobExecutionContext.getJobDetail().getJobDataMap().get("zlmProperties");
        ZLMManager zlmManager = (ZLMManager) jobExecutionContext.getJobDetail().getJobDataMap().get("zlmManager");
        IMediaServerService mediaServerService = (IMediaServerService) jobExecutionContext.getJobDetail().getJobDataMap().get("mediaServerService");

        if (!zlmManager.getServerConfig()) {
            log.info("[ZLM] [ZLM ServerId:{}] 心跳检测离线",zlmProperties.getId());
            mediaServerService.offline();
        }
    }

}
