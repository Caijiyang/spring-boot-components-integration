package org.felixcjy.redis.service;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/3/11 14:08
 */
public interface RedisService {

    void setValue(String key, String value);

    String getValue(String key);

    boolean deleteKey(String key);

    boolean setExpire(String key, long seconds);

    /** 可选：带过期时间的设置方法 */
    void setValueWithExpire(String key, String value, long seconds);
}
