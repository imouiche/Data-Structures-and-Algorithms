package com.codewithinoussa.Exceptions;

import java.io.*;
import java.text.*;

public class ExceptionsDemo {
    //An exception is an object that contains info about an error
    public static void show() throws IOException {
        //   sayHello(null); //NullPointerException
        /*FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
            *//*
            catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File does not exist");
        }
             *//*
        }catch (IOException | ParseException e) {
            //IOException is the parent class of FileNotFoundException
            System.out.println("Could not read data");
           // e.printStackTrace();
        }
        *//*finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
        // Here we don't need to explicitly close the file
        try (
                var reader = new FileReader("file.txt");
                var writer = new FileWriter("----")
        ) {
            var value = reader.read();
        } catch (IOException e) {
            System.out.println("Could not read data");
        }

        var account = new Account();
        try {
            account.deposit(2);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }
        try {
            account.withdraw(20);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }
    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }
}
