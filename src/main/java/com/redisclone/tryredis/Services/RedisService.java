package com.redisclone.tryredis.Services;

import com.redisclone.tryredis.Cache.CacheIml;
import com.redisclone.tryredis.Cache.CacheProducer.CreateCache;

public class RedisService<key,val> {

   CacheIml<key,val> cache;
   ComputeResult<key,val> computeResult;


   public RedisService() {
      this.cache = new CreateCache<key,val>().BaseCache(10);
      this.computeResult = new ComputeResult<key,val>(cache);
   }

   public CacheIml<key,val> getCache() {
      return this.cache;
   }

   public void setCache(CacheIml<key,val> cache) {
      this.cache = cache;
   }

   public ComputeResult<key,val> getComputeResult() {
      return this.computeResult;
   }

   public void setComputeResult(ComputeResult<key,val> computeResult) {
      this.computeResult = computeResult;
   }
   

   
}
