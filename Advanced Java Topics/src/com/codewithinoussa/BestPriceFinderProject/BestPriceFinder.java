package com.codewithinoussa.BestPriceFinderProject;

import java.time.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class BestPriceFinder {
    public static void show(){
        var start = LocalTime.now();
        var service  = new FlightService();
        /*service.getQuote("site1")
                .thenAccept(System.out::println);*/
        var futures  = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " msec.");
                });


        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
