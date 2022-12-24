package com.gengersoft.iot.vmp.zlm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hanzai
 * @date 2022/12/21
 */
@Component
@Order(2)
@Slf4j
public class ZLMRunner implements CommandLineRunner {

    @Autowired
    private ZLMManager zlmManager;

    @Override
    public void run(String... args) throws Exception {
        zlmManager.setServerConfig();
    }

}
