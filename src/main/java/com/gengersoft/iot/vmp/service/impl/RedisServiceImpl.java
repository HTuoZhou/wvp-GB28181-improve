package com.gengersoft.iot.vmp.service.impl;

import com.gengersoft.iot.vmp.constant.RedisConstant;
import com.gengersoft.iot.vmp.service.IRedisService;
import com.gengersoft.iot.vmp.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author hanzai
 * @date 2023/2/1
 */
@Service
@Slf4j
public class RedisServiceImpl implements IRedisService {
    @Override
    public Long getCseq() {
        String key = RedisConstant.CESQ_NAME;

        long result =  RedisUtils.incr(key, 1L);
        if (result > Integer.MAX_VALUE) {
            RedisUtils.set(key, 1);
            result = 1;
        }
        return result;
    }
}
