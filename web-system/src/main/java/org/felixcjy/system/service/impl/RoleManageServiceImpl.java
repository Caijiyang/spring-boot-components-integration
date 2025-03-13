package org.felixcjy.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.felixcjy.system.domain.entity.SysRole;
import org.felixcjy.system.service.RoleManageService;
import org.felixcjy.system.service.basic.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色管理业务逻辑接口实现类
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/6 22:36
 */
@Service
@AllArgsConstructor
public class RoleManageServiceImpl implements RoleManageService {
    private final SysRoleService sysRoleService;

    @Override
    public IPage<SysRole> getRoleList(int pageNum, int pageSize) {
        return sysRoleService.getRoleList(pageNum, pageSize);
    }
}
