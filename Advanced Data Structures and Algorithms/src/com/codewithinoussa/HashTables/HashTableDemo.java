package com.codewithinoussa.HashTables;

import java.util.*;

public class HashTableDemo {
    private class KeyValue{
        private int key;
        private String value;

        public KeyValue(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
     private LinkedList<KeyValue>[] hashtable = new LinkedList[5];

    public void put(int key, String value){
        var index = hash(key);
        if (hashtable[index] == null) {
            hashtable[index] = new LinkedList<>();
            return;
        }
        var bucket = hashtable[index];
        for (var entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.addLast(new KeyValue(key, value));
    }

    public String get(int key){
        var index = hash(key);
        var bucket = hashtable[index];
        if (bucket != null){
            for (var entry : bucket){
                if (entry.key == key)
                    return entry.value;
            }
        }

        return null;
    }

    public void remove(int key){
        var index = hash(key);
        var bucket = hashtable[index];
        if (bucket == null)
            throw new IllegalStateException();

        for (var entry : bucket){
            if (entry.key == key) {
                bucket.remove(entry);
                return; //return immediately
            }
        }
        throw new IllegalStateException();

    }

    private int hash(int key){
        return key % hashtable.length;
    }
}
