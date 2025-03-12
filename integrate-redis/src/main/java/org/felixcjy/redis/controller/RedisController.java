package org.felixcjy.redis.controller;

import lombok.AllArgsConstructor;
import org.felixcjy.redis.service.RedisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 模拟 Redis 操作的 Controller 实际项目并不会使用到
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/9 11:50
 */
@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/set")
    public ResponseEntity<String> setValue(@RequestParam String key,
                                           @RequestParam String value) {
        redisService.setValue(key, value);
        return ResponseEntity.ok("Value set successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<?> getValue(@RequestParam String key) {
        String value = redisService.getValue(key);
        if (value == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Key not found");
        }
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteKey(@RequestParam String key) {
        boolean deleted = redisService.deleteKey(key);
        return deleted ?
                ResponseEntity.ok("Key deleted successfully") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
    }

    @PostMapping("/expire")
    public ResponseEntity<String> setExpire(@RequestParam String key,
                                            @RequestParam long seconds) {
        boolean success = redisService.setExpire(key, seconds);
        return success ?
                ResponseEntity.ok("Expiration set successfully") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
    }
}