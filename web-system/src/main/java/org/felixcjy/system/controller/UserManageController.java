package org.felixcjy.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.felixcjy.common.domain.common.WebResult;
import org.felixcjy.common.domain.enums.ErrorType;
import org.felixcjy.system.domain.dto.SysUserDTO;
import org.felixcjy.system.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户管理 Controller
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 14:17
 */
@RestController
@RequestMapping("/system/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class UserManageController {
    private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);

    private final UserManageService userManageService;

    @GetMapping("/addUser")
    @Operation(summary = "新增用户", description = "模拟新增用户的接口，不涉及角色和当前登录用户")
    public WebResult<Object> addUser(@Valid @RequestBody SysUserDTO sysUserDTO) {
        try {
            userManageService.addUser(sysUserDTO);
            return WebResult.success().withMessage("addUser success.");
        } catch (Exception e) {
            logger.error("UserManageController addUser error,{}", e.getMessage(), e);
            return WebResult.fail(ErrorType.INTERNAL_SERVER_ERROR);
        }
    }
}
