package com.shashank;

public class BinarySearchTree {

    //Node contains left and right child and an integer data
    //default left and right of a node= null
    class Node{
        int data;
        Node left,right,parent;

        Node(int item){
            this.data=item;
            right = left = null;
            //parent is the child's parent's parent
            parent = left.parent.parent;
        }
    }

    //default value of root of tree
    Node root = null;

    //insert a node with data= item
    //if tree has no root make node with the data=item
    //else apply property of BinaryTree
    public void insert(int item){
        if(root == null)
            root.data = item;
        else if(item < root.data){
            if(root.left==null)
                return;
            root=root.left;
            insert(item);
        }
        else if(item > root.data){
            if(root.right==null)
                return;
            root=root.right;
            insert(item);
        }
    }

    //if Tree has no node return true
    public boolean isEmpty(){
        if(root == null)
            return true;
        else
            return false;
    }

    //to find a node with with item as its data
    //checking cases
        //root<right node
        //root>left node
    public Node search(int item){
        Node node = null;
        if(isEmpty())
            return node;
        while (root!=null){
            if(item > root.data){
                root = root.right;
            }
            else if(item < root.data){
                root = root.left;
            }
            else if(item == root.data){
                node = root;
                break;
            }
            else
                node = null;
        }
        return node;
    }

    //to find minimum of a subtree with root=node
    //root.left till root.left is not null
    public Node minimum(Node node){
        while(node.left!=null) {
            node = node.left;
        }
        return node;
    }

    public Node maximum(Node node){
        while (node.right!=null){
            node = node.right;
        }
        return node;
    }

    public Node minimum(){
        return minimum(root);
    }

    public Node maximum(){
        return maximum(root);
    }

    //to delete a node
    //first check if the item is present
    //make a temp node and find the node whose data==item and point temp=node
    //find minimum(node.right)
    //point node=minimum(node.right)
    //node.right=minimum(node.right)
    public void delete(int item){
        Node temp = search(item);
        if(temp == null)
            System.out.println("No such element present in the tree");
        else {
            Node node = minimum(temp.right);
            node.right = temp.right;
            node.left = temp.left;

            //node's previous parent's left child is null
            //temp's parent is now node's parent
            node.parent.left = null;
            if (temp == temp.parent.left)
                temp.parent.left = node;
            else
                temp.parent.right = node;

            temp.right = temp.left = temp.parent = null;
        }
    }
}
