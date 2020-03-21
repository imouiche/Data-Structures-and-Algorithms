package com.codewithinoussa.Stack;

import java.util.*;

public class StringReverser {

    public String reverse(String input){
        if (input == null)
            throw new IllegalArgumentException();
        Stack<Character> stack =  new Stack<>();
        for (var ch: input.toCharArray())
            stack.push(ch);
        //StringBuffer() is used in a situation where we have a lot of string manipulations
        var reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());
        //convert a StringBuffer into a string
        return reversed.toString();
    }
}
