package org.felixcjy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.felixcjy.system.domain.dto.SysRolePermissionDTO;
import org.felixcjy.system.domain.entity.SysRolePermission;

import java.util.List;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:31
 */
@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
    /** 全表查询角色权限关联表 */
    List<SysRolePermissionDTO> getRolePermissions();
}
