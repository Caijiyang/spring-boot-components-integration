package org.felixcjy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.felixcjy.system.domain.entity.SysUserRole;

/**
 * 用户角色表 Mapper
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 17:38
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
