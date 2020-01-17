package com.codewithinoussa.Generics;
/*
What if we want to create a generic class that will consider all variable types ie
reference adn primitive types
 */
public class List {
    private int [] list;
    private int count;
    private int size;

    public List(int size){
        this.size = size;
        count = 0;
        list = new int[this.size];
    }
    public List(){
        size = 10;
        count = 0;
        list = new int [size];
    }

    public void add(int item){
        list[count++] = item;
    }

    public int getItem(int index){
        return list[index];
    }

}
