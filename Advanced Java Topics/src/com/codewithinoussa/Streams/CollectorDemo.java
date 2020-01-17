package com.codewithinoussa.Streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CollectorDemo {
    public static void show(){
        List<Movies> movies = List.of(
                new Movies("b", 10, Genre.THRILLER),
                new Movies("a", 30, Genre.THRILLER),
                new Movies("c", 20, Genre.THRILLER)
        );
        //Suppose we want to collect movies using List, Set Array instead of forEach
        //toMap returns hashMap {key:value}, we also have toSet, toList
        var result = movies.stream()
                .collect(Collectors.toMap(Movies::getTitle, Movies::getLikes));
        System.out.println(result);
        // suppose ww to return movies as values
        var result1 = movies.stream()
                .collect(Collectors.toMap(Movies::getTitle, Function.identity()));
        //.collect(Collectors.toMap(Movies::getTitle, m ->m));
        //.collect(Collectors.SummingInt(Movies::getLikes));
        System.out.println(result1);

        //Summarizing
        var result3 = movies.stream()
                .collect(Collectors.summarizingInt(Movies::getLikes));
        System.out.println(result3);

        //Joining
        var result4 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movies::getTitle)
                .collect(Collectors.joining(",")); //concatenate the name of all the movies
        System.out.println(result4);
    }
}
