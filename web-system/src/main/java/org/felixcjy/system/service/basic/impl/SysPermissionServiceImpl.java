package org.felixcjy.system.service.basic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.felixcjy.system.domain.entity.SysPermission;
import org.felixcjy.system.mapper.SysPermissionMapper;
import org.felixcjy.system.service.basic.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限数据处理接口实现类
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:33
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
}
