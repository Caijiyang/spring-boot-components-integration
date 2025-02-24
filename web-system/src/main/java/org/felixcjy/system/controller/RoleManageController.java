package org.felixcjy.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.felixcjy.common.domain.common.WebResult;
import org.felixcjy.system.domain.entity.SysRole;
import org.felixcjy.system.service.SysRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/23 17:59
 */
@RestController
@RequestMapping("/role")
public class RoleManageController {
    private final static Logger logger = LoggerFactory.getLogger(RoleManageController.class);

    private final SysRoleService sysRoleService;

    public RoleManageController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/getRoleList")
    public WebResult<IPage<SysRole>> getRoleList(@RequestParam int pageNum, @RequestParam int pageSize) {
        try {
            IPage<SysRole> roleList = sysRoleService.getRoleList(pageNum, pageSize);
            return WebResult.success(roleList).withMessage("query role list success.");
        } catch (Exception e) {
            logger.error("RoleManageController getRoleList error,{}", e.getMessage(), e);
            throw new RuntimeException("getRoleList error", e);
        }
    }
}
