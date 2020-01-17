package com.codewithinoussa.MapOrHashTable;

import com.codewithinoussa.List.*;

import java.util.*;

public class MapDemo {
    public static void show() {
        //Java: Maps
        //Python/C#: Dictionary
        //JavaScript: Object i.e. var person = {nam : "a"}

        Customer c1 = new Customer("a", "e1");
        Customer c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var Unknown = new Customer("Unknown", "");
       // var customer  = map.get("e1");
        var customer  = map.getOrDefault("e2", Unknown);
        var exist = map.containsKey("e10");
        var updateCustomer = map.replace("e1", new Customer("a++", "e1"));
        System.out.println(map);

        /*for (var key : map.keySet())
            System.out.println(key);*/
        /*for (var entry : map.entrySet())
            System.out.println(entry.getValue());*/
        for (var customers : map.values())
            System.out.println(customers);
    }
}
