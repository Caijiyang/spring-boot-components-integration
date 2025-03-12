package org.felixcjy.system.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import org.felixcjy.system.domain.dto.SysUserDTO;
import org.felixcjy.system.domain.entity.SysUser;
import org.felixcjy.system.domain.entity.SysUserRole;
import org.felixcjy.system.mapper.SysUserMapper;
import org.felixcjy.system.service.UserManageService;
import org.felixcjy.system.service.basic.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 14:50
 */
@Service
@AllArgsConstructor
public class UserManageServiceImpl implements UserManageService {
    private static final Logger logger = LoggerFactory.getLogger(UserManageServiceImpl.class);

    private final PasswordEncoder passwordEncoder;
    private final SysUserMapper sysUserMapper;
    private final SysUserRoleService sysUserRoleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(SysUserDTO sysUserDTO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO, sysUser);
        sysUser.setUserId(IdUtil.simpleUUID());
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUser.setStatus("0");
        sysUser.setCreatedUserId("system");
        sysUser.setCreateDateTime(LocalDateTime.now());
        sysUserMapper.insert(sysUser);
        if (ArrayUtil.isNotEmpty(sysUserDTO.getRoleIds())) {
            List<SysUserRole> sysUserRoles = new ArrayList<>();
            for (String roleId : sysUserDTO.getRoleIds()) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(sysUser.getUserId());
                sysUserRole.setRoleId(roleId);
                sysUserRoles.add(sysUserRole);
            }
            sysUserRoleService.saveBatch(sysUserRoles);
        } else {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(sysUser.getUserId());
            sysUserRole.setRoleId("1");
            sysUserRoleService.save(sysUserRole);
        }
    }
}
