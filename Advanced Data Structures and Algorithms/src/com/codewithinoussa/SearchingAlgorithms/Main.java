package com.codewithinoussa.SearchingAlgorithms;

public class Main {
    public static void main(String[] args){
        int [] numbers = { 1,40,31,4,9,22};
        var search = new JumpSearch();
        var index = search.jumpSearch(numbers, 22);
        System.out.println(index);
    }
}
