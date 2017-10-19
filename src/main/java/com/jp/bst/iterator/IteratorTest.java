package com.jp.bst.iterator;

import com.jp.bst.BinaryTree;
import com.jp.bst.BinaryTreeNode;

import java.util.EmptyStackException;

import static com.jp.bst.Utility.createTree;

public class IteratorTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = createTree();

        BstIterator iterator = new BstIterator((BinaryTreeNode) binaryTree.getRoot());

        StringBuilder sb = new StringBuilder();
        try {
            while (iterator.hasNext()) {
                sb.append(iterator.next().getValue() + ", ");
            }
        } catch(EmptyStackException e){
            System.out.println(e.getMessage());
        }

        System.out.println(sb.toString());
    }

}
