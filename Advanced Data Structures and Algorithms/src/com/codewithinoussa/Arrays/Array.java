package com.codewithinoussa.Arrays;

import java.util.*;

public class Array {
    private int size;
    private int totalItems;
    private int [] list;

    public Array(int size) {
        this.size = size;
        this.totalItems = 0;
        this.list = new int[this.size];
    }

    public void insert(int item){
        //if the array is full
       resizeIfRequired();
        list[totalItems++] = item;
        //totalItems++;
    }
    public void removeAt(int index){
        //Validate the index
        if (index < 0 || index >= totalItems)
            throw new IllegalArgumentException();
        //shift the items to the left to fill the hole
        for (int i=index; i<totalItems; i++ )
            list[i] = list[i+1];
        totalItems--;
//        return list[index];
    }

    public int indexOf(int item){
        // if we find the item, return the index otherwise return -1
        for (int i=0; i<totalItems; i++)
            if (list[i]==item)
                return i;
        return -1;
    }
    public void print(){
        for (int i=0; i<totalItems; i++)
        System.out.println(list[i]);
    }
    public void max(){
        int maxElt = -1;
        for (int i=0; i<totalItems; i++) {
            if (list[i] > maxElt)
                maxElt = list[i];
        }
        System.out.println(maxElt);

    }

    public void reverse() {
        int[] newList = new int[totalItems];
        System.out.println(totalItems);
        for (int i = 0; i < totalItems; i++)
            newList[i] = list[totalItems-1-i];
        list = newList;
    }

    //insert at a given index
    public void insertAt(int item, int index) {
        if (index < 0 || index > totalItems)
            throw new IllegalArgumentException();

        // Note that I've extracted the logic for
        // resizing the array into this private
        // method so we can reuse in insert() and
        // insertAt() methods.
        //
        // This also made our code cleaner and
        // more readable.
        resizeIfRequired();

        for (int i = totalItems - 1; i >= index; i--)
            list[i + 1] = list[i];

        list[index] = item;
        totalItems++;
    }

    private void resizeIfRequired() {
        if (list.length == totalItems) {
            int[] newItems = new int[totalItems * 2]; //double size

            for (int i = 0; i < totalItems; i++)
                newItems[i] = list[i];

            list = newItems;
        }
    }

    //find the intersection
    public Array intersect(Array other) {
        var intersection = new Array(totalItems);

        for (int item : list)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        return intersection;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
