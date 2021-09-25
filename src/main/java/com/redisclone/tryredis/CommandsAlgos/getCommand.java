package com.redisclone.tryredis.CommandsAlgos;

import com.redisclone.tryredis.Cache.CacheIml;

public class getCommand<key,val> {

    public String executeGet(key k,CacheIml<key,val> cache)
    {
        val v = cache.get(k);
        String ans = v.toString();
        System.out.println("Executing get");
        String fans = ans;
        return fans;
    }
}