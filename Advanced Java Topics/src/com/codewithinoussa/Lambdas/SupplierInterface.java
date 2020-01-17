package com.codewithinoussa.Lambdas;

import java.util.function.*;

public class SupplierInterface {
    public static void showSupplier(){
        //()-> supplier does not accept any parameter

        //Supplier<Double> getRandom = () -> {return Math.random();};
        Supplier<Double> getRandom = () -> Math.random(); // this function is not executed until we call the get() method
        // this is called lazy evaluation
        var random = getRandom.get();
        System.out.println(random);

    }


}
