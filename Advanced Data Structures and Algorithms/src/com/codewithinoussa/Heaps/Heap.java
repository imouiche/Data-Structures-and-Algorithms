package com.codewithinoussa.Heaps;

import java.util.*;

public class Heap {
    private int [] items;
    private int size;
    private int count;

    public Heap(int size) {
        this.size = size;
        items = new int[this.size];
    }

    public void insert(int value){
        if (isFull())
            throw new IllegalStateException();
        items[count++] = value;
        //bubbleup
        bubbleUp();
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--count];
        //bubbleDown
        bubbleDown();

        return root;
    }

    private void bubbleDown(){
        var index = 0;
        while (index <= count && !isValidParent(index)){
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex; // may go larger than the size, hence index <= count condition
        }
    }

    private int largerChildIndex(int index){
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return  (leftChild(index) > rightChild(index))?
                leftChildIndex(index) : rightChildIndex(index);
    }

    public boolean hasLeftChild(int index){
        return leftChildIndex(index) <= count;
    }

    public boolean hasRightChild(int index){
        return rightChildIndex(index) <= count;
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;

        var isValid = items[index] >= leftChild(index);

        if (hasRightChild(index))
           isValid &= items[index] >= leftChild(index);

        return items[index] >= leftChild(index) &&
                items[index] >= rightChild(index);
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return index * 2 + 1;
    }

    private int rightChildIndex(int index){
        return index * 2 + 2;
    }

    public boolean isFull(){
        return count == items.length;
    }

    private void bubbleUp(){
        var index = count - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            //swap
            swap(index, parent(index));
            index = parent(index); //add cond to make sure the index > 0
        }
    }

    private void swap(int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int parent(int index){
        return (index -1)/2;
    }

    public int max(){
        if (isEmpty())
            throw new IllegalStateException();
        return items[0];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
