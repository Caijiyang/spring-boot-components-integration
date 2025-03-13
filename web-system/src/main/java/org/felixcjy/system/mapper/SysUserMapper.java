package org.felixcjy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.felixcjy.system.domain.dto.SysUserDTO;
import org.felixcjy.system.domain.entity.SysUser;

/**
 * 用户表 Mapper
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 13:35
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /** 通过用户账户查询用户信息，包括角色 */
    SysUserDTO getUserByUserAccount(@Param("userAccount") String userAccount);
}
