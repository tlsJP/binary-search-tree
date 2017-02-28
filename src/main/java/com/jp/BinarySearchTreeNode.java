package com.jp;

/**
 * Created by JP on 2/27/2017.
 */
public class BinarySearchTreeNode {

    private Object element;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
}
