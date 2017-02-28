package com.jp.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JP on 2/27/2017.
 */
public class BinarySearchTreeNode<T> extends BinaryTreeNode {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearchTreeNode.class);

    public BinarySearchTreeNode(Comparable value) {
        super(value);
    }

    @SuppressWarnings("unchecked")
    public TreeNode<T> search(BinarySearchTreeNode<T> node, Comparable<T> target) {

        if (node == null || target == null) {
            LOGGER.warn("node or target was null!");
            return null;
        }

        T currentValue = (T) node.getValue();
        LOGGER.info("Current value is : {} ", currentValue);

        // Use equals() because it's better than compareTo() == 0
        if (currentValue.equals(target)) {
            return node;
        }

        if (target.compareTo(currentValue) < 0) {
            return search((BinarySearchTreeNode)node.getLeft(), target);
        } else {
            return search((BinarySearchTreeNode)node.getRight(), target);
        }

    }

}
