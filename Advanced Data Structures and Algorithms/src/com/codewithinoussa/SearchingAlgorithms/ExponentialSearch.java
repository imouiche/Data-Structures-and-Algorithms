package com.codewithinoussa.SearchingAlgorithms;

public class ExponentialSearch {
    public int exponentialSearch(int [] array, int target){
        int bound = 1;

        while (bound < array.length && array[bound] < target){
            bound *= 2;
        }

        var left = bound / 2; // bound at previous iteration
        var right = Math.min(bound, array.length - 1); //as bound could be > array.length at last iteratio

        return binarySearch(array, target, left, right);
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
}
