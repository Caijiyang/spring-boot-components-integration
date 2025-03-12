package org.felixcjy.system.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import org.felixcjy.system.domain.dto.SysUserDTO;
import org.felixcjy.system.domain.entity.SysUser;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 13:35
 */
public interface SysUserService extends IService<SysUser> {
    /** 通过用户的账户查询用户信息 */
    SysUserDTO getUserByUserAccount(String userAccount);
}
