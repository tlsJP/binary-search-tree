package com.jp.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test the search for @{@link BinarySearchTreeNode}
 * <p>
 * Created by JP on 2/27/2017.
 */
public class Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        // Manually create a proper BST
        // Using 'https://en.wikipedia.org/wiki/File:Binary_search_tree.svg' as model
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(8);
        BinarySearchTreeNode<Integer> three = new BinarySearchTreeNode<>(3);
        BinarySearchTreeNode<Integer> one = new BinarySearchTreeNode<>(1);
        BinarySearchTreeNode<Integer> six = new BinarySearchTreeNode<>(6);
        BinarySearchTreeNode<Integer> ten = new BinarySearchTreeNode<>(10);
        BinarySearchTreeNode<Integer> fourteen = new BinarySearchTreeNode<>(14);

        // tier 1
        root.setLeft(three);
        root.setRight(ten);

        // tier 2
        three.setLeft(one);
        three.setRight(six);
        ten.setRight(fourteen);

        // tier 3
        six.setLeft(new BinaryTreeNode(4));
        six.setRight(new BinaryTreeNode(7));
        fourteen.setLeft(new BinaryTreeNode(13));

        TreeNode result = root.search(root, Integer.valueOf(args[0]));

        LOGGER.info("result : {}", result == null ? null : result.getValue());
    }
}
