package com.codewithinoussa.Queue;

import java.util.*;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public void enqueue(int item){
        var node = new Node(item);
        if (isEmpty()){
            head = tail = node;
        }else{
            tail.next = node;
            node = tail;
        }
         count++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        int value;
        if (head == tail){
            value = head.value;
            head = tail = null;
        }else {
            value = head.value;
            var second = head.next;
            head.next = null;
            head = second;
        }
        count--;

        return value;
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        return head.value;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public String toString(){
        ArrayList<Integer> list = new ArrayList<>();

        var current = head;
        while(current != null){
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }
}
