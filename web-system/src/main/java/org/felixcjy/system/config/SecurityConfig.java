package org.felixcjy.system.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/12 10:44
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    // 构造注入，Spring 会自动将 CustomUserDetailsService 注入到这里
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .antMatchers("/public").permitAll() // 允许所有人访问
                        .antMatchers("/admin").hasRole("ADMIN") // 只有 ADMIN 角色可以访问
                        .antMatchers("/redis/**").hasRole("ADMIN") // 只有 ADMIN 角色可以访问
                        .antMatchers("/common").hasAnyRole("COMMON", "ADMIN") // COMMON 和 ADMIN 都可以访问
                        .anyRequest().authenticated() // 其他请求必须登录
                )
                .formLogin(withDefaults())  // 启用表单登录
                // .formLogin(form -> form.loginPage("/my-login").permitAll())  // 指定自定义登录页面
                .httpBasic(withDefaults()); // 启用 Basic 认证
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 若是很复杂的角色配置，可采用此方法，一般来说，Spring Security 会自动配置一个。
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder()) // 密码加密
                .and()
                .build();
    } */

    /* @Bean
    public UserDetailsService userDetailsService() {
        // 创建一个内存中的用户，用户名是 user，密码是 password, 在内存中创建用户的行为，适合第一次使用 Spring Security 时测试。
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build());
        return manager;
    } */
}