package org.felixcjy.system.service.basic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.felixcjy.system.domain.dto.SysRolePermissionDTO;
import org.felixcjy.system.domain.entity.SysRolePermission;
import org.felixcjy.system.mapper.SysRolePermissionMapper;
import org.felixcjy.system.service.basic.SysRolePermissionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:32
 */
@Service
@AllArgsConstructor
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {
    private final SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRolePermissionDTO> getRolePermissions() {
        return sysRolePermissionMapper.getRolePermissions();
    }
}
