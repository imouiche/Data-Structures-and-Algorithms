package com.codewithinoussa.Arrays;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args){
        int [] num = new int [3]; //declare array
        int [] num1 = {10, 20, 30};
        Array number = new Array(3);
        number.insert(10);
        number.insert(20);
        number.insert(30);
        number.insert(40);
        //number.removeAt(1);
       // number.max();
       // number.reverse();
        number.insertAt(5,2);
     //   number.print();

        /*int[] newList = new int[3];
        for (int i = 0; i < 3; i++){
            newList[i] = num1[2-i];
        }
        System.out.println(Arrays.toString(newList));*/
    }

}
