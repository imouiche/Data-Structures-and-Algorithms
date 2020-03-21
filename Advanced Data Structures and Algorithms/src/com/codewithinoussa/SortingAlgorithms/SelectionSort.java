package com.codewithinoussa.SortingAlgorithms;

public class SelectionSort {
    public void sort(int [] array){
        for (var i = 0; i < array.length; i++){
            var minIndex = minIndex(array, i);
            swap(array, minIndex, i);
        }
    }

    private int minIndex(int [] array, int i){
        var minIndex = i;
        for (var j = i; j < array.length; j++)
            if (array[j] < array[minIndex])
                minIndex = j;

        return minIndex;
    }

    private void swap(int [] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
