package com.codewithinoussa.SortingAlgorithms;
public class QuickSort {
    public void sort(int [] array){
        sort(array, 0, array.length -1);
    }

    //0, 9 -> array of 9 elts
    // 4 pivot -> pivot is at index 4
    // 0, 3 (left p)
    //5, 9 (right p)

    private void sort(int [] array, int start, int end){
        //base condi => single item in the array
        if (start >= end)
            return;
        //Partition
        var boundary = partition(array, start, end);
        // sort left
        sort(array, start, boundary -1);
        //sort right
        sort(array, boundary + 1, end);
    }

    //get the index of the pivot after it's moved to it correct position
    private int partition(int [] array, int start, int end){
        var pivot = array[end];
        var boundary = start - 1; // means the left partition is empty and teh right partition start at 0
        //iterate over if item < pivot, then increment the boundary and move the item to the left P with swap

        for (var i = start; i <= end; i++){
            if (array[i] <= pivot)
              //  boundary++;
                swap(array, i, ++boundary);
        }
        return boundary;
    }

    private void swap(int [] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
