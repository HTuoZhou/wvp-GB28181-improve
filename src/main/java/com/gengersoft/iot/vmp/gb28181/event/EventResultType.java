package com.gengersoft.iot.vmp.gb28181.event;

/**
 * @author hanzai
 * @date 2023/1/13
 */
public enum EventResultType {

    // 超时
    timeout,
    // 回复
    response,
    // 事务已结束
    transactionTerminated,
    // 会话已结束
    dialogTerminated,
    // 设备未找到
    deviceNotFoundEvent

}
