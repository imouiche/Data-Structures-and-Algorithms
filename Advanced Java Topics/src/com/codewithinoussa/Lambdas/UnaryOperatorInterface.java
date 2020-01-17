package com.codewithinoussa.Lambdas;

import java.util.function.*;

public class UnaryOperatorInterface {
    public static void showUOI(){
        UnaryOperator<Integer> square = n -> n*n;
        UnaryOperator<Integer> increment = n -> n+1;

        var result = increment.andThen(square).apply(1);
        System.out.println(result);
    }
}
