package org.felixcjy.system.service.basic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.felixcjy.system.domain.dto.SysUserDTO;
import org.felixcjy.system.domain.entity.SysUser;
import org.felixcjy.system.mapper.SysUserMapper;
import org.felixcjy.system.service.basic.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 用户数据处理接口实现类
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 13:35
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    private final SysUserMapper sysUserMapper;

    @Override
    public SysUserDTO getUserByUserAccount(String userAccount) {
        return sysUserMapper.getUserByUserAccount(userAccount);
    }
}
