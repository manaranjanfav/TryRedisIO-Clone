package com.redisclone.tryredis.Services;

import com.redisclone.tryredis.Cache.CacheIml;
import com.redisclone.tryredis.CommandsAlgos.setCommand;
import com.redisclone.tryredis.CommandsAlgos.getCommand;
public class ComputeResult<key,val> {
    String command;
    CacheIml<key,val> cache;
    String ans;
    setCommand<key,val> st = new setCommand<key,val>();
    getCommand<key,val> gt = new getCommand<key,val>();

    public ComputeResult(CacheIml<key,val> cache) {
        this.cache = cache;
         st = new setCommand<key,val>();
         gt = new getCommand<key,val>();
    }

    
    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String computeResult(String command) {
        try {
            
            String[] splitedCommand = command.split(" ");
            String commandAction = splitedCommand[0];
            switch (Commands.valueOfEnum(commandAction))
            {
                case SET:
                System.out.println(splitedCommand[0]+ " " + splitedCommand[1]+" "+splitedCommand[2]);
                @SuppressWarnings("unchecked")
                key k = (key)splitedCommand[1];
                @SuppressWarnings("unchecked")
                val v = (val)splitedCommand[2];
                this.ans = st.executeSet(k, v, cache);
                System.out.println("sethbbh" + commandAction);
                break;
                case GET:
                System.out.println(splitedCommand[0]+ " " + splitedCommand[1]);
                @SuppressWarnings("unchecked")
                key k1 = (key)splitedCommand[1];
                this.ans = gt.executeGet(k1, cache);
                System.out.println("gettt"+commandAction);
                break;
                case EXISTS:

            }
            return ans;
        } catch (EnumConstantNotPresentException e) {
            
            System.out.println("Enum constant not matched");
            return "(nil)";
        } catch (NullPointerException e) {
            
            System.out.println("enumType or name is null");
            return "(nil)";
        }
        
    }

}
