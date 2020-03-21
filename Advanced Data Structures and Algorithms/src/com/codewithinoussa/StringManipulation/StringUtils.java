package com.codewithinoussa.StringManipulation;

import javax.swing.*;
import java.util.*;

public class StringUtils {
    //make it static so we don't have to create an instance of this class
    public static int countVowels(String str){
        if (str == null)
            return 0;
        int count = 0;
        String vowels = "aeiou"; // use a set if we have avery large string
        //aeiou are vowels in English
        for (var ch : str.toLowerCase().toCharArray())
           // vowels.contains(Character.toString(ch));
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    //Reverse a string
    public static String reverse(String str){
        if (str == null)
            return "";

        //Poor approach(O(n^2)) <- Strings are immutable
        /*String reversed = "";
        for (var i = str.length(); i > 0; i--) //O(n)
            reversed += str.charAt(i); //O(n)
        return reversed;*/

        //Good Approach O(n) using String Builder
        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) //O(n)
            reversed.append(str.charAt(i)); //O(1)

        return reversed.toString();
    }

    //reverse the order of words
    public static String reverseWords(String sentence){
        if (sentence == null)
            return "";
        //we trim() to get ride of extra white space
        String[] words = sentence.trim().split(" ");

        //first approach
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

        //Second Approach
       /* StringBuilder reversed = new StringBuilder();
        for ( var i = words.length - 1; i >= 0; i--)
            reversed.append(words[i] + " ");
        return reversed.toString().trim();*/
    }

    public static boolean areRotation(String str1, String str2){
        //ABCD -> DABC rotate 1 ch to the right
        //     -> CDAB
        //     -> BCDA
        //     -> ABCD 4 ch to the right
        if (str1 == null || str2 == null)
            return false;
        return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
        /*if (str1.length() != str2.length())
            return false;
        if (!(str1 + str1).contains(str2))
            return false;
        return true;*/
    }

    public static String removeDuplicate(String str){
        if (str == null)
            return "";
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (var ch : str.toCharArray())
            if (!seen.contains(ch)){
                seen.add(ch);
                output.append(ch);
            }

        return output.toString();
    }

    public static char mostRepeatedChar(String str){
        if (str == null || str.isEmpty())
            throw new  IllegalArgumentException();

        /*Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (var ch : str.toCharArray()) {
            count = (map.containsKey(ch)) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        Character frequentChar = null;
        int max = 0;
        for (var key : map.keySet())
            if (map.get(key) > max){
                max = map.get(key);
                frequentChar = key;
            }
        return frequentChar;*/

        //Second Approach using ASCII char assuming we dont have access to HashTable
        final int ASCII_SIZE = 256;

        int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++)
            if (frequencies[i] > max){
                max = frequencies[i];
                result = (char) i;
            }

        return result;
    }

    //capitalise first word in a sentence
    public static String capitalize(String sentence){
        if (sentence.trim().isEmpty() || sentence == null)
            return "";
        //use replaceAll() to replace all extra spaces in the sentence
        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");
        for (var i = 0; i < words.length; i++){
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    //Anagram
    /*
    A string is an anagram of another string if it has the exact same characters in any order
     */
    //Using sorting -> O(nlogn)
    public static boolean areAnagrams(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        var array1 = str1.toLowerCase().toCharArray();
        var array2 = str2.toLowerCase().toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    //Using Histogramming -> O(n)
    /*
    count the number of each char in two string and ensure the counts are the same
     */
    public static boolean areAnagram2(String str1, String str2){
        if (str1 == null || str2 == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int [] frequencies = new int[ENGLISH_ALPHABET];

        str1 = str1.toLowerCase();
        for (var i = 0; i < str1.length(); i++)
            frequencies[str1.charAt(i) - 'a']++; // - 'a' to stay in the raneg of 26

        str2 = str2.toLowerCase();
        for (var i = 0; i < str2.length(); i++){
            var index = str2.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }

    /*
    Palindrome ie if we read from left or right we get the same char
    ie ABBA - MADAM
    The simple approach is to reverse the string and compare to itself
     */

    public static boolean isPalindrome(String word){
        if (word == null)
            return false;
        //first approach
      /*  var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);*/

        //faster approach
        int left = 0;
        int right = word.length() -1;

        while ( left < right)
            if (word.toLowerCase().charAt(left++) != word.toLowerCase().charAt(right--))
                return false;

        return true;
    }
}
