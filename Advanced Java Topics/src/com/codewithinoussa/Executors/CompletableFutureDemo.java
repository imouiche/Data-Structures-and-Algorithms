package com.codewithinoussa.Executors;

import org.w3c.dom.ls.*;

import java.util.concurrent.*;
import java.util.function.*;

public class CompletableFutureDemo {
    public static int toFahrenheit(int celsius){
        return (int) (celsius*1.8) + 32;
    }
    //we call CompletableFuture so our task will be executed using a different thread
    public static CompletableFuture<String> getEmailAsync(){
        // blabla ..
        return CompletableFuture.supplyAsync(() -> "email");
    }
    // getting user playlist method
    public static CompletableFuture<String> getPlaylistAsync(String email){
        return  CompletableFuture.supplyAsync(() -> "Playlist");
    }

    public static void show(){
        /*Supplier<Integer> task = () -> 1;
        var future = CompletableFuture.supplyAsync(task); // creating a completable future object
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        // 9 - Running code on completion
       /* var future = CompletableFuture.supplyAsync(() ->1);
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });
        //thenAccept
        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });*/

       // 10 - Handling Exception
      /* var future =  CompletableFuture.supplyAsync(() ->{
           System.out.println("Getting the current weather");
           throw new IllegalStateException();
       });
        try {
            //return the last temp (supose it's 1) when exception happens ahead
            //future.get();
            var temperature  = future.exceptionally(ex -> 1).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        /*// 11- Transforming a Completable Future : thenApply()
        var future = CompletableFuture.supplyAsync(() -> 20);
        future
                .thenApply(CompletableFutureDemo::toFahrenheit)
                .thenAccept(f -> System.out.println(f));*/
        /*try {
            var result = future
                    .thenApply(CompletableFutureDemo::toFahrenheit)
                    .get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        /*// 12 - Composing Completable Futures
        //id -> email
        var future = CompletableFuture.supplyAsync(() -> "email");
        future
                .thenCompose(email -> CompletableFuture.supplyAsync(() -> "Playlist"))
                .thenAccept(playlist -> System.out.println(playlist));

        getEmailAsync()
                .thenCompose(CompletableFutureDemo::getPlaylistAsync)
                .thenAccept(playlist -> System.out.println(playlist));
        //email -> playlist*/

       /* // 13 - Combining Completable Future
        //20 USD
        //.9
        var first = CompletableFuture
                .supplyAsync(() -> "20USD")
                .thenApply(str -> {
                    var price  = str.replace("USD", "");
                    return  Integer.parseInt(price);
                });
        var second = CompletableFuture.supplyAsync(() -> .9);
        first.thenCombine(second, (price, exchangeRate) -> price*exchangeRate)
                .thenAccept(result -> System.out.println(result));
        */

        // 14- Waiting for many tasks to complete
        var first  = CompletableFuture.supplyAsync(() -> 1);
        var second  = CompletableFuture.supplyAsync(() -> 2);
        var third  = CompletableFuture.supplyAsync(() -> 3);
        // waiting for all tasks to complete
        var all =  CompletableFuture.allOf(first,second,third);
        all.thenRun(() -> {
            try {
                var firstResult = first.get();
                System.out.println(firstResult);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks completed successfully");
        });

        // 15 - Waiting for the First Task
        //var all =  CompletableFuture.anOf(first,second,third);

        // 16 - Handling TimeOut
         var future  =  CompletableFuture.supplyAsync(() -> {
             LongTask.simulate();
             return 1;
         });
        try {
            //future.orTimeout(1, TimeUnit.SECONDS)
            var result  = future.completeOnTimeout(2, 1, TimeUnit.SECONDS)
                    .get(); // 2 is the default value
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
