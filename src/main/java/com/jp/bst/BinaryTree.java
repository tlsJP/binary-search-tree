package com.jp.bst;

/**
 * Created by JP on 2/28/2017.
 */
public interface BinaryTree {

    void insert(Comparable target);

    TreeNode search(Comparable target);

    TreeNode getRoot();
}
