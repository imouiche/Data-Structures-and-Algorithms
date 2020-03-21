package com.codewithinoussa.SortingAlgorithms;

import com.codewithinoussa.Arrays.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] numbers = {7, 3, 1, 5, 6, 2, 3};
        var sorter = new BucketSort();
        sorter.sort(numbers, 3);
        System.out.println(Arrays.toString(numbers));
    }
}
