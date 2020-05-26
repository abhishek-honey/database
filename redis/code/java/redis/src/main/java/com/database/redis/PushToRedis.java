package com.database.redis;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PushToRedis {

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @PostConstruct
    public void addLink() {
        listOpsLPush("test", "test");
    }

    public void listOpsLPush(String list, String url) {
        listOps.leftPush(list, url);
        // or use template directly
        redisTemplate.boundListOps(list).leftPush(url);
    }
}
