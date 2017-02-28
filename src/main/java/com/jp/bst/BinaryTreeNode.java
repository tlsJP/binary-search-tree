package com.jp.bst;

/**
 * Created by JP on 2/27/2017.
 */
public class BinaryTreeNode implements TreeNode {

    private Comparable value;

    private TreeNode left;
    private TreeNode right;

    public BinaryTreeNode(Comparable value) {
        this.value = value;
    }

    @Override
    public TreeNode getLeft() {
        return left;
    }

    @Override
    public TreeNode getRight() {
        return right;
    }

    @Override
    public Comparable getValue() {
        return value;
    }

    @Override
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    @Override
    public void setRight(TreeNode right) {
        this.right = right;
    }

}
