package org.felixcjy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.felixcjy.system.domain.entity.SysRole;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:10
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    IPage<SysRole> getRoleList(@Param("page") Page<SysRole> sysRolePage);
}
