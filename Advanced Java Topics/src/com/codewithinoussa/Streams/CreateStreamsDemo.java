package com.codewithinoussa.Streams;

import java.util.*;
import java.util.stream.*;

public class CreateStreamsDemo {
    public static void showCreateStreams(){
        Stream.of(1,2,3,4);
        var stream = Stream.generate(() -> Math.random()); // infinite number of streams i generated
        stream
                .limit(3) //provide the size limit
                .forEach(n -> System.out.println(n));

        // another way to generate infinite values, seed is the initial value
        Stream.iterate(1, n -> n + 1) // unary operator
                .limit(10)
                .forEach(n -> System.out.println(n));

        int[] numbers = {1,2,3};
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(n));
    }
}
