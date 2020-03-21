package com.codewithinoussa.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.countLeaves());

        System.out.println(tree.size());
       /* var list = tree.getNodeAtDistance(2);
        for (var item : list)
            System.out.println(item);*/
        //System.out.println(tree.isBinarySearchTree());

        //System.out.println(factorial(1));
       // tree.traverseInOrder();
    }

    public static int factorial(int n){
        //base condition
        return (n == 0)? 1 : n*factorial(n-1);
    }
}
