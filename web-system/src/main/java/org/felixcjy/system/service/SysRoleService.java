package org.felixcjy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.felixcjy.system.domain.entity.SysRole;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:14
 */
public interface SysRoleService {
    IPage<SysRole> getRoleList(int pageNum, int pageSize);
}
