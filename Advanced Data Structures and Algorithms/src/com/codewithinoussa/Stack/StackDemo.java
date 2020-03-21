package com.codewithinoussa.Stack;

import java.util.*;

public class StackDemo {
    private int [] items;
    private int count;
    private int size;

    public StackDemo(int size){
        if (size <= 0)
            throw new IllegalArgumentException("size must be 1 or greater.");
        this.size = size;
        count = 0;
        items = new int[this.size];
    }

    public void push(int item){
        if (isFull())
            throw new StackOverflowError();
        items[count++] = item;

    }
    public int pop(){
        if (count == 0)
            throw new IllegalStateException();
        return items[--count];
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();
        return items[count - 1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return items.length == count;
    }
    /*public Stack resize(){
        var newStack = new int[count *2];

    }*/

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
