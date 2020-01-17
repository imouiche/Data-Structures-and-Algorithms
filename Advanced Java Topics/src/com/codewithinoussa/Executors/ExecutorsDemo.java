package com.codewithinoussa.Executors;


import java.util.concurrent.*;

public class ExecutorsDemo {

    public static void show() {
        var executor =  Executors.newFixedThreadPool(2);
        try{
           var future =  executor.submit(() ->{
                LongTask.simulate();
                return 1;
            });
            System.out.println("Do more work");
            try {
                var result  = future.get();// has to wait until the current task ia ready, then synchronized
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        finally {
            executor.shutdown(); // shutdown the executor
        }
    }
}
