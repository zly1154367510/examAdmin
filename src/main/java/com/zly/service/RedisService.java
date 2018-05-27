package com.zly.service;

/**
 * Created by zly11 on 2018/5/27.
 */
public interface RedisService {

    //删除对应key的行
    void remove(String key);

    //根据提供的key创建行
    void create(String key,String value);

    //根据提供的key查询行
    String select(String key);



}
