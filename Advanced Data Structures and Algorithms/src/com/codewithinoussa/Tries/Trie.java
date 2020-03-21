package com.codewithinoussa.Tries;

import java.util.*;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private boolean isEndOfWord;
        //private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>(); //using hashMap is more efficient in space

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        //Abstraction
        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public Node[] getChildren(){
            //without new Node[0], toArray would have returned an array of object
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
             children.remove(ch);
        }
        //endOf Abstraction

    }

    private Node root = new Node(' ');

    public void insert(String word){
        var current = root;
        for (var ch : word.toCharArray()) {
           // var index = ch - 'a';
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if (word == null)
            throw new IllegalArgumentException(); // or return false
        var current = root;
        for (var ch : word.toCharArray()){
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;

    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        for (var child : root.getChildren())
            traverse(child); //recursion
        //Post-order; // visit the child first
        System.out.println(root.value); // move it up and get the Pre-order traversal

    }

    public void remove(String word){
        if (word == null)
            return;
       remove(root, word, 0);
    }

    private void remove(Node root, String word, int index){
        //base condition
        if (index == word.length()){
            //System.out.println(root.value);
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return;
        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord )
            root.removeChild(ch);
        System.out.println(root.value);
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words){
        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix){
        if (prefix == null)
            return null;
        var current = root;
        for (var ch : prefix.toCharArray()){
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

}
