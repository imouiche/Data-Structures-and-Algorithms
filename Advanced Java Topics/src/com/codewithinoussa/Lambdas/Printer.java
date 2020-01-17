package com.codewithinoussa.Lambdas;
//functional interface - interface with a single abstract method
// Also an example of consumer interface
public interface Printer {
    void print(String message); // abstract method

    //bad approach===================================
    /*default void printTwice(String message){
        System.out.println(message);
        System.out.println(message);
    }*/
    //=======================================================
}
