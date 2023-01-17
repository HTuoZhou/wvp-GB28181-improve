package com.gengersoft.iot.vmp.quartz.job;

import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlm.ZLMManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        ZLMManager zlmManager = (ZLMManager) jobExecutionContext.getJobDetail().getJobDataMap().get("zlmManager");
        IMediaServerService mediaServerService = (IMediaServerService) jobExecutionContext.getJobDetail().getJobDataMap().get("mediaServerService");

        String generalMediaServerId = zlmManager.getServerConfig();
        if (StringUtils.isBlank(generalMediaServerId)) {
            mediaServerService.offline();
        }
    }

}
