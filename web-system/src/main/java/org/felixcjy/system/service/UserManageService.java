package org.felixcjy.system.service;

import org.felixcjy.system.domain.dto.SysUserDTO;

/**
 * 用户管理业务逻辑接口
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 14:50
 */
public interface UserManageService {
    /** 添加用户 */
    void addUser(SysUserDTO sysUserDTO);
}
