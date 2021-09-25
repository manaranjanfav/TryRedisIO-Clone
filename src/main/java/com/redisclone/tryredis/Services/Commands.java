package com.redisclone.tryredis.Services;

public enum Commands {
    SET,GET,EXISTS;

    public String toString(){
        switch(this){
        case SET :
            return "set";
        case GET :
            return "get";
        case EXISTS :
            return "exists";
        }
        return null;
    }

    public static Commands valueOfEnum(String value){
        if(value.equalsIgnoreCase(SET.toString()))
            return Commands.SET;
        else if(value.equalsIgnoreCase(GET.toString()))
            return Commands.GET;
        else if(value.equalsIgnoreCase(EXISTS.toString()))
            return Commands.EXISTS;
        else
            return null;
    }
}