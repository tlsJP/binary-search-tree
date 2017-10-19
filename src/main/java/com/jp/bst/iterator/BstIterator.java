package com.jp.bst.iterator;

import com.jp.bst.BinaryTreeNode;
import com.jp.bst.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * In a binary search tree, return an iterator over the values of the node in order.
 * For example, in this binary search tree:
 * 3
 * / \
 * 1  4
 * / \
 * 0  2
 * <p>
 * 6
 * /\
 * 5  7
 * <p>
 * The returned iterator should iterator over the values in order: 0, 1, 2, 3, 4.
 */
public class BstIterator implements Iterator<TreeNode> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private TreeNode node;

    private Stack<TreeNode> stack = new Stack<>();
    private Set<TreeNode> visited = new HashSet<>();

    public BstIterator(BinaryTreeNode root) {
        this.node = root;
        stack.push(root);
        logger.info("root {}", root.getValue());
    }

    @Override
    public boolean hasNext() {

        return !stack.isEmpty() || node != null;

    }

    @Override
    public TreeNode next() {
        logger.info("next()");
        logger.info("current node {} : L{} : R{}", new Object[]{node.getValue(), node.getLeft() == null ? "none" : node.getLeft().getValue(), node.getRight() == null ? "none" : node.getRight().getValue()});
        printStack();


        TreeNode forReturn;

        // Traverse left
        TreeNode left = node.getLeft();
        while (left != null && !visited.contains(left)) {
            stack.push(left);
            logger.info("pushing left val {}", left.getValue());
            printStack();
            left = left.getLeft();
        }

        if (left == null) {
            forReturn = stack.pop();
            visited.add(forReturn);
            printStack();
            logger.info("returning {}", forReturn);

            if (!stack.empty()) {
                node = stack.pop();
                printStack();
            }

            return forReturn;
        }


        // We're at a leaf node
        if (node.getLeft() == null && node.getRight() == null) {
            forReturn = stack.pop();
            visited.add(forReturn);
            node = stack.pop();
            return forReturn;
        }


        // We'll be returning this node
        forReturn = node;
        visited.add(node);

        // return right
        if (node.getRight() != null) {
            logger.info("pushing right val {}", node.getRight().getValue());
            stack.push(node.getRight());
            node = node.getRight();
            printStack();

        } else {
//            stack.pop();
            node = stack.pop();
        }

        // return this
        logger.info("returning {}", forReturn);
        logger.info("visited : {}", visited);
        return forReturn;

    }

    void printStack() {
        logger.info("Current stack : {}", Arrays.toString(stack.toArray()));
    }
}
