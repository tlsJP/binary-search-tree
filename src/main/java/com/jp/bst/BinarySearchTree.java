package com.jp.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JP on 2/27/2017.
 */
public class BinarySearchTree implements BinaryTree {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearchTree.class);

    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    private TreeNode doInsert(TreeNode root, Comparable target) {

        if (root == null) {
            LOGGER.info("Creating a new node for : '{}'", target);
            return new BinaryTreeNode(target);
        }

        Comparable currentValue = root.getValue();
        LOGGER.info("Current value is : {} ", currentValue);

        if (target.compareTo(currentValue) < 0) {
            LOGGER.info("Adding left leaf...");
            root.setLeft(doInsert(root.getLeft(), target));
        } else {
            LOGGER.info("Adding right leaf...");
            root.setRight(doInsert(root.getRight(), target));
        }

        return root;
    }

    private TreeNode doSearch(TreeNode root, Comparable target) {

        if (root == null || target == null) {
            LOGGER.warn("node or target was null!");
            return null;
        }

        Comparable currentValue = root.getValue();
        LOGGER.info("Current value is : {} ", currentValue);

        // Use equals() because it's better than compareTo() == 0
        if (currentValue.equals(target)) {
            return root;
        }

        if (target.compareTo(currentValue) < 0) {
            LOGGER.info("Looking left...");
            return doSearch(root.getLeft(), target);
        } else {
            LOGGER.info("Looking right...");
            return doSearch(root.getRight(), target);
        }
    }

    @Override
    public void insert(Comparable target) {
        LOGGER.info("insert({})", target);
        root = doInsert(root, target);
    }

    @Override
    public TreeNode search(Comparable target) {
        LOGGER.info("search({})", target);
        return doSearch(root, target);
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }


}
