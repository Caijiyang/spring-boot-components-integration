package org.felixcjy.system.service.basic.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.felixcjy.system.domain.entity.SysRole;
import org.felixcjy.system.mapper.SysRoleMapper;
import org.felixcjy.system.service.basic.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色数据处理接口实现类
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:14
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private final SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRole> getRoleList(int pageNum, int pageSize) {
        Page<SysRole> sysRolePage = new Page<>(pageNum, pageSize);
        return sysRoleMapper.getRoleList(sysRolePage);
    }
}
