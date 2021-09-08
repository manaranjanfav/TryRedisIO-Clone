package com.redisclone.tryredis.Methods;

public class DoublyLinkedListNode<T> {
    private DoublyLinkedListNode<T> prev;
    private DoublyLinkedListNode<T> next;
    private T obj;

    public DoublyLinkedListNode() {
        this.prev = null;
        this.next = null;
    }

    public DoublyLinkedListNode(DoublyLinkedListNode<T> prev, DoublyLinkedListNode<T> next, T obj) {
        this.prev = prev;
        this.next = next;
        this.obj = obj;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public T getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public DoublyLinkedListNode<T> prev(DoublyLinkedListNode<T> prev) {
        setPrev(prev);
        return this;
    }

    public DoublyLinkedListNode<T> next(DoublyLinkedListNode<T> next) {
        setNext(next);
        return this;
    }

    public DoublyLinkedListNode<T> obj(T obj) {
        setObj(obj);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " prev='" + getPrev() + "'" +
            ", next='" + getNext() + "'" +
            ", obj='" + getObj() + "'" +
            "}";
    }
    
}
