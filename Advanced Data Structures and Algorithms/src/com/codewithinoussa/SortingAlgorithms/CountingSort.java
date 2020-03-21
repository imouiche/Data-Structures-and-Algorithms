package com.codewithinoussa.SortingAlgorithms;

public class CountingSort {

    public void sort(int [] array, int max){
        int[] counts = new int[max + 1];
        for (var item : array)
            counts[item]++; //we use item here as index

        var k = 0;
        for (var i = 0; i < counts.length; i++)
            for (var j = 0; j < counts[i]; j++)
                array[k++] = i;

    }
}
