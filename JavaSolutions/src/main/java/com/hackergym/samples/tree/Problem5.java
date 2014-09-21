package com.hackergym.samples.tree;

/**
 * Created by Fathalian on 9/18/14.
 * HackerGym.com
 */

import com.hackergym.samples.tree.model.IntNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have an array of nodes.
 * Each node contains a left and right pointer that point to other nodes in the array.
 * Write an algorithm that detects whether the nodes form a tree.
 * <p/>
 * FollowUp:
 * Write code detect that your tree is a binary search tree.
 *
 * see more details at :
 * http://hackergym.com/#!/problemview/8790c162-f125-44e7-88d5-d1cd94b98264?p=5
 */
public class Problem5 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public boolean isTreeCustom(List<IntNode> nodes) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testIsTreeCustom
        return isTree(nodes);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public boolean isBSTCustom(IntNode root) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testIsBSTCustom
        return isBST(root);
    }

    public boolean isTree(List<IntNode> nodes) {

        Map<IntNode, Integer> map = new HashMap<>();

        // If the HashMap does not contain X,
        // create a new entry with the key of X and set its value to 0.
        for (IntNode node : nodes) {
            if (!map.containsKey(node)) {
                map.put(node, 0);
            }

            if (node.right != null) {
                //If HashMap does not contain X.right.
                // create a new entry with the key of X.right and set its value to 1.
                if (!map.containsKey(node.right)) {
                    map.put(node.right, 1);
                }
                //If the HashMap contains X.right,
                // retrieve the entry and increase its value by one.
                // If the value is more than 1, then we have found a
                // node that can be visited from two other nodes.
                //return false
                else {
                    Integer edgeCount = map.get(node.right);
                    if (edgeCount > 0) {
                        return false;
                    } else {
                        map.put(node.right, 1);
                    }
                }
            }

            if (node.left != null) {
                if (!map.containsKey(node.left)) {
                    map.put(node.left, 1);
                } else {
                    Integer edgeCount = map.get(node.left);
                    if (edgeCount > 0) {
                        return false;
                    } else {
                        map.put(node.left, 1);
                    }
                }
            }
        }

        //At the end of this iteration, the HashMap should only
        // contain counters that have values of 1
        // except for one counter, which belongs to the root of the tree
        boolean foundRoot = false;
        for (Integer counter : map.values()) {
            //we have more than one root (tree is disconnected)
            if (counter == 0) {
                if (!foundRoot) foundRoot = true;
                else return false;
            }
            //check whether we have cycles
            else if (counter > 1) {
                return false;
            }
        }

        return foundRoot;
    }

    public boolean isBST(IntNode root) {
        IntNode lastVisited = new IntNode(Integer.MIN_VALUE);
        return isBSTRecursive(root, lastVisited);
    }

    //returns the last node visited
    public boolean isBSTRecursive(IntNode root, IntNode lastVisited) {

        if (root.left == null && root.right == null) {
            if (root.value >= lastVisited.value) {
                lastVisited.value = root.value;
                return true;
            } else {
                return false;
            }
        } else if (root.left != null) {
            boolean isBST = isBSTRecursive(root.left, lastVisited);
            if (!isBST || root.value < lastVisited.value) return false;
        }

        if (root.value >= lastVisited.value) {
            lastVisited.value = root.value;
            if (root.right != null) {
                boolean isBST = isBSTRecursive(root.right, lastVisited);
                return isBST;
            }
        }
        return false;
    }
}
