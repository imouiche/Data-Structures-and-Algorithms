package com.codewithinoussa.AVLTree;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node= " + value;
        }
    }

    private AVLNode root;
    private int count;

    public void insert(int value){
        root = insert(root, value);
    }
/*
TakeOut: insert(), we first find where to insert a new node and the we recursively go back to the root
while updating the height of each node.
 */
    private AVLNode insert(AVLNode root, int value){
        count++;
        if (root == null)
            //root = new AVLNode(value) this is not going to be the root of the tree itself,
            // then we need to return a new AVLNode and set the root of the tree in the public method
            return new AVLNode(value);

        if (root.value > value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);
      return balance(root);
    }

    public int getHeight(AVLNode node){
        return (node == null)? -1 : node.height;
    }
    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
        return (node == null)? 0 : getHeight(node.leftChild) - getHeight(node.rightChild);
    }

    private boolean isLeave(AVLNode root){
        return root.leftChild == null && root.rightChild == null;
    }

    private AVLNode balance(AVLNode root){
       // var balanceFactor = balanceFactor(root);
        if (isLeftHeavy(root)){
            if (balanceFactor(root.leftChild) < 0) {
                System.out.println("Left rotate " + root.leftChild.value);
               root.leftChild = rotateLeft(root.leftChild);
            }
            System.out.println("Right rotate on " + root.value);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0) {
                System.out.println("Right rotate on " + root.rightChild.value);
               root.rightChild = rotateRight(root.rightChild);
            }
            System.out.println("Left rotate on " + root.value);
            return rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }
}
