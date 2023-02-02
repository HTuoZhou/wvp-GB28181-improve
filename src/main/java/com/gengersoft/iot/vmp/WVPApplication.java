package com.gengersoft.iot.vmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan("com.gengersoft.iot.vmp.mapper")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WVPApplication {
    public static void main(String[] args) {
        SpringApplication.run(WVPApplication.class);
    }
}