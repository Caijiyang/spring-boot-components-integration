package org.felixcjy.stater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 本项目启动入口
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/2/23 17:53
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.felixcjy.*"})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
