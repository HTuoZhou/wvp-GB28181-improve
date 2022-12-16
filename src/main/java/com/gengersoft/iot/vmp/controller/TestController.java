package com.gengersoft.iot.vmp.controller;

import com.gengersoft.iot.vmp.common.annotation.WebLog;
import com.gengersoft.iot.vmp.common.base.ApiFinalResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanzai
 * @date 2022/12/15
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/helloWorld")
    @WebLog
    public ApiFinalResult<String> helloWorld() {
        return ApiFinalResult.success("helloWorld");
    }

}
