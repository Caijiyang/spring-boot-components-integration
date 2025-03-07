package org.felixcjy.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.felixcjy.system.domain.entity.SysRole;
import org.felixcjy.system.mapper.SysRoleMapper;
import org.felixcjy.system.service.RoleManageService;
import org.felixcjy.system.service.basic.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/6 22:36
 */

@Service
@AllArgsConstructor
public class RoleManageServiceImpl implements RoleManageService {
    private final SysRoleService sysRoleService;

    @Override
    public IPage<SysRole> getRoleList(int pageNum, int pageSize) {
        IPage<SysRole> roleList = sysRoleService.getRoleList(pageNum, pageSize);
        // 做相应的业务逻辑处理
        return roleList;
    }
}
