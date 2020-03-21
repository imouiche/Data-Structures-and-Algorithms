package com.codewithinoussa.Stack;

import java.util.*;

public class StackDemo {
    private int [] items;
    private int count;
    private int size;

    public StackDemo(int size){
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

    public boolean isFull(){
        return items.length == count;
    }
    /*public Stack resize(){
        var newStack = new int[count *2];

    }*/

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
