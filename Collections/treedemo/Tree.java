package com.shashi.dsalgo.treedemo;

public class Tree {

    private TreeNode root;

    //Insert a node
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    //get a node from value
    public TreeNode get(int value){
        if(root!=null){
            return root.get(value);
        }
        return null;
    }

    //delete
    public void delete(int value){
        root=delete(root,value);
    }

    //recursive function to delete a node
    private TreeNode delete(TreeNode subTreeRoot,int value){
        if(subTreeRoot==null){
            return subTreeRoot;
        }

        if(value<subTreeRoot.getData()){
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
        }
        else if(value>subTreeRoot.getData()){
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),value));
        }
        else{
            //Case 1 and 2
            if(subTreeRoot.getLeftChild()==null){
                return subTreeRoot.getRightChild();
            }
            else if(subTreeRoot.getRightChild()==null){
                return subTreeRoot.getLeftChild();
            }

            //Case 3:

            //Replace the value in the node with the min value present in the Right subTree
            subTreeRoot.setData(subTreeRoot.getRightChild().min());

            //Delete the node with the smallest value
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),subTreeRoot.getData()));

        }
        return subTreeRoot;
    }
    //min
    public int min(){
        if(root==null)
            return Integer.MIN_VALUE;
        else{
            return root.min();
        }
    }

    //max
    public int max(){
        if(root==null)
            return Integer.MAX_VALUE;
        else{
            return root.max();
        }
    }

    //InOrder Traversal
    public void traverseInOrder(){
        if(root!=null){
            root.traverseInOrder();
        }
    }

    public void traverseInOrderIterative(){
        if(root!=null){
            root.traverseInOrderIterative(root);
        }
    }

    //Level Order
    public void traverseLevelOrder(){
        if(root!=null){
            root.levelOrderTraversal(root);
        }
    }

}
