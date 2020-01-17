package com.codewithinoussa.Lambdas;

import java.util.function.*;

//take parameter, verify the conditions and return a Boolean
public class PredicateInterface {
    public static void showPredicate(){
       /* //e.g: check is "Sky" has more than 5 characters
        Predicate<String >isLongerThan5 = str -> str.length() > 5;
        var result = isLongerThan5.test("Sky");
        System.out.println(result);*/

        //Combining predicates
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        var hasRightAndLeftBraces = hasLeftBrace.and(hasRightBrace);
        hasRightAndLeftBraces.test("{key:value}");
        hasLeftBrace.or(hasRightBrace);
        hasLeftBrace.negate(); // return th opposite of the first predicate

    }
}
