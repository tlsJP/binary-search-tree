package com.jp.bst.com.jp.bst.search;

import com.jp.bst.Tree;
import com.jp.bst.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 * Created by JP on 2/28/2017.
 */
public class BreadthFirstSearch implements Tree {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreadthFirstSearch.class);

    private Tree tree;

    private Set<TreeNode> visitedNodes;
    private Queue<TreeNode> uncheckedNodes;

    public BreadthFirstSearch(Tree tree) {
        this.tree = tree;
        // TODO - Tree that can report number of nodes so i can do something like tree.size() or w/e
        uncheckedNodes = new ArrayBlockingQueue(10);
        visitedNodes = new HashSet<>(10);
    }

    private TreeNode doSearch(TreeNode root, Comparable target) {

//        uncheckedNodes.add(root);
        uncheckedNodes.add(root.getLeft());
        uncheckedNodes.add(root.getRight());

        LOGGER.info("Current Queue : [" + uncheckedNodes.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");

        Comparable currentValue = root.getValue();
        LOGGER.info("Current value :  {}", currentValue);
        if (currentValue.equals(target)) {
            return root;
        }

        return doSearch(uncheckedNodes.poll(), target);

    }

    @Override
    public TreeNode getRoot() {
        return null;
    }

    @Override
    public void insert(Comparable target) {
        throw new UnsupportedOperationException("lol rip xd");
    }

    @Override
    public TreeNode search(Comparable target) {
        uncheckedNodes.clear();

        return doSearch(tree.getRoot(), target);

    }
}
