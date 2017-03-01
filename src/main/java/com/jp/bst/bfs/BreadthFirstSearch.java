package com.jp.bst.bfs;

import com.jp.bst.BinaryTree;
import com.jp.bst.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 * Recursive implementation for breadth-first
 * <p>
 * Created by JP on 2/28/2017.
 */
public class BreadthFirstSearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreadthFirstSearch.class);

    private Stack<TreeNode> visitedNodes = new Stack<>();
    private Queue<TreeNode> uncheckedNodes = new ArrayBlockingQueue<>(100);

    private TreeNode doSearch(TreeNode root, Comparable target) {

        // We're here now, so we've visited
        visitedNodes.add(root);

        Comparable currentValue = root.getValue();
        LOGGER.info("Current value :  {}", currentValue);
        if (currentValue.equals(target)) {
            return root;
        }

        if (root.getLeft() != null) {
            uncheckedNodes.add(root.getLeft());
        }

        if (root.getRight() != null) {
            uncheckedNodes.add(root.getRight());
        }

        LOGGER.info("Current Queue : [" + uncheckedNodes.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");

        // Time to pop off!
        TreeNode checkNext = uncheckedNodes.poll();
        return checkNext == null ? null : doSearch(checkNext, target);

    }

    public TreeNode search(BinaryTree tree, Comparable target) {
        LOGGER.info("search({})",target);
        uncheckedNodes.clear();
        visitedNodes.clear();

        TreeNode result = doSearch(tree.getRoot(), target);

        // Summary of what happaned
        LOGGER.info("Traversal breadcrumb : " + visitedNodes.stream().map(Object::toString).collect(Collectors.joining(" > ")));
        LOGGER.info("Remaining unchecked nodes : [" + uncheckedNodes.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");

        return result;
    }
}
