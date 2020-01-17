package com.codewithinoussa.Lambdas;

import java.util.function.*;

public class BinaryOperatorInterface {
    public static void showBOI(){
        //a, b -. a + b -> square(a + b)
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a*a;
        var result = add.andThen(square).apply(2,4);
        System.out.println(result);

    }
}
