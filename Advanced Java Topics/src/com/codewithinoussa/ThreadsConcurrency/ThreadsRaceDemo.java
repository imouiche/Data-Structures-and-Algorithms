package com.codewithinoussa.ThreadsConcurrency;

import java.util.*;

public class ThreadsRaceDemo {
    public static void show() {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();
        //start 10 threads
        for (var i=0; i<10; i++) {
            var task =new DownloadFileTask();
            tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread); //add thread to a list
        }
        // use the list to join all threads simultaneously after the download has completed
        //use join() to wait for the download phase to complete

        for ( var thread:threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //combing the total number of bytes created by all threads
        var totalNumberOfBytes =tasks.stream()
                .map(t -> t.getStatus().totalBytes)
                .reduce(0, Integer::sum); // reduce(0, (a,b) -> a + b);
        System.out.println("total bytes: "+totalNumberOfBytes);

        }


    }
