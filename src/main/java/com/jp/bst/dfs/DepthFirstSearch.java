package com.jp.bst.dfs;

import com.jp.bst.BinaryTree;
import com.jp.bst.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Recursive DFS
 *
 * Created by JP on 3/1/2017.
 */
public class DepthFirstSearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepthFirstSearch.class);

    private Stack<TreeNode> uncheckedNodes = new Stack<>();
    private Collection<TreeNode> visitedNodes = new ArrayList<>();

    private TreeNode doSearch(TreeNode root, Comparable target) {

        visitedNodes.add(root);

        Comparable currentValue = root.getValue();
        LOGGER.info("Current value :  {}", currentValue);
        if (currentValue.equals(target)) {
            return root;
        }

        // Drop the kids off at the pool
        if (root.getLeft() != null) {
            uncheckedNodes.add(root.getLeft());
        }
        if (root.getRight() != null) {
            uncheckedNodes.add(root.getRight());
        }

        LOGGER.info("Current stack : Bottom [" + uncheckedNodes.stream().map(Object::toString).collect(Collectors.joining(",")) + ") Top");

        TreeNode nextNode = null;
        try {
            nextNode = uncheckedNodes.pop();
        } catch (EmptyStackException e) {
            LOGGER.info("The stack has been emptied!");
        }

        return nextNode == null ? null : doSearch(nextNode, target);
    }

    public TreeNode search(BinaryTree tree, Comparable target) {
        LOGGER.info("search({})", target);

        // Hmm yeah don't forget to clear these...
        uncheckedNodes.clear();
        visitedNodes.clear();

        TreeNode result = doSearch(tree.getRoot(), target);

        LOGGER.info("Traversal breadcrumb : " + visitedNodes.stream().map(Object::toString).collect(Collectors.joining(" > ")));
        LOGGER.info("Remaining unchecked nodes : Bottom [" + uncheckedNodes.stream().map(Object::toString).collect(Collectors.joining(",")) + ") Top");

        return result;
    }
}
