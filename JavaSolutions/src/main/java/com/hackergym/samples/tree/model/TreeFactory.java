package com.hackergym.samples.tree.model;


/**
 * Created by Fathalian on 9/15/14.
 * HackerGym.com
 */
public class TreeFactory {

    public IntNode generateBST(Integer[] elements) {
        return generateBSTRecursive(elements, 0, elements.length - 1);
    }

    private IntNode generateBSTRecursive(Integer[] elements, int start, int end) {
        if (start == end) {
            return new IntNode(elements[start]);
        }

        if (start > end || start < 0 || end >= elements.length) {
            return null;
        }

        int middle = (start + end + 1) / 2;
        IntNode node = new IntNode(elements[middle]);
        node.left = generateBSTRecursive(elements, start, middle - 1);
        node.right = generateBSTRecursive(elements, middle + 1, end);
        return node;
    }

}
