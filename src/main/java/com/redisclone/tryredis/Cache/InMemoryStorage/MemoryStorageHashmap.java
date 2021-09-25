package com.redisclone.tryredis.Cache.InMemoryStorage;

import java.util.HashMap;
import java.util.Map;

import com.redisclone.tryredis.Cache.Exceptions.MemoryFullException;
import com.redisclone.tryredis.Cache.Exceptions.NotfoundException;

public class MemoryStorageHashmap<Key,Val> implements Memorystorage<Key,Val> {

    private Map<Key,Val> hashMap;
    private final Integer CacheSize;

    public MemoryStorageHashmap() {
         this.CacheSize = 100;
    }

    public MemoryStorageHashmap(Integer CacheSize) {
        this.CacheSize = CacheSize;
        this.hashMap = new HashMap<>();
    }


    public MemoryStorageHashmap(Map<Key,Val> hashMap, Integer CacheSize) {
        this.hashMap = hashMap;
        this.CacheSize = CacheSize;
    }

    public Map<Key,Val> getHashMap() {
        return this.hashMap;
    }

    public void setHashMap(Map<Key,Val> hashMap) {
        this.hashMap = hashMap;
    }

    public Integer getCacheSize() {
        return this.CacheSize;
    }

        
    @Override
    public void setKeyToVal(Key key, Val value) throws MemoryFullException {
        
        if(hashMap.size() == this.CacheSize) throw new MemoryFullException("Memory Size Exceeds...");
        this.hashMap.put(key, value);
        
    }

    @Override
    public Val getVal(Key key) throws NotfoundException {
        
        if(hashMap.containsKey(key)==false) throw new NotfoundException("Key Not Found....");
        System.out.println("value is returned from storage");
        return hashMap.get(key);
        
    }

    @Override
    public void removeKey(Key key) throws NotfoundException {
        if(hashMap.containsKey(key)==false) throw new NotfoundException("Key Not Found....");
        hashMap.remove(key);
    }
        
    
    
}
