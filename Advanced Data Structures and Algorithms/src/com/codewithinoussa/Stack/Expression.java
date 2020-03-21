package com.codewithinoussa.Stack;

import java.util.*;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '<','[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>',']', '}');

    public boolean isBalanced(String input) {
        var stack = new Stack<Character>();
        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);
            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketMatch(top, ch)) return false;

            }
        }
        return stack.empty();
    }
    private boolean isLeftBracket(char ch){
        return leftBrackets.contains(ch);
    }
    private boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
    }
    private boolean bracketMatch(char left, char right){
       return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
