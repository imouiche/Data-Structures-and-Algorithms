package com.codewithinoussa.Generics;

import java.util.*;

//T repres the type of object ww to store in this class
//public class GenericList<T extends Number> if our class consider operation that deal with numbers only
public class GenericList<T> implements Iterable<T>{
    //public T[] items = (T[]) new Object[10];
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    // nested class to impl the Iterator interface
    public class ListIterator implements Iterator<T>{
        private GenericList<T> list;
        private int index;

        //constructor
        public ListIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
