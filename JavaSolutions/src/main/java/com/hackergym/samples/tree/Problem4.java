package com.hackergym.samples.tree;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

import com.hackergym.samples.model.Element;
import com.hackergym.samples.tree.model.TreeNode;

import java.util.Arrays;

/**
 * Given an array, generate the most balanced binary search tree for that array.
 */
public class Problem4 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public TreeNode generateBSTCustom(Integer[] elements){
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testGenerateBST
        return generateBST(elements);
    }

    public TreeNode generateBST(Integer[] elements)
    {
        Arrays.sort(elements);
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
