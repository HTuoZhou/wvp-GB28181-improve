package com.gengersoft.iot.vmp.service;

/**
 * @author hanzai
 * @date 2023/2/1
 */
public interface IRedisService {

    /**
     * cesq计数器
     * @return
     */
    Long getCseq();
}
