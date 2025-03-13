package org.felixcjy.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 22:25
 */
@Data
@TableName("sys_permission")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -5873072508341552732L;

    /** 权限ID */
    @TableId("permission_id")
    private String permissionId;

    /** 权限名称 */
    @TableField("permission_name")
    private String permissionName;

    /** URL 模式 */
    @TableField("url_pattern")
    private String urlPattern;
}
