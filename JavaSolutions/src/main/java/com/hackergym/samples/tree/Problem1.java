package com.hackergym.samples.tree;

/**
 * Created by Fathalian on 9/15/14.
 * HackerGym.com
 */

import com.hackergym.samples.tree.model.IntNode;

/**
 * In this problem we are going to implement search, insert,
 * and delete in a binary search tree.
 *
 * See more details at :
 * http://hackergym.com/#!/problemView/8790c162-f125-44e7-88d5-d1cd94b98264?p=1
 */

public class Problem1 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    /* Should return null if the search is unsuccessful */
    public IntNode searchCustom(IntNode root, int value) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testSearchCustom
        return search(root, value);

    }

    public void insertCustom(IntNode root, int value) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testInsertCustom
        insert(root, value);
    }

    /*
    Should return the root of the tree
     */
    public IntNode deleteCustom(IntNode root, int value) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testDeleteCustom
        return delete(root, value);
    }

    /* Should return null if the search is unsuccessful */
    public IntNode search(IntNode root, int value) {

        if (root == null) return null;

        if (root.value == value) return root;

        //search left
        IntNode result = search(root.left, value);
        if (result != null) return result;

        //search right
        return search(root.right, value);
    }

    public void insert(IntNode root, int value) {
        insertRecursive(root, null, value);
    }

    private void insertRecursive(IntNode node, IntNode parent, int value) {

        //if we have reached the final position
        if (node == null) {

            if (parent == null) throw new IllegalStateException();

            //check whether to put the new node on the parents
            //left or on the parents right
            if (parent.value > value) {
                parent.left = new IntNode(value);
            } else {
                parent.right = new IntNode(value);
            }

            return;
        }

        //if we are dealing with duplicates
        else if (node.value == value) {
            IntNode left = node.left;
            node.left = new IntNode(value);
            node.left.left = left;
        } else if (node.value > value) {
            insertRecursive(node.left, node, value);
        } else {
            insertRecursive(node.right, node, value);
        }
    }

    /*
    Returns the root of the tree or null if tree is empty.
    This is important in case we delete the root of the tree which causes the tree
    to have another root
     */
    public IntNode delete(IntNode root, int value) {

        //first we need to search for the node

        //if we reach here the element we were searching for was not
        //in the tree
        if (root == null) return null;

        //this case can only happen if we are deleting the root
        if (root.value == value) {
            return deleteNode(root, null);
        }

        //because we need the parent to delete the node properly
        //we need to look at the value of left and right here
        else if (root.left != null && root.left.value == value) {
            deleteNode(root.left, root);
            return root;
        } else if (root.right != null && root.right.value == value) {
            deleteNode(root.right, root);
            return root;
        } else if (root.value > value) {
            delete(root.left, value);
            return root;
        } else {
            delete(root.right, value);
            return root;
        }

    }

    private IntNode deleteNode(IntNode node, IntNode parent) {

        //	If the node does not have any children, just delete the node.
        if (node.left == null && node.right == null) {

            //if we are deleting the root and there are no children left
            //return null to indicate an empty tree
            if (parent == null) return null;

            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            return parent;
        }
        //	If the node has only one child, replace the node with that child.
        else if (node.left == null) {

            //if we are deleting the root
            if (parent == null) {
                return node.right;
            }

            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }

            return parent;

        } else if (node.right == null) {

            //if we are deleting the root
            if (parent == null) return node.left;

            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            return parent;
        }
        //	If the node has both left and right children,
        // we need to replace it with the smallest child that is in its right sub tree.
        else {

            // for simplicity we break this case into two
            // if the leftmost node in the node's subtree is the nodes.right
            // just replace node with that
            if (node.right.left == null) {

                //if we are removing the root. Move the right node up and assign
                //roots left child to it
                if (parent == null) {
                    node.right.left = node.left;
                    //node.right is the new root
                    return node.right;
                }

                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }

                return parent;
            }

            // The smallest child will be the leftmost node on the right subtree.
            // Let’s call this node leftMost.
            // To replace node with leftMost,
            // we first need to replace leftMost with its own right child if it has one and
            // then replace X with leftMost.
            else {

                IntNode leftMost = node.right;
                IntNode leftMostParent = node;
                while (leftMost.left != null) {
                    leftMostParent = leftMost;
                    leftMost = leftMost.left;
                }

                //now replace the leftmost node with its right child
                if (leftMost.right != null) {
                    leftMostParent.left = leftMost.right;
                } else {
                    leftMostParent.left = null;
                }

                //then replace node with the leftMost

                //if we are deleting the root
                //just replace the root with the leftmost child
                if (parent == null) {
                    leftMost.left = node.left;
                    leftMost.right = node.right;
                    return leftMost;
                }

                if (parent.left == node) {
                    parent.left = leftMost;
                } else {
                    parent.right = leftMost;
                }

                return parent;
            }
        }
    }
}


