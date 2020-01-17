package com.codewithinoussa.Generics;
/*
What if we want to create a generic class that will consider all variable types ie
reference adn primitive types
 */
//obejct is the parent class of all reference types
public class BadSolutionWithObjectType {
    private Object [] list;
    private int count;
    private int size;

    public BadSolutionWithObjectType(int size){
        this.size = size;
        count = 0;
        list = new Object[this.size];
    }
    public BadSolutionWithObjectType(){
        size = 10;
        count = 0;
        list = new Object [size];
    }

    public void add(Object item){
        list[count++] = item;
    }

    public Object getItem(int index){
        return list[index];
    }

}
