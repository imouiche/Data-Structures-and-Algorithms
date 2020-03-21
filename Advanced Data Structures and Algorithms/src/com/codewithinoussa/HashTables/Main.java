package com.codewithinoussa.HashTables;

import javax.print.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //key: Employee Number
        //value: Name:
        var table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(16, "A+");
        System.out.println(table.get(6));

    }

    public static int hash(String key){
        int hash = 0;
        for (var ch : key.toCharArray())
            hash += ch; // implicit casting
        return hash % 100;
    }
}
