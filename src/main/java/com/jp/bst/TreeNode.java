package com.jp.bst;

/**
 * Created by JP on 2/27/2017.
 */
public interface TreeNode<T> {

    TreeNode getLeft();

    TreeNode getRight();

    Comparable<T> getValue();

    void setLeft(TreeNode t);

    void setRight(TreeNode t);


}
