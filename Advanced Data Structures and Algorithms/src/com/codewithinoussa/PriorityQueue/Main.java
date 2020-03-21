package com.codewithinoussa.PriorityQueue;

import java.util.*;

public class Main {
    public static void  main(String [] args){
       var queue = new PriorityQueue(5);
        queue.add(5);
        queue.add(3);
        queue.add(6);
        queue.add(1);
        queue.add(4);
        System.out.println(queue);

    }
}
