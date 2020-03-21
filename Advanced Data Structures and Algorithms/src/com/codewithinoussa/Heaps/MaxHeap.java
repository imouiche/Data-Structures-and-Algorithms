package com.codewithinoussa.Heaps;

public class MaxHeap {
    public static void heapify(int[] array) {
        for (int i = 0; i < array.length; i++)
            heapify(array, i);
    }

    public static void optimalHeapify(int[] array) {
        /*
       1-  lastParent node = (n/2) -1 to validate
        so we don't have to traverse the entire tree
       2- if we validate from the bottom we'll have have less recursions
         */
        var lastParentIndex = array.length/2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index){
        var largerIndex = index; // assuming the larger index

        var leftIndex = index *2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index *2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex); //recursion
    }

    private static void swap(int [] array, int first, int second){
        var tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    public static int getKthLargest(int [] array, int k){
        if ( k < 1 || k > array.length)
            throw new IllegalStateException();

        var heap = new Heap(10);
        for (var number : array)
            heap.insert(number);
        //Now execute the delete operation k-1 times
        for (var i= 0; i < k-1; i++)
            heap.remove();
        return heap.max();
    }

}
