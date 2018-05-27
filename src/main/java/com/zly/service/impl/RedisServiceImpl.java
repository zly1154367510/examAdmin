package com.zly.service.impl;

import com.zly.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by zly11 on 2018/5/27.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void remove(String key) {
        if (select(key)!=null){
            redisTemplate.delete(key);
        }
    }

    @Override
    public void create(String key, String value) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key,value);
    }

    @Override
    public String select(String key) {
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }
}
