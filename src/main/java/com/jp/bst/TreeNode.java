package com.jp.bst;

/**
 * Created by JP on 2/27/2017.
 */
public interface TreeNode<T> {

    Comparable<T> getValue();

    TreeNode<T> getLeft();

    TreeNode<T> getRight();

    void setLeft(TreeNode<T> t);

    void setRight(TreeNode<T> t);

}
