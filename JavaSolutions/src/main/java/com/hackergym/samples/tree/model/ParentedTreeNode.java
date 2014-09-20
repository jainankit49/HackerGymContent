package com.hackergym.samples.tree.model;

/**
 * Created by Fathalian on 9/19/14.
 * HackerGym.com
 */
public class ParentedTreeNode {

    public ParentedTreeNode parent;
    public ParentedTreeNode right;
    public ParentedTreeNode left;
    public String value;

    public ParentedTreeNode(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
