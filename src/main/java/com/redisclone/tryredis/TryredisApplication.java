package com.redisclone.tryredis;

import com.redisclone.tryredis.Cache.CacheIml;
import com.redisclone.tryredis.Cache.CacheProducer.CreateCache;
import com.redisclone.tryredis.Methods.DoublyLinkImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TryredisApplication {

	private static Integer integer;

	public static void main(String[] args) {
		SpringApplication.run(TryredisApplication.class, args);
		DoublyLinkImpl<Integer> ab = new DoublyLinkImpl<Integer>();
        ab.addNode(14);
		ab.addNode(13);
		ab.addNode(19);
		//ab.PrintAllNodes();

		CacheIml<Integer,Integer> cache = new CreateCache<Integer,Integer>().BaseCache(10);
		cache.set(1, 5);
		integer = cache.get(1);
		System.out.println(integer);
		
	}

}
