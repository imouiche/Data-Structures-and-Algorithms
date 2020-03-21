package com.codewithinoussa.Queue;

import java.util.*;

public class ArrayQueue {
    private int front;
    private int rear;
    private int size;
    private int count;
    private int[] items;

    public ArrayQueue(int size) {
        this.size = size;
        front = 0;
        rear = 0;
        items = new int[this.size];
    }

    public void enqueue(int item){
        if (isFull())
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length; //Circular array
        count++;
    }
    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();
        // return items[front++]; or
        var item = items[front];
        items[front] = 0;
        front = (front +1) % items.length; //circular array
        count--;
        return item;
    }

    private boolean isFull(){
        return items.length == count;
    }
   /* private void resize(){
        var newItems = new int[rear * 2];
        for (int i=0; i < items.length; i++)
            newItems[i] = items[i];
        items = newItems;
    }*/
   public void reverse(int k){
       Stack<Integer> stack = new Stack<>();
       k = (front + k) % items.length;
       for (int i=front; i < k; i++)
           stack.push(items[i]);
       for (int i=front; i < k; i++)
           items[i] = stack.pop();
      // return outPut;
   }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    private boolean isEmpty(){
       return items.length == 0;
    }
}
