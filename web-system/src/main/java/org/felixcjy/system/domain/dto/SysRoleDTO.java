package org.felixcjy.system.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 16:37
 */
@Data
public class SysRoleDTO {
    /** 角色标识 */
    private String roleSign;

    /** 角色名称 */
    private String roleName;

    /** 显示顺序 */
    private int roleSort;

    /** 备注 */
    private String remark;

    /** 角色状态 0:正常 1:停用*/
    private char status;
}
