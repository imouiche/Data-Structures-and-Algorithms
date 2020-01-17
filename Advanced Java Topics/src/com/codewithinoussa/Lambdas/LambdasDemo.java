package com.codewithinoussa.Lambdas;

public class LambdasDemo {
    public static String prefix = "ho";
    public static void show() {
        //String prefix = "-";
        // 1
       // greet(new ConsolePrinter()); // shld pass an object that impl the printer interface

        //2- Anonymous Inner class for the same.
       /* greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });*/
       // 3- Lambda expression
        //System.out.println(prefix);
        //greet(message -> System.out.println(prefix + message));

        // 4 - Method references
        /*
        syntax: Class/Object::method
         */
        greet(System.out::println);
    }

    //programming against the interface "Printer"
    public static void greet(Printer printer){
        System.out.println("Hello World ref mthd");
    }
}
