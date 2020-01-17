package com.codewithinoussa.List;

import java.util.*;
import java.util.List;

public class ListDemo {
    public static void show(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b", "e2"));
        customers.add(new Customer("a", "e3"));
        customers.add(new Customer("c", "e1"));
        Collections.sort(customers);
        System.out.println(customers);
        Collections.sort(customers, new EmailComparator());
       /* List<String> list  = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Collections.addAll(list, "d", "e", "a" );
        list.add(0, "?"); // put '?' at index 0
        list.set(0, "a+");
        list.remove("e");*/
        System.out.println(customers);
    }
}
