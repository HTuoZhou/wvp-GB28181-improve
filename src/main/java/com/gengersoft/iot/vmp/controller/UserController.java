package com.gengersoft.iot.vmp.controller;

import com.gengersoft.iot.vmp.common.base.ApiFinalResult;
import com.gengersoft.iot.vmp.common.base.BusinessException;
import com.gengersoft.iot.vmp.common.base.ResultCodeEnum;
import com.gengersoft.iot.vmp.security.LoginUser;
import com.gengersoft.iot.vmp.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.AuthenticationException;

/**
 * @author hanzai
 * @date 2022/12/24
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public ApiFinalResult<LoginUser> login(String username, String password){
        LoginUser user = null;
        try {
            user = SecurityUtils.login(username, password, authenticationManager);
        } catch (AuthenticationException e) {
            throw new BusinessException();
        }
        if (user == null) {
            throw new BusinessException(ResultCodeEnum.FAIL, "用户名或密码错误");
        }
        return ApiFinalResult.success(user);
    }

}
