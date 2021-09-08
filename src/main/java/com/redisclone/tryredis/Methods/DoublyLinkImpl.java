package com.redisclone.tryredis.Methods;

public class DoublyLinkImpl<T> {

    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    

    public DoublyLinkImpl() {
        this.head=null;
        this.tail=null;
    }
    
    public void addNode(T obj)
    {
        DoublyLinkedListNode<T> new_node = new DoublyLinkedListNode<T>();
        new_node.setObj(obj);

        if(head == null)
        {
            head = tail = new_node;
            head.setPrev(null);
        }else{
            tail.setNext(new_node);
            new_node.setPrev(tail);
            tail = new_node;
            tail.setNext(null);
        }
    }

    public void removeNodeAtFront()
    {
       head=head.getNext();
    }

    public void removeNode(DoublyLinkedListNode<T> removeNode)
    {
      DoublyLinkedListNode<T> prev = removeNode.getPrev();
      DoublyLinkedListNode<T> next = removeNode.getNext();

      prev.setNext(next);
      next.setPrev(prev);
    }

    public void PrintAllNodes()
    {
        DoublyLinkedListNode<T> current = head;
        if(head == null)
        {
            System.out.println("The doubly link list is empty");
            return;
        }

        while(current!=null)
        {
            System.out.print(current.getObj()+" ");
            current = current.getNext();
        }
    }

    public DoublyLinkImpl(DoublyLinkedListNode<T> head, DoublyLinkedListNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public DoublyLinkedListNode<T> getHead() {
        return this.head;
    }

    public void setHead(DoublyLinkedListNode<T> head) {
        this.head = head;
    }

    public DoublyLinkedListNode<T> getTail() {
        return this.tail;
    }

    public void setTail(DoublyLinkedListNode<T> tail) {
        this.tail = tail;
    }

    public DoublyLinkImpl<T> head(DoublyLinkedListNode<T> head) {
        setHead(head);
        return this;
    }

    public DoublyLinkImpl<T> tail(DoublyLinkedListNode<T> tail) {
        setTail(tail);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " head='" + getHead() + "'" +
            ", tail='" + getTail() + "'" +
            "}";
    }

    
    
}
