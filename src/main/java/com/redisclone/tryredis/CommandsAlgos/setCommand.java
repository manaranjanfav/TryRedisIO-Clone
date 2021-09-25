package com.redisclone.tryredis.CommandsAlgos;

import com.redisclone.tryredis.Cache.CacheIml;

public class setCommand<key,val> {
    
    public String executeSet(key k, val v, CacheIml<key,val> cache)
    { 
        cache.set(k, v);
        System.out.println("executing set");
        return "OK";
    }
}
