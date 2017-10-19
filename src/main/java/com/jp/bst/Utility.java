package com.jp.bst;

import java.util.Random;

/**
 * Created by JP on 2/28/2017.
 */
public final class Utility {

    private static final Random r = new Random();

    private Utility() {
    }

    public static BinaryTree createTree() {

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

        return bst;
    }

    public static BinaryTree createSimpleTree(){
        BinarySearchTree bst = new BinarySearchTree(new BinaryTreeNode(3));
        bst.insert(1);
        bst.insert(4);
        bst.insert(0);
        bst.insert(2);

        return bst;
    }

    public static BinaryTree createStupidTree(){


        BinarySearchTree bst = new BinarySearchTree(new BinaryTreeNode(r.nextInt(50)));
        for(int i=0;i<50;i++) {
            bst.insert(r.nextInt(50));
        }

        return bst;
    }
}
