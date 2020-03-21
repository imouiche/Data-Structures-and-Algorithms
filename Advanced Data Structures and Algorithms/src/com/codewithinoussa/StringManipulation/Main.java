package com.codewithinoussa.StringManipulation;

public class Main {
    public static void main(String[] args){
        int count = StringUtils.countVowels("HellO world");
        System.out.println(count);

       /* String reversed = StringUtils.reverse(" Hello World");
        System.out.println(reversed);*/

        /*String reversed = StringUtils.reverseWords("Trees are beautiful");
        System.out.println("'" + reversed + "'");*/

        /*var x = StringUtils.areRotation("ABCD", "DABC");
        System.out.println(x);*/

        /*var output = StringUtils.removeDuplicate("Trees are beautiful");
        System.out.println(output);*/

        /*var result = StringUtils. mostRepeatedChar("Trees are beautiful");
        System.out.println(result);*/

        /*var result = StringUtils.capitalize("today is a great day");
        System.out.println(result);*/

        /*var result = StringUtils.areAnagrams("ABCD", "BDCA");
        System.out.println(result);*/

        var result = StringUtils.isPalindrome("ABBa");
        System.out.println(result);
    }
}
