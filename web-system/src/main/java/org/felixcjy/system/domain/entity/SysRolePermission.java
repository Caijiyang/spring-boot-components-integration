package org.felixcjy.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:26
 */
@TableName("sys_role_permission")
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 7100376351007206111L;

    /** 权限ID */
    @TableField("permission_id")
    private String permissionId;

    /** 角色ID */
    @TableField("role_id")
    private String roleId;
}
