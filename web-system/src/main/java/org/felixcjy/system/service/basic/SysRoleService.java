package org.felixcjy.system.service.basic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.felixcjy.system.domain.entity.SysRole;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:14
 */
public interface SysRoleService extends IService<SysRole> {
    /** 数据层简单分页查询角色列表*/
    IPage<SysRole> getRoleList(int pageNum, int pageSize);
}
