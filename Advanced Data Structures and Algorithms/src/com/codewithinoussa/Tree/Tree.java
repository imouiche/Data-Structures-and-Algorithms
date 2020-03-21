package com.codewithinoussa.Tree;

import java.util.*;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    private Node root;
    private int count;

    public void insert(int value){
        var node =  new Node(value);
        count++;
        if (root == null) {
           root = node;
            return;
        }
        var current = root;
        while (true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current =  current.leftChild;
            }else {
                if (current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

    }

    public boolean find(int value){
        var current = root;
        while (current != null){
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current =  current.rightChild;
            else
                return true;
        }

        return false;


    }

    //overload traversal as root is private field and cannot be called in the main class
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);


    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root){
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);

    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);

    }
    public int height(){
       return height(root);
    }

    private int height(Node root){
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    //O(log n)
    public int min(){
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    //O(n)
    private int min(Node root){
        if (isLeaf(root))
            return root.value;
        var left =  min(root.leftChild);
        var right =  min(root.leftChild);

        return Math.min(Math.min(left, right), root.value);

    }

    public boolean equals(Tree other){
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    //preOrder
    private boolean equals(Node first, Node second){
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        return false;
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }


    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //Validate a binary search tree
    private boolean isBinarySearchTree(Node root, int min, int max){
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodeAtDistance(int k){
        //store value inn a list
        var list = new ArrayList<Integer>();
        getNodeAtDistance(root, k, list);
        return list;
    }

    private void getNodeAtDistance(Node root, int k, ArrayList<Integer> list){
        if (root == null)
            throw new IllegalStateException();
        if (k==0) {
            list.add(root.value);
            //System.out.println(root.value);
            return;
        }
        getNodeAtDistance(root.leftChild, k-1, list);
        getNodeAtDistance(root.rightChild, k-1, list);
    }

    public void traverseLevelOrder(){
        for (int i=0; i<= height()-1; i++){
            for (var value : getNodeAtDistance(i))
                System.out.println(value);
        }
    }

    public int size(){
        return count;
    }
    public int countLeaves(){
        return countLeaves(root);
    }
    //number of leaves in a binary tree
    private int countLeaves(Node root){
        if (root == null)
            throw new IllegalStateException();

        if (isLeaf(root)) {
            return 1;
        }
        return  countLeaves(root.leftChild) + countLeaves(root.rightChild);

    }

    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;

        return max(root.rightChild);
    }
}
