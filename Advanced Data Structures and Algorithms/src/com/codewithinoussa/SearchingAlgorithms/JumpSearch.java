package com.codewithinoussa.SearchingAlgorithms;

public class JumpSearch {
    public int jumpSearch(int [] array, int target){
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        //Edge cases start >= array.length and next > array.length
        while(start < array.length && array[next - 1] < target) {
            start = next; // jump
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

         //now linear search
        for (var i = start; i < next; i++)
            if (array[i] == target)
                return i;
        return -1;

    }
}
