package com.phh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author phh
 * @version V1.0
 * @date 2020/10/6
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/set")
    public Object set(@RequestParam(defaultValue = "test") String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @GetMapping("/get")
    public Object get(@RequestParam(defaultValue = "test") String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
