package com.codewithinoussa.PriorityQueue;

import java.util.*;
//In PQ, items are removed from the queue based on their priority.
//items are stored in ascending order
public class PriorityQueue {
    private int[] items;
    private int size;
    private int rear;
    private int front;
    private int count;

    public PriorityQueue(int size){
        this.size = size;
        items = new int[this.size];
    }

    // -> O(n) because of shifting process
    // this reduces to O(log(n)) or O(h) if we use Heaps to build our PQ
    public void add(int item){
        if (isFull())
            throw new IllegalStateException();

        var i = shiftingItemsToInsert(item); // -> O(n)
        items[i] = item;
        count++;
    }
    public int shiftingItemsToInsert(int item){
        //Shifting item
        int i;
        for (i= count -1; i >= 0; i--){
            if (items[i] > item)
                items[i+1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    //remove() -> simply reduce the size of our queue -> O(1)
    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count]; //larger values -> high priority
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return items.length == count;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
