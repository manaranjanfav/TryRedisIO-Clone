package com.redisclone.tryredis.Cache.CacheProducer;

import com.redisclone.tryredis.Cache.CacheIml;
import com.redisclone.tryredis.Cache.InMemoryStorage.MemoryStorageHashmap;
import com.redisclone.tryredis.Cache.Policies.EvictionPolicyLRU;

public class CreateCache<Key,Val> {

    public CacheIml<Key,Val> BaseCache(final int CacheSize){
        return new CacheIml<Key,Val>(new MemoryStorageHashmap<Key,Val>(CacheSize), new EvictionPolicyLRU<Key>());
    }
    
}
