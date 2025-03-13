package org.felixcjy.system.service;

import java.util.List;
import java.util.Map;

/**
 * 权限处理业务逻辑接口
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:42
 */
public interface PermissionService {
    /** 查询所有的角色-权限映射 */
    Map<String, List<String>> getRolePermissions();
}
