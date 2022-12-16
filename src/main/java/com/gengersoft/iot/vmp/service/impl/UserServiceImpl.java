package com.gengersoft.iot.vmp.service.impl;

import com.gengersoft.iot.vmp.entity.po.UserPO;
import com.gengersoft.iot.vmp.mapper.UserMapper;
import com.gengersoft.iot.vmp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HTuoZhou
 * @since 2022-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {

}
