package com.codewithinoussa.BestPriceFinderProject;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/*
Here we want to get a Quote for a given flight agency asynchronously
 */
public class FlightService {

    public Stream<CompletableFuture<Quote>> getQuotes(){
        //define a list of sites
        var sites = List.of("site1", "site2", "site3");
        return sites.stream()
                .map(this::getQuote);
    }

    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("getting a Quote from :" + site);
        //simulate a remote service
            var random = new Random();
            LongTask.simulate(1_000 + random.nextInt(2_000));
        //generate a random price
            var price  = 100 + random.nextInt(10); // btw $100 to $110
            return new Quote(site, price);
        });

    }
}
