package com.codewithinoussa.StringManipulation;

import com.codewithinoussa.Arrays.*;

import java.util.*;

public class UsefulMethods {
    public static void main(String[] args){
        //useful methods
        String sentence = "trees are beautiful";
        String[] words = sentence.split( " ");
        System.out.println(Arrays.toString(words));

        //Integer [] numbers = {1, 4, 3, 6, 0, 2};
        int [] numbers = {1, 4, 3, 6, 0, 2};
       // Arrays.sort(numbers);
        //Collections.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        //Boolean areEqual = Arrays.equals(int [] a, int[] b);

      //  List<Integer> list = Arrays.asList(numbers);
        List<Integer> list = Arrays.asList(5, 2, 4, 9, 0);
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
