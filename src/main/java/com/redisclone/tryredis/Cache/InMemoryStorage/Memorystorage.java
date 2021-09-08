package com.redisclone.tryredis.Cache.InMemoryStorage;

import com.redisclone.tryredis.Cache.Exceptions.MemoryFullException;
import com.redisclone.tryredis.Cache.Exceptions.NotfoundException;

public interface Memorystorage <Key,Value>{
    void setKeyToVal(Key key ,Value value) throws MemoryFullException;
    Value getVal(Key key) throws NotfoundException;
    void removeKey(Key key) throws NotfoundException;
}
