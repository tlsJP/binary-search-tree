package com.jp.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jp.bst.Utility.createTree;

/**
 * Test the search for @{@link BinarySearchTree}
 * <p>
 * Created by JP on 2/27/2017.
 */
public class Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {


        BinaryTree bst = createTree();

        TreeNode result = bst.search(Integer.valueOf(args[0]));

        LOGGER.info("result : {}", result);
    }
    

}
