package com.codewithinoussa.Set;

import java.util.*;

public class SetDemo {
    public static void show(){
        //Set<String> set = new HashSet<>();
/*        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");*/
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "c");
        Set<String> set = new HashSet<>(collection);
        System.out.println(set);

        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));

        //Union of 2 sets
        //set1.addAll(set2);
        System.out.println("Union of set1 and set2: " + set1);
        //Intersection
        //set1.retainAll(set2);
        System.out.println("Intersection of set1 and set2: " + set1);

        //Difference
        set1.removeAll(set2);
        System.out.println("Intersection of set1 and set2: " + set1);
    }
}
