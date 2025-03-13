package org.felixcjy.system.domain;

import lombok.AllArgsConstructor;
import org.felixcjy.system.service.PermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Spring Security 配置动态过滤器
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/13 12:25
 */
@Component
@AllArgsConstructor
public class DynamicSecurityFilter extends OncePerRequestFilter {
    private final PermissionService permissionService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getAuthorities().isEmpty()) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "未授权");
            return;
        }

        String requestURI = request.getRequestURI();
        Map<String, List<String>> permissionRoles = permissionService.getRolePermissions();

        for (Map.Entry<String, List<String>> entry : permissionRoles.entrySet()) {
            if (new AntPathMatcher().match(entry.getKey(), requestURI)) {
                List<String> requiredRoles = entry.getValue();
                boolean hasAuthority = authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .anyMatch(requiredRoles::contains);
                if (!hasAuthority) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "权限不足");
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
