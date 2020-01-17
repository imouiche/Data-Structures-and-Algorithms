package com.codewithinoussa.ThreadsConcurrency;

import java.util.*;
import java.util.concurrent.*;

public class SynchronizedCollections {
    public static void show(){
        // Suppose we need to share our collection across many threads
        //Collection<Integer> collection =  new ArrayList<>(); //Race issue
        Collection<Integer> collection =
                Collections.synchronizedCollection( new ArrayList<>()); // solved the race condition

        // lets start 2 threads and have each thread adding 3 items to this collection

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1,2,3));
        });
        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4,5,6));
        });

        thread1.start();
        thread2.start();

        // join them
        try {
            thread1.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //1 Race condition happened ie 2 threads competing to modify our collection concurrently
        System.out.println(collection);

        // 2 Concurrent Collections
        // use ConcurrentHashMap<>() id multiple threads will be modifying our map
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1,"a");
        map.get(1);
        map.remove(1);

    }

}
