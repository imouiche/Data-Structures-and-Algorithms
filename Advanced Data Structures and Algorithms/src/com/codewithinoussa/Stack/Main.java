package com.codewithinoussa.Stack;

public class Main {
    public static void main(String[] args){
     /*   var str = "abcd";
        System.out.println(str.toCharArray());
        var reverser = new StringReverser();
        var result = reverser.reverse(str);

        var str1 = "(1+2}";
        var expression = new Expression();
        var result1 = expression.isBalanced(str1);*/

     var stack =  new StackDemo(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack);


        //System.out.println(result1);

    }
}
