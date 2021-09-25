package com.redisclone.tryredis.Cache.Policies;

import java.util.HashMap;
import java.util.Map;

import com.redisclone.tryredis.Methods.DoublyLinkImpl;
import com.redisclone.tryredis.Methods.DoublyLinkedListNode;

public class EvictionPolicyLRU<Key> implements EvictionPolicy<Key> {

    private Map< Key, DoublyLinkedListNode<Key> > mp;
    private DoublyLinkImpl<Key> doublylinkedlist;


    public EvictionPolicyLRU() {
        this.doublylinkedlist = new DoublyLinkImpl<>();
        this.mp = new HashMap<>();
    }

    @Override
    public Key evictKey() {
        
        DoublyLinkedListNode<Key> node = doublylinkedlist.getHead();
        if(node == null)
         return null;
        doublylinkedlist.removeNodeAtFront(); 
        return node.getObj();

    }

    public EvictionPolicyLRU(Map<Key,DoublyLinkedListNode<Key>> mp, DoublyLinkImpl<Key> doublylinkedlist) {
        this.mp = mp;
        this.doublylinkedlist = doublylinkedlist;
    }

    public Map<Key,DoublyLinkedListNode<Key>> getMp() {
        return this.mp;
    }

    public void setMp(Map<Key,DoublyLinkedListNode<Key>> mp) {
        this.mp = mp;
    }

    public DoublyLinkImpl<Key> getDoublylinkedlist() {
        return this.doublylinkedlist;
    }

    public void setDoublylinkedlist(DoublyLinkImpl<Key> doublylinkedlist) {
        this.doublylinkedlist = doublylinkedlist;
    }


    @Override
    public void KeyTouched(Key obj) {
        
        if(mp.containsKey(obj))
        {
            doublylinkedlist.removeNode(mp.get(obj));
            DoublyLinkedListNode<Key> dnode = doublylinkedlist.addNodeAtLast(obj);
            mp.put(obj,dnode);
            System.out.println("value is properly touched1");
        }else{
            DoublyLinkedListNode<Key> dnode = doublylinkedlist.addNodeAtLast(obj);
            mp.put(obj, dnode);
            System.out.println("value is properly touched2");
        }
        
        
    }
    
}
