package com.codewithinoussa.LinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args){
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
       // list.addLast(50);
       // list.addFirst(5);
        /*list.removeLast();
        list.removeFirst()*/;
      /*  list.reverse();
        var array = list.toArray();
*/
        list.printMiddle();
       // System.out.println();
       var list1 =  LinkedList.createWithLoop();
        System.out.println(list1.hasLoop());
    }
}
