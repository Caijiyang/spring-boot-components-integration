package org.felixcjy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.felixcjy.system.domain.entity.SysRole;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/6 22:35
 */
public interface RoleManageService {
    /** 业务层分页查询角色列表 */
    IPage<SysRole> getRoleList(int pageNum, int pageSize);
}
