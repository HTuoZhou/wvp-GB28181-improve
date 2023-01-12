package com.gengersoft.iot.vmp.gb28181.transmit;

import com.gengersoft.iot.vmp.gb28181.event.request.ISIPRequestProcessor;
import com.gengersoft.iot.vmp.gb28181.event.response.ISIPResponseProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sip.*;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@Slf4j
public class SIPProcessorObserver implements ISIPProcessorObserver {

    private static Map<String, ISIPRequestProcessor> requestProcessorMap = new ConcurrentHashMap<>();

    private static Map<String, ISIPResponseProcessor> responseProcessorMap = new ConcurrentHashMap<>();

    @Override
    public void processRequest(RequestEvent requestEvent) {
        String method = requestEvent.getRequest().getMethod();
        ISIPRequestProcessor sipRequestProcessor = requestProcessorMap.get(method);
        if (Objects.isNull(sipRequestProcessor)) {
            log.error("[Request] [Request Method:{}] 暂不支持", method);
            return;
        }
        requestProcessorMap.get(method).process(requestEvent);
    }

    @Override
    public void processResponse(ResponseEvent responseEvent) {

    }

    @Override
    public void processTimeout(TimeoutEvent timeoutEvent) {

    }

    @Override
    public void processIOException(IOExceptionEvent ioExceptionEvent) {

    }

    @Override
    public void processTransactionTerminated(TransactionTerminatedEvent transactionTerminatedEvent) {

    }

    @Override
    public void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent) {

    }

    /**
     * 添加 request 订阅
     * @param method
     * @param processor
     */
    public void addRequestProcessor(String method, ISIPRequestProcessor processor) {
        requestProcessorMap.put(method, processor);
    }

    /**
     * 添加 response 订阅
     * @param method
     * @param processor
     */
    public void addResponseProcessor(String method, ISIPResponseProcessor processor) {
        responseProcessorMap.put(method, processor);
    }
}
