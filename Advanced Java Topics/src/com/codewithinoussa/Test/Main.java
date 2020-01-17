package com.codewithinoussa.Test;

public class Main {
    public static void main(String[] args){
        Print.show();
        Print myPrint = new Print();
        System.out.println(Print.class);
        System.out.println(myPrint.getClass().getName());
    }
}
