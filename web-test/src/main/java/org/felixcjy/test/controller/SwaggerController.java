package org.felixcjy.test.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 用于演示 Swagger 使用<br/><br/>
 * <a href="http://localhost:8080/v3/api-docs">OpenAPI JSON 描述</a><br/>
 * <a href="http://localhost:8080/swagger-ui.html">Swagger UI 界面</a>
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/10 09:38
 */
@RestController
@RequestMapping("/api/swagger")
@Tag(name = "Swagger接口管理", description = "Swagger接口操作案例") // 接口分组标签
public class SwaggerController {
    // 示例 DTO 类（假设定义在公共模块）
    @Data
    public static class UserDTO {
        @Schema(description = "用户ID", example = "1001")
        private Long id;

        @Schema(description = "用户名", example = "张三")
        private String name;
    }

    // 示例错误响应类
    @Data
    public static class ErrorResponse {
        @Schema(description = "错误码", example = "404")
        private int code;

        @Schema(description = "错误信息", example = "用户不存在")
        private String message;
    }

    @GetMapping("/{userId}")
    @Operation(summary = "获取用户详情", // 接口简要描述
            description = "根据用户ID查询用户详细信息" // 详细说明
    )
    @ApiResponse(responseCode = "200",
            description = "成功获取用户",
            content = @Content(schema = @Schema(implementation = UserDTO.class))
    )
    @ApiResponse(responseCode = "404",
            description = "用户不存在",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    public UserDTO getUser(@PathVariable
                           @Parameter(description = "用户ID", required = true, example = "1001")
                           Long userId) {
        // 业务逻辑
        return new UserDTO();
    }

    @PostMapping
    @Operation(summary = "创建用户")
    @ApiResponse(responseCode = "201",
            description = "用户创建成功"
    )
    public ResponseEntity<Void> createUser(@RequestBody
                                           @Parameter(description = "用户数据", required = true)
                                           UserDTO userDTO) {
        // 业务逻辑
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search")
    @Operation(summary = "搜索用户")
    public List<UserDTO> searchUsers(@RequestParam
                                     @Parameter(description = "用户名关键字", example = "张")
                                     String keyword,
                                     @RequestParam(required = false, defaultValue = "1")
                                     @Parameter(description = "页码", example = "1")
                                     Integer page) {
        // 业务逻辑
        return Arrays.asList(new UserDTO());
    }

    @Hidden // 隐藏该接口
    @GetMapping("/secret")
    public String secretApi() {
        return "秘密接口";
    }
}
