package com.redisclone.tryredis.Cache;

import com.redisclone.tryredis.Cache.Exceptions.MemoryFullException;
import com.redisclone.tryredis.Cache.Exceptions.NotfoundException;
import com.redisclone.tryredis.Cache.InMemoryStorage.Memorystorage;
import com.redisclone.tryredis.Cache.Policies.EvictionPolicy;

public class CacheIml<Key,Val> {

    private final Memorystorage<Key,Val> storage;
    private final EvictionPolicy<Key> policy;

    public CacheIml(Memorystorage<Key,Val> storage, EvictionPolicy<Key> policy) {
        this.storage = storage;
        this.policy = policy;
    }

    public void set(Key key, Val val)
    {
        
        try {
            this.policy.KeyTouched(key);
            this.storage.setKeyToVal(key, val);
        } catch (MemoryFullException e) {
            System.out.println("Memory is full trying to evict");
            Key keyToRemove = this.policy.evictKey();
            if(keyToRemove == null) 
             throw new RuntimeException("Error MemoryFull and no key found to evict");
            
             this.storage.removeKey(keyToRemove);
             this.storage.setKeyToVal(key, val);
             this.policy.KeyTouched(key);
             System.out.println("value is added properly to storage");

             
        }
        
    }
    public Val get(Key key)
    {
        try {
           Val val = this.storage.getVal(key);
           this.policy.KeyTouched(key);
           System.out.println("Value proerly returned1");
           return val;
        } catch (NotfoundException e) {
        System.out.println("Key Not found");
            return null;
        }
    }

    public void removeAllkeys()
    {
        while(true)
        {
            Key keyToRemove = this.policy.evictKey();
            if(keyToRemove == null) break;
            this.storage.removeKey(keyToRemove);
        }
    }

    public Memorystorage<Key,Val> getStorage() {
        return this.storage;
    }


    public EvictionPolicy<Key> getPolicy() {
        return this.policy;
    }
    
    @Override
    public String toString() {
        return "{" +
            " storage='" + getStorage() + "'" +
            ", policy='" + getPolicy() + "'" +
            "}";
    }
    
}
