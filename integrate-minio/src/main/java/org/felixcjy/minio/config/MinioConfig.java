package org.felixcjy.minio.config;

import org.felixcjy.minio.properties.MinioProperties;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/5/4 17:09
 */

@Configuration
public class MinioConfig {
    @Bean
    public MinioClient minioClient(MinioProperties properties) {
        return MinioClient.builder()
                .endpoint(properties.getEndpoint())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
    }
}
