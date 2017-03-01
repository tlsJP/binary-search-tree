package com.jp.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test the search for @{@link BinarySearchTree}
 * <p>
 * Created by JP on 2/27/2017.
 */
public class Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        // Manually create a proper BST
        // Using 'https://en.wikipedia.org/wiki/File:Binary_search_tree.svg' as model
        BinarySearchTree bst = new BinarySearchTree(new BinaryTreeNode(8));
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        bst.insert(10);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);


        TreeNode result = bst.search(Integer.valueOf(args[0]));

        LOGGER.info("result : {}", result == null ? null : result.getValue());
    }
}
