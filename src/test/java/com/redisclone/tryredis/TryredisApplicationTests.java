package com.redisclone.tryredis;

/*import com.redisclone.tryredis.Cache.CacheIml;
import com.redisclone.tryredis.Cache.CacheProducer.CreateCache;*/

/*import com.redisclone.tryredis.Cache.Policies.EvictionPolicy;
import com.redisclone.tryredis.Cache.Policies.EvictionPolicyLRU;*/

/*import com.redisclone.tryredis.Cache.InMemoryStorage.MemoryStorageHashmap;
import com.redisclone.tryredis.Cache.InMemoryStorage.Memorystorage;*/

/*import com.redisclone.tryredis.Methods.DoublyLinkImpl;
import com.redisclone.tryredis.Methods.DoublyLinkedListNode;*/

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TryredisApplicationTests {

	@Test
	void contextLoads() {
		/*DoublyLinkImpl<Integer> x = new DoublyLinkImpl<Integer>();
		x.addNodeAtLast(3);
		DoublyLinkedListNode<Integer> y = x.addNodeAtLast(4);
		x.addNodeAtLast(5);
		x.removeNode(y);
		x.removeNodeAtFront();
		x.PrintAllNodes();*/

		/*Memorystorage<Integer,Integer> ms = new MemoryStorageHashmap<Integer,Integer>(5);
		ms.setKeyToVal(1, 2);
		ms.setKeyToVal(3, 4);
		System.out.println(ms.getVal(1));
		System.out.println(ms.getVal(3));*/

		/*EvictionPolicy<Integer> ev = new EvictionPolicyLRU<Integer>();
		ev.KeyTouched(1);
		ev.KeyTouched(2);
		ev.KeyTouched(3);
		ev.KeyTouched(1);

		System.out.println(ev.evictKey());
		System.out.println(ev.evictKey());
		System.out.println(ev.evictKey());*/

		/*CacheIml<Integer,Integer> cache = new CreateCache<Integer,Integer>().BaseCache(10);
		cache.removeAllkeys();
		cache.set(1,5);
		cache.set(1,5);
		cache.set(1,5);
		cache.set(1,5);
		cache.set(1,5);
		int integer = cache.get(2);
		
		System.out.println(integer);*/



		
		

	}

}
