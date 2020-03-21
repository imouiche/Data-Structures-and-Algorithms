package com.codewithinoussa.Heaps;

import com.codewithinoussa.Arrays.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        var heap = new Heap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.remove();
        //System.out.println(heap);
        int[] numbers =  {5, 3, 8, 4, 1, 2};
        /*var tmp = sort(numbers);
        System.out.println(Arrays.toString(tmp));*/
       // MaxHeap.heapify(numbers);
        System.out.println(MaxHeap.getKthLargest(numbers,2));


    }

    public static int [] sort(int [] numbers){
        var heap =  new Heap(10);
        for (int i=0; i < numbers.length; i++)
            heap.insert(numbers[i]);
        //descending order
        /*for (int i=0; i < numbers.length; i++)
            numbers[i] = heap.remove();*/
        //Ascending order
        for (int i= numbers.length -1; i >=0; i--)
            numbers[i] = heap.remove();
        return numbers;
    }
}
