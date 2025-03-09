package org.felixcjy.stater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Redis 操作案例代码，包含对 RedisTemplate 的基本操作和缓存功能测试
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/9 09:06
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 测试基本 Key-Value 操作
    @Test
    public void testRedisTemplateOperations() {
        String key = "test:user:1";
        User user = new User(1L, "Alice");

        // 1. 存储数据到 Redis
        redisTemplate.opsForValue().set(key, user);

        // 设置过期时间（10秒）
        redisTemplate.expire(key, 100, TimeUnit.SECONDS);

        // 2. 从 Redis 获取数据
        User cachedUser = (User) redisTemplate.opsForValue().get(key);
        assertNotNull(cachedUser);
        assertEquals("Alice", cachedUser.getName());

        // 3. 删除 Key
        redisTemplate.delete(key);
        assertNull(redisTemplate.opsForValue().get(key));

        // 4. 检查 Key 是否存在
        Boolean exists = redisTemplate.hasKey(key);
        assertFalse(exists);
    }

    // 测试缓存注解（@Cacheable）
    @Test
    public void testCacheableAnnotation() {
        Long userId = 100L;
        String cacheKey = "user::" + userId;  // Spring Cache 自动生成的 key

        // 第一次调用：模拟数据库查询并缓存
        User firstCallUser = getUserById(userId);
        assertEquals("CachedUser", firstCallUser.getName());

        // 第二次调用：应直接从缓存读取
        User secondCallUser = getUserById(userId);
        assertSame(firstCallUser, secondCallUser);  // 验证是否为同一对象（缓存生效）此处为 False

        // 清除缓存
        redisTemplate.delete(cacheKey);
        assertNull(redisTemplate.opsForValue().get(cacheKey));
    }

    // 模拟带有 @Cacheable 注解的方法
    @Cacheable(value = "user", key = "#id")
    public User getUserById(Long id) {
        // 模拟数据库查询（此处返回新对象）
        return new User(id, "CachedUser");
    }

    // 测试用的 User 对象
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        private Long id;
        private String name;
    }
}