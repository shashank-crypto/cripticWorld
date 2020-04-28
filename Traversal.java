package com.shashank;

public class Traversal {
    public void inOrder(BinarySearchTree.Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root+" ");
        inOrder(root.right);
    }
    public void postOrder(BinarySearchTree.Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root+" ");
    }
    public void preOrder(BinarySearchTree.Node root){
        if(root==null)
            return;
        System.out.print(root+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void Traversal(BinarySearchTree binarySearchTree){
        System.out.println("In Order Traversal");
        inOrder(binarySearchTree.root);
        System.out.println("Post Order Traversal");
        postOrder(binarySearchTree.root);
        System.out.println("Pre Order Traversal");
        preOrder(binarySearchTree.root);
    }

    public void ifEqual(BinarySearchTree.Node node1,BinarySearchTree.Node node2){
        if(node1==null && node2==null)
            return;
        ifEqual(node1.left,node2.left);
        ifEqual(node2.right,node2.right);
        if(node1.data==node2.data)
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
    }
    public void isEqual(BinarySearchTree binarySearchTree1,BinarySearchTree binarySearchTree2){
        ifEqual(binarySearchTree1.root,binarySearchTree2.root);
    }

}
