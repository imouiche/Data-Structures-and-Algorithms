package com.codewithinoussa.SortingAlgorithms;

public class BubbleSort {
    public void sort(int [] array){
        boolean isSorted; //optimization
        for (int i=0; i < array.length; i++){
            isSorted = true;
            //array.length - i for optimization coz at each pass item is moved to its correct position
            // So no need to iterate over the entire array.
            for (int j = 1; j < array.length - i; j++)
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    private void swap(int [] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
