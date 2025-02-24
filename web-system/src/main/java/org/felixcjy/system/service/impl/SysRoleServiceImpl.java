package org.felixcjy.system.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.felixcjy.common.domain.common.WebResult;
import org.felixcjy.common.domain.dto.PageDTO;
import org.felixcjy.system.domain.entity.SysRole;
import org.felixcjy.system.mapper.SysRoleMapper;
import org.felixcjy.system.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:14
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    private final SysRoleMapper sysRoleMapper;

    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public IPage<SysRole> getRoleList(int pageNum, int pageSize) {
        Page<SysRole> sysRolePage = new Page<>(pageNum, pageSize);
        return sysRoleMapper.getRoleList(sysRolePage);
    }
}
