package com.gengersoft.iot.vmp.quartz.component;

import com.gengersoft.iot.vmp.constant.QuartzConstant;
import com.gengersoft.iot.vmp.quartz.job.ZLMStatusJob;
import com.gengersoft.iot.vmp.service.IMediaServerService;
import com.gengersoft.iot.vmp.zlm.ZLMManager;
import com.gengersoft.iot.vmp.zlm.properties.ZLMProperties;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2023/1/17
 */
@Component
@Order(3)
public class ZLMStatusJobComponent {

    @Autowired
    private ZLMProperties zlmProperties;

    @Autowired
    private ZLMManager zlmManager;

    @Autowired
    private IMediaServerService mediaServerService;

    @Bean
    public JobDetail zlmStatusJobDetail() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("zlmProperties",zlmProperties);
        jobDataMap.put("zlmManager",zlmManager);
        jobDataMap.put("mediaServerService",mediaServerService);

        return JobBuilder.newJob(ZLMStatusJob.class)
                .withIdentity(QuartzConstant.ZLM_STATUS_JOB_NAME,QuartzConstant.ZLM_STATUS_GROUP_NAME)
                .setJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger zlmStatusJobTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(zlmProperties.getHookAliveInterval() * 2)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(zlmStatusJobDetail())
                .withIdentity(QuartzConstant.ZLM_STATUS_JOB_NAME,QuartzConstant.ZLM_STATUS_GROUP_NAME)
                .withSchedule(simpleScheduleBuilder)
                .build();
    }

}
