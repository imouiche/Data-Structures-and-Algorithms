package com.codewithinoussa.Streams;

import java.util.*;
import java.util.stream.*;

public class GroupingDemo {
    public static void show(){
        List<Movies> movies = List.of(
                new Movies("b", 10, Genre.THRILLER),
                new Movies("a", 30, Genre.ACTION),
                new Movies("c", 20, Genre.ACTION)
        );
        var result = movies.stream()
                .collect(Collectors.groupingBy(Movies::getGenre, Collectors.counting()));
        System.out.println(result);

        var result2 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movies::getGenre,
                        Collectors.mapping(
                                Movies::getTitle,
                                Collectors.joining(","))));
        System.out.println(result2);

        //14- Partitioning Elements
        /*
        ie movies that have more than 3 likes and movies that have more than 4 likes
         */
        var result3 = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() >20,
                        Collectors.mapping(
                                Movies::getTitle,
                                Collectors.joining(","))));
        System.out.println(result3);

    }
}
