package com.redisclone.tryredis.Cache.Policies;

public interface EvictionPolicy<T> {

      T evictKey();
      void KeyTouched(T obj);
    
}
