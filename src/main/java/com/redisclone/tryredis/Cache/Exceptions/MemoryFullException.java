package com.redisclone.tryredis.Cache.Exceptions;

public class MemoryFullException extends RuntimeException {

    public MemoryFullException(final String exception) {
        super(exception);
    }

}