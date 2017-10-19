package com.jp.bst.iterator;

import com.jp.bst.BinaryTree;
import com.jp.bst.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.jp.bst.Utility.createSimpleTree;
import static com.jp.bst.Utility.createStupidTree;
import static com.jp.bst.Utility.createTree;

public class IteratorTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = createTree();

        // Test 1
        BstIterator iterator = new BstIterator((BinaryTreeNode) binaryTree.getRoot());
        Collection<Comparable> values = new ArrayList<>();
        while (iterator.hasNext()) {
            values.add(iterator.next().getValue());
        }

        System.out.println(stringifyCollection(values));


        // Test 2
        values.clear();
        binaryTree = createSimpleTree();
        iterator = new BstIterator((BinaryTreeNode) binaryTree.getRoot());
        while (iterator.hasNext()) {
            values.add(iterator.next().getValue());
        }

        System.out.println(stringifyCollection(values));


        // Test 3
        values.clear();
        binaryTree = createStupidTree();
        iterator = new BstIterator((BinaryTreeNode) binaryTree.getRoot());
        while (iterator.hasNext()) {
            values.add(iterator.next().getValue());
        }

        System.out.println(stringifyCollection(values));

    }

    private static String stringifyCollection(Collection<Comparable> c) {
        return c.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

}
