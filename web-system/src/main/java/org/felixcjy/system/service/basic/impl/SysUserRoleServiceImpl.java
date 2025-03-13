package org.felixcjy.system.service.basic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.felixcjy.system.domain.entity.SysUserRole;
import org.felixcjy.system.mapper.SysUserRoleMapper;
import org.felixcjy.system.service.basic.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色数据处理接口实现类
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 19:26
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
