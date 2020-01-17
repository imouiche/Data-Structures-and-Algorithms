package com.codewithinoussa.Lambdas;

import java.util.function.*;

public class FunctionInterface {
    public static void showFunction(){
        /*Function<String, Integer> map = str -> str.length();
        var length = map.apply("Inoussa");
        System.out.println(length);*/

        // composing functions
        //we have "key:value"
        // first: key=value
        // Second: {key=value}

        Function<String, String> mapReplace = str -> str.replace(":", "=");
        Function<String, String> addBrace = str -> "{" + str + "}";

        //Declarative programming
        var result = mapReplace
                .andThen(addBrace)
                .apply("key:value");
        //another technique using compose method
       var result2 =  addBrace.compose(mapReplace).apply("key:value");
        System.out.println(result2);
    }
}
