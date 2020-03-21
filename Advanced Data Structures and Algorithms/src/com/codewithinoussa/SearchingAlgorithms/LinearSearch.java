package com.codewithinoussa.SearchingAlgorithms;

public class LinearSearch {
    public int linearSearch(int [] array, int target){
       for (var i = 0; i < array.length; i++){
           if (array[i] == target)
               return i;
       }
       return -1;
    }
}
