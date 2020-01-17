package com.codewithinoussa.Streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

//Imperative Vs Functional Programming
public class StreamsDemo {
    public static void show() {
        List<Movies> movies = List.of(
          new Movies("b", 10, Genre.THRILLER),
          new Movies("b", 10, Genre.THRILLER),
          new Movies("a", 30, Genre.THRILLER),
          new Movies("c", 20, Genre.THRILLER)
        );

        //Imperative programming
        int count1 =0;
        for (var movie: movies){
            if (movie.getLikes()>10)
                count1++;
        }
        //streams is like a pipe to collect all elts from a collection
        // Declarative (Functional) Programming
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();

        System.out.println(count1==count2);

        //lets suppose we want a stream of movies names
        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(name -> System.out.println(name));
        //get the number of likes
        movies.stream()
                .mapToInt(movie -> movie.getLikes())
                .forEach(n -> System.out.println(n));

        //flatmap -> Stream<List/Set<x>> -> Stream<x>
        var stream = Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream
                .flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));

        //Filtering a stream

        Predicate<Movies> isPopular = m -> m.getLikes() > 10;
        movies.stream()
                .filter(isPopular) //Intermediate
                .forEach(m -> System.out.println(m)); // terminal

        //Slicing Streams
        //-Skip()
        /*
        1000 movies, 10 movies per page
        for the 3rd page => skip(20)= skip((page-1)*pageSize)
        limit(10) = limit(pageSize)
         */
        movies.stream()
                .skip(10)
                .forEach(m -> System.out.println(m.getTitle()));
        //- takeWile and dropWhile
        movies.stream()
                .takeWhile(m -> m.getLikes() > 10)
                .forEach(m -> System.out.println(m.getTitle()));

        //Sorting streams
        System.out.println("Sorting Streams ");
        movies.stream()
               // .sorted((a,b) -> a.getTitle().compareTo(b.getTitle()))
               // .sorted(Comparator.comparing(m -> m.getTitle()))
                .sorted(Comparator.comparing(Movies::getTitle).reversed())
                .forEach(m -> System.out.println(m.getTitle()));

        //8 -Getting unique element
        System.out.println("8 -Getting unique element");
        movies.stream()
                .map(Movies::getLikes)
                .distinct()
                .forEach(System.out::println);

        System.out.println("9- Peeking Elements");
        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("Filtered: " +m.getTitle()))
                .map(Movies::getTitle)
                .peek(t -> System.out.println("mapped: " +t))
                .forEach(System.out::println);
    }
}
