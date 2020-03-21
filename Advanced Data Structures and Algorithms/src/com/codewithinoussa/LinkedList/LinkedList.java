package com.codewithinoussa.LinkedList;

import java.util.*;

public class LinkedList {

    private class Node {
        private  int value;
        private Node next;

        //constructor and make sure it has a value
        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;


    //addFirst
    public void addLast(int item){
        var node = new Node(item); // create a node with value
        // check if the node is empty
        if (isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    //addfirst
    public void addFirst(int item){
        var node = new Node(item); //wrap the item inside the node obj        // is the list empty?
        if (isEmpty())
            first=last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    //indexOf
    public int indexOf(int item){
        if (isEmpty())
            return -1;
        //var node = first;
        int index = 0;
        while (first != null){
            if(first.value==item)
                return index;
            first = first.next;
            index++;
        }
        return -1;
    }

    //contain method
    public boolean contain(int item){
        if (isEmpty()) return false;
        while (first !=null){
            if (first.value == item)return true;
            first = first.next;
        }
        return false;
    }
    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    //remove last
    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        if (onlyOneElement()) {
            first = last = null;
            size--;
            return;
        }
        var previous = getPreviousNode(last);
        last = previous;
        last.next = null; //to remove the link for the garbage collection
        size--;
    }

    //Implementing size()
    public int size(){
       return size;
    }

    public Node getPreviousNode(Node node){
        var current = first;
        while(current!= null){
            if (current.next == last)
                return current;
            current = current.next;
        }
        return null;
    }
    //delete first
    public void removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();

        if (onlyOneElement())
            first = last = null;
        else {
            //[10 -> 20 -> 30]
            var second = first.next; // first make a copy
            first.next = null; //remove the link btw 10 and 20;
            first = second;
        }
        size--;
    }

    //suppose we have a method that expect a regular java array
    public int[] toArray(){
        int [] array = new int[size];
        var current = first;
        int index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    //reversing a linkedlist
    public void reverse(){
        if (isEmpty()) return;
        //[10 -> 20 -> 30] -> [10 <- 20 <- 30]
        // p      c    n
        // n = c.next
        //c.next = p => [10 <- 20]
        var previous = first; //p
        var current = first.next; //c
        while (current != null){
            var next = current.next; //n
            current.next = previous;
            previous =  current;
            current = next;
        }

        last = first;
        last.next =null;
        first = previous;
    }

    // find the Kth node from the end
    public int getKthNodeFromTheEnd(int k){
        if (isEmpty())
            throw new IllegalStateException();
        //[10 -> 20 -> 30 -> 40 -> 50]
        //              *           *
        // K = 1 (50)
        // k = 2 (40)
        // k = 3 (30) (distance =2)
        var a = first;
        var b = first;
        //move b to the right distance from a ie k-1
        for (int i=0; i<k-1; i++) {
            b = b.next;
            if (b ==null)
                throw new IllegalArgumentException();
        }
        // now we move two pointers until b reaches the last node
        while (b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    //Find the middle of the linkedList in one pass
    public void printMiddle(){
        if (isEmpty())
            throw new IllegalStateException();
        var a = first;
        var b = first;
        while (b != last && b.next != last){
            b = b.next.next;
            a = a.next;
        }
        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

    //create a linkedlist with a loop
    public static LinkedList createWithLoop(){
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    //Check to see if a linked list has a loop
    //This algorithm is called Floyd’s Cycle-finding Algorithm.
    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public boolean onlyOneElement(){
        return first==last;
    }
    private boolean isEmpty(){
        return first == null;
    }
}
