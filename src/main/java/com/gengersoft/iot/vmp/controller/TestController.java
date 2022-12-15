package com.gengersoft.iot.vmp.controller;

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
    public String helloWorld() {
        return "helloWorld";
    }

}
