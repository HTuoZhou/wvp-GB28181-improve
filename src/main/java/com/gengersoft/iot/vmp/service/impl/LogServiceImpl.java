package com.gengersoft.iot.vmp.service.impl;

import com.gengersoft.iot.vmp.entity.po.LogPO;
import com.gengersoft.iot.vmp.mapper.LogMapper;
import com.gengersoft.iot.vmp.service.ILogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, LogPO> implements ILogService {

}
