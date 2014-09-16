package com.hackergym.samples.tree;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

import com.hackergym.samples.model.Element;
import com.hackergym.samples.tree.model.TreeNode;

/**
 * Given a sorted array, generate a corresponding binary search tree for it.
 */
public class Problem5<T> {

    public TreeNode generateBST(Integer[] elements) {
        return generateBSTRecursive(elements, 0, elements.length - 1);
    }

    private TreeNode generateBSTRecursive(Integer[] elements, int start, int end) {
        if (start == end) {
            return new TreeNode(new Element(String.valueOf(start)));
        }

        if (start > end || start < 0 || end >= elements.length) {
            return null;
        }

        int middle = (start + end + 1) / 2;
        TreeNode node = new TreeNode(new Element(String.valueOf(elements[middle])));
        node.left = generateBSTRecursive(elements, start, middle - 1);
        node.right = generateBSTRecursive(elements, middle + 1, end);
        return node;
    }


}
