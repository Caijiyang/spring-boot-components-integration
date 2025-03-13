package org.felixcjy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.felixcjy.system.domain.entity.SysPermission;

/**
 * 权限表 Mapper
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:30
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
}
