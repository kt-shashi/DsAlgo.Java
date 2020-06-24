package com.shashi.dsalgo.treedemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    //insert
    public void insert(int value) {

        //similar data not allowed
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);    //If leftchild not present, then create
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    //Get Node for a value
    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    //min value
    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    //max value
    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    //Inorder traversal
    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.println("Data: " + data);
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    //InOrder traversal Iteration method
    public void traverseInOrderIterative(TreeNode root){
        Stack<TreeNode> s=new Stack<>();
        TreeNode current=root;

        while (current!=null || s.size()>0){

            while(current!=null){
                s.push(current);
                current=current.leftChild;
            }
            current=s.pop();
            System.out.println(current.getData());
            current=current.rightChild;
        }
    }

    //level order traversal
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.remove();
            System.out.println(tempNode.getData());

            if (tempNode.leftChild != null) {
                queue.add(tempNode.getLeftChild());
            }

            if (tempNode.getRightChild() != null) {
                queue.add(tempNode.getRightChild());
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
