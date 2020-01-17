package com.codewithinoussa.Exceptions;

import java.io.*;

public class Main {
    public static void main(String[] args){
        try {
            ExceptionsDemo.show();
        } catch (Throwable e) {
            //Throwable is the parent class of all exceptions
            System.out.println("An unexpected error occurred. ");
        }

    }
}
