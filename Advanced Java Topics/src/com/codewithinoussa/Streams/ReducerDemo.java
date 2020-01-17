package com.codewithinoussa.Streams;

import java.util.*;

public class ReducerDemo {
    public static void show(){
        List<Movies> movies = List.of(
                new Movies("b", 10, Genre.THRILLER),
                new Movies("a", 30, Genre.THRILLER),
                new Movies("c", 20, Genre.THRILLER)
        );
        //AnyMatch , allMatch, noneMatch, findFirst
        var result = movies.stream()
                .allMatch(m -> m.getLikes() > 10);
        System.out.println(result);
        //findFirst
        var result1 = movies.stream()
                .findFirst()
                .get();
        System.out.println(result1.getTitle());
        // max
        var result2 = movies.stream()
                .max(Comparator.comparing(Movies::getLikes))
                .get();
        System.out.println(result2.getTitle());

        // Reducing a Stream
        Optional<Integer> sum = movies.stream()
                .map(m -> m.getLikes())
                .reduce(Integer::sum); // Binary operator
                 //reduce((a, b) -> a + b);
                //reduce( 0, Integer::sum); can be used to get ride of the Optional
        System.out.println(sum.orElse(0));
    }
}
