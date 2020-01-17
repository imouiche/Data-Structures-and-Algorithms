package com.codewithinoussa.Queue;

import java.util.*;

public class QueueDemo {
    public static void show(){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
      //  queue.offer("d");

        //d-> b -> a -> c
        var front = queue.peek(); // return null if queue is empty while queue.element() throw exceptions
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
