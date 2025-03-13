package org.felixcjy.system.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import org.felixcjy.system.domain.dto.SysRolePermissionDTO;
import org.felixcjy.system.domain.entity.SysRolePermission;

import java.util.List;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:31
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {
    /** 全表查询角色权限关联表 */
    List<SysRolePermissionDTO> getRolePermissions();
}
