package com.codewithinoussa.HashTables;

import java.util.*;

public class HashTableExercises {
    /*
    3- Given an array of integers, return indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSum(int[] numbers, int target){
        // If a + b = target, then b = target - a.
        //we define a map to store KV (number, index) for optimization
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            int complement =  target - numbers[i];
            if (map.containsKey(complement))
                return new int[] {map.get(complement), i};
            map.put(complement, i);
        }

        return null;
    }


    //Find the most repeated element in an array of integers
    public int MostRepeatedElement(int[] array){
        var map = new HashMap<Integer, Integer>();
        int count;
        for (int key : array){
            count = map.containsKey(key) ? map.get(key) : 0;
            map.put(key, count + 1);
        }
        int result = 0;
        int max = 0;
        for (var entry : map.entrySet()){
           if (entry.getValue() > max){
               max = entry.getValue();
               result = entry.getKey();
           }
        }

        return result;
    }
/*
Given an array of integers, count the number of unique pairs of integers that have difference k.
 */
    public int countPairsWithDiff(int[] numbers, int diff){

        // For a given number (a) and difference (diff), number (b) can be:
        // b = a + diff
        // b = a - diff
        // So, we start by adding all the numbers to a set for quick look up.
        Set<Integer> set  = new HashSet<>();
        for (var elt : numbers){
              set.add(elt);
          }
        int count = 0;
        for (var number : numbers){
            if (set.contains(number + diff))
                count++;
            if (set.contains(number - diff))
                count++;
            set.remove(number);// remove number so we don't double count it
        }
        return count;
    }


}
