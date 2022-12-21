package com.gengersoft.iot.vmp.gb28181.transmit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sip.*;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@Slf4j
public class SIPProcessorObserver implements ISIPProcessorObserver{

    @Override
    public void processRequest(RequestEvent requestEvent) {

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
}
