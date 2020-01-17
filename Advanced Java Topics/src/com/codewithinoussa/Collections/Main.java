package com.codewithinoussa.Collections;

import java.util.*;

public class Main {
    public static void main(String[] args){
        CollectionsDemo.show();

        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        Collections.addAll(collection, "d", "e", "f");
        Object[] objectArray = collection.toArray();
        //String[] stringArray = collection.toArray(new String[0]);
        var stringArray = collection.toArray(new String[0]);

        Collection<String> other  =  new ArrayList<>();
        other.addAll(collection);
        System.out.println(collection == other);
        System.out.println(collection.equals(other));

        System.out.println(collection.contains("e"));
        for (var item : collection)
            System.out.println(item);
    }
}
