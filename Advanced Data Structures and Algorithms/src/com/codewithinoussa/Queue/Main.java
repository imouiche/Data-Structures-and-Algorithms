package com.codewithinoussa.Queue;

import java.util.*;

public class Main {
    public static void main(String[] args){
        var queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
       // queue.enqueue(60);

        System.out.println(queue);
        var front = queue.dequeue();
        queue.enqueue(60);
        System.out.println(front);
        queue.reverse(2);
        System.out.println(queue);


    }

    /*public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.empty())
            queue.add(stack.pop());
    }*/
}
