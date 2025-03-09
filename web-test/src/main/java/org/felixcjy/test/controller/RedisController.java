package org.felixcjy.test.controller;

import org.felixcjy.test.service.RedisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用 API 的形式测试 Redis
 *
 * @author: Felix(蔡济阳)
 * @since : 2025/3/9 12:16
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

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
