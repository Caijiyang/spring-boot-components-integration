package org.felixcjy.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:09
 */
@Data
public class SysRole {
    /** 角色ID */
    @TableField("role_id")
    private String roleId;

    /** 角色标识 */
    @TableField("role_sign")
    private String roleSign;

    /** 角色名称 */
    @TableField("role_name")
    private String roleName;

    /** 显示顺序 */
    @TableField("role_sort")
    private int roleSort;

    /** 备注 */
    @TableField("remark")
    private String remark;

    /** 角色状态 */
    @TableField("status")
    private char status;

    /** 删除标识 */
    @TableField("del_flag")
    private char delFlag;

    /** 创建者 */
    @TableField("create_user_id")
    private String createdUserId;

    /** 创建时间 */
    @TableField("create_date_time")
    private LocalDateTime createDateTime;

    /** 更新者 */
    @TableField("update_user_id")
    private String updateUserId;

    /** 更新时间 */
    @TableField("update_date_time")
    private LocalDateTime updateDateTime;
}
