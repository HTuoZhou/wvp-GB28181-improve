package com.gengersoft.iot.vmp.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gengersoft.iot.vmp.entity.po.UserPO;
import com.gengersoft.iot.vmp.entity.po.UserRolePO;
import com.gengersoft.iot.vmp.service.IUserRoleService;
import com.gengersoft.iot.vmp.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author hanzai
 * @date 2022/12/24
 */
@Component
public class DefaultUserDetailsServiceImpl implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultUserDetailsServiceImpl.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            logger.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        // 查出密码
        UserPO user = userService.getOne(Wrappers.<UserPO>lambdaQuery().eq(UserPO::getUsername, username));
        UserRolePO role = userRoleService.getOne(Wrappers.<UserRolePO>lambdaQuery().eq(UserRolePO::getId, user.getRoleId()));
        user.setRole(role);

        if (user == null) {
            logger.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        String password = SecurityUtils.encryptPassword(user.getPassword());
        user.setPassword(password);
        return new LoginUser(user, LocalDateTime.now());
    }


}