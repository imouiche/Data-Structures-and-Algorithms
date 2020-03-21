package com.codewithinoussa.Tries;

public class Main {
    public static void  main(String[] args){
        var trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        //trie.traverse();
       // trie.remove("car");
        var words = trie.findWords("car");
        System.out.println(words);


    }
}
