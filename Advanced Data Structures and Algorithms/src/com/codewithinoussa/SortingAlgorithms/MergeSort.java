package com.codewithinoussa.SortingAlgorithms;

public class MergeSort {
    // 1- Divide this array into half
    // 2- Sort each half
    // 3- Merge the result
    public void sort(int [] array){

        // base condition => array of 1 item is already sorted
        if (array.length < 2)
            return;
        // 1- Divide this array into half
        var middle = array.length /2;
        // create left and right partitions
        var left = new int[middle];
        for (var i = 0; i < middle; i++)
            left[i] = array[i];

        var right = new int[array.length - middle];
        for (var i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        // 2- Sort each half
        sort(left);
        sort(right);

        // 3- Merge the result
        merge(left, right, array);
    }

    private void merge(int [] left, int [] right, int [] result){
        int i = 0, j = 0, k = 0; // i for left partition, j for the right and k for the result
        // Iterate over the left n right partitions and pick the smallest to store in the result

        while ( i < left.length && j < right.length){
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        //If partitions are not equals, then we need to copy the remaining items to the result

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
