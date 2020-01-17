package com.codewithinoussa.Streams;

import org.w3c.dom.ls.*;

import java.util.stream.*;

public class PrimitiveStreams {
    public static void show(){
        //IntStream.range 5 or the upper bound is not included
        IntStream.rangeClosed(1,5)
                .forEach(System.out::println);
    }
}
