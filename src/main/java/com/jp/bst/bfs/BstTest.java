package com.jp.bst.bfs;

import com.jp.bst.BinaryTree;
import com.jp.bst.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static com.jp.bst.Utility.createStupidTree;
import static com.jp.bst.Utility.createTree;

/**
 * Test Breadth first search
 *
 * Created by JP on 2/28/2017.
 */
public class BstTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BstTest.class);

    public static void main(String[] args) {


        BinaryTree binaryTree = createTree();

        BreadthFirstSearch bfs = new BreadthFirstSearch();

        TreeNode result = bfs.search(binaryTree,1);

        LOGGER.info("Node found : {}", result);

        // Try again using stupid tree
        binaryTree = createStupidTree();
        Random r = new Random();
        result = bfs.search(binaryTree, r.nextInt(50));
        LOGGER.info("Node found : {}", result);

    }


}
