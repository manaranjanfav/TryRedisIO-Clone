package com.redisclone.tryredis.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.redisclone.tryredis.Services.RedisService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class redisController<key,val> {

    private List<String> commands = new ArrayList<>();
    RedisService<key,val> redisService = new RedisService<key,val>();

    int insideget = 0;
    @GetMapping("/home")
    public String home(Model m) {
        m.addAttribute("abc", commands);
        insideget++;
        if(insideget==2)
        {
            commands.clear();
            insideget = 0;
        }
        //System.out.println("InsideGet");
        return "home";
    }

    

    @PostMapping("/home")
    public String input(String input) {
        insideget = 0;
        String fans = redisService.getComputeResult().computeResult(input);
        String head = "> " + input;
        commands.add(head);
        commands.add(fans);
        //System.out.println("InsidePost" + input);
        return "redirect:/home";
    }
    @PostMapping("/tutorial")
    public String tutorial()
    {
        String a = "Redis is in the family of databases called key-value stores.";
        String b = "The essence of a key-value store is the ability to store some data, called a value, inside a key. This data can later be retrieved only if we know the exact key used to store it.";
        String c = "Often Redis it is called a data structure server because it has outer key-value shell, but each value can contain a complex data structure, such as a string, a list, a hashes, or ordered data structures called sorted sets as well as probabilistic data structures like hyperloglog.";
        String d = "As a first example, we can use the command SET to store the value \"fido\" at key \"server:name\":";
        String e = "SET server:name \"fido\"";
        String f = "OK";
        String g = "Redis will store our data permanently, so we can later ask \"What is the value stored at key server:name?\" and Redis will reply with \"fido\":";
        String h = "GET server:name => \"fido\"";
        String i = "There is a command in order to test if a give key exists or not:";
        String j = " EXISTS server:name => 1";
        String k = "EXISTS server:blabla => 0";
        String l = "Tip: You can click the commands above to automatically execute them. The text after the arrow (=>) shows the expected output.";
        
        commands.add(a);
        commands.add(b);
        commands.add(c);
        commands.add(d);
        commands.add(e);
        commands.add(f);
        commands.add(g);
        commands.add(h);
        commands.add(i);
        commands.add(j);
        commands.add(k);
        commands.add(l);


        System.out.println("Inside tutorial");
        
        insideget = 0;
        return "redirect:/home"; 
    }

    @PostMapping("/help")
    public String help()
    {
        String ans = "Please type HELP for one of these commands: DECR, DECRBY, DEL, EXISTS, EXPIRE, GET, GETSET, HDEL, HEXISTS, HGET, HGETALL, HINCRBY, HKEYS, HLEN, HMGET, HMSET, HSET, HVALS, INCR, INCRBY, KEYS, LINDEX, LLEN, LPOP, LPUSH, LRANGE, LREM, LSET, LTRIM, MGET, MSET, MSETNX, MULTI, PEXPIRE, RENAME, RENAMENX, RPOP, RPOPLPUSH, RPUSH, SADD, SCARD, SDIFF, SDIFFSTORE, SET, SETEX, SETNX, SINTER, SINTERSTORE, SISMEMBER, SMEMBERS, SMOVE, SORT, SPOP, SRANDMEMBER, SREM, SUNION, SUNIONSTORE, TTL, TYPE, ZADD, ZCARD, ZCOUNT, ZINCRBY, ZRANGE, ZRANGEBYSCORE, ZRANK, ZREM, ZREMRANGEBYSCORE, ZREVRANGE, ZSCORE";
        System.out.println("Inside help");
        String head = "> HELP";
        commands.add(head);
        commands.add(ans);
        insideget = 0;
        return "redirect:/home"; 
    }
    
    

    

}
