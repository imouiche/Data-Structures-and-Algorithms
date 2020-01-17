package com.codewithinoussa.Lambdas;

import java.util.*;
import java.util.function.*;

public class ConsumerInterface {
    public static void showConsumer() {
        /*List<Integer> list = List.of(1, 2, 3);

        //Imperative programming (for, if/else, switch/case)
        for (var item : list)
            System.out.println(item);
        // Declarative programming
        list.forEach(System.out::println);
    */
        List<String> list = List.of("aa", "b", "c");
        //define a consumer that matches the accept method iof the Consumer Interface
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        list.forEach(print.andThen(printUpperCase));
    }
}
