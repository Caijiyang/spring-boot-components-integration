package org.felixcjy.test.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/9 12:16
 */
@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean deleteKey(String key) {
        Boolean result = redisTemplate.delete(key);
        return result != null && result;
    }

    public boolean setExpire(String key, long seconds) {
        Boolean result = redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        return result != null && result;
    }

    // 可选：带过期时间的设置方法
    public void setValueWithExpire(String key, String value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }
}