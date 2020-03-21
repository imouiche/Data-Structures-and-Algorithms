package com.codewithinoussa.SearchingAlgorithms;

public class BinarySearch {
    public int binarySearch(int [] array, int target){
       return binarySearch(array, 0, array.length -1, target);
    }

    private int binarySearch(int [] array, int start, int end, int target){

        if (end < start)
            return -1;
        var middle = (start + end)/2;
        if (array[middle] == target)
            return middle;

        if (array[middle] < target)
            return binarySearch(array, middle + 1, end, target);

        return binarySearch(array, start, middle - 1, target);

    }

    public int binearySearchIterative(int [] array, int target){
        var left = 0;
        var right = array.length -1;

        while (left <= right){
            var middle = (left + right) / 2;
            if (array[middle] == target)
               return middle;
            if (target < array[middle])
                right = middle -1;
            else
                left = middle + 1;
        }

        return -1;
    }
 }
