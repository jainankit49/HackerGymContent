package com.hackergym.samples.tree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fathalian on 9/15/14.
 * HackerGym.com
 */
//TODO should move these nodes into a generic TreeNode Class
public class IntNode {

    public Integer value;
    public IntNode left;
    public IntNode right;

    public IntNode(Integer value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public List<Integer> printPostOrder() {
        List<Integer> result = new ArrayList<>();
        printPostOrderRecursive(this, result);
        return result;
    }

    private void printPostOrderRecursive(IntNode root,
                                        List<Integer> result) {

        if(root == null) return ;

        printPostOrderRecursive(root.left, result);
        result.add(root.value);
        printPostOrderRecursive(root.right, result);
    }

}
