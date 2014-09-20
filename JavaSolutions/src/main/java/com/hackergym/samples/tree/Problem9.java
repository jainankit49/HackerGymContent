package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.IntNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fathalian on 9/19/14.
 * HackerGym.com
 */

/*
* Imagine a binary tree in which each node contains an integer value.

* A path is a continuous set of nodes in the tree that are all connected to each other.

* Write an algorithm that prints out all the paths, which start from the root and sum up to a given value S.


 */
public class Problem9 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public List<List<IntNode>> findPathSumRootCustom(IntNode root, int targestSum) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindPathSumRootCustom
        return findPathSumRoot(root, targestSum);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public List<List<IntNode>> findPathSumAnyNodeCustom(IntNode root, int targestSum) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindPathSumAnyNodeCustom
        return findPathSumAnyNode(root, targestSum);

    }

    public List<List<IntNode>> findPathSumRoot(IntNode root,
                                               int targestSum) {

        List<List<IntNode>> finalResult = new ArrayList<>();

        if (root.value == targestSum) {

            List<IntNode> currentSum = new ArrayList<>();
            currentSum.add(root);
            finalResult.add(currentSum);
        }


        if (root.left != null) {
            List<List<IntNode>> downstreamResults = findPathSumRoot(
                    root.left,
                    targestSum - root.value);

            for (List<IntNode> partialSum : downstreamResults) {
                partialSum.add(root);
            }

            finalResult.addAll(downstreamResults);
        }

        if (root.right != null) {

            List<List<IntNode>> downstreamResults2 = findPathSumRoot(
                    root.right,
                    targestSum - root.value);

            for (List<IntNode> partialSum : downstreamResults2) {
                partialSum.add(root);
            }

            finalResult.addAll(downstreamResults2);
        }

        return finalResult;
    }

    public List<List<IntNode>> findPathSumAnyNode(IntNode root, int targestSum) {

        //we use a linked list to be able to insert at the beginning
        //you can go with arrays and navigate from the end
        List<IntNode> ancestors = new LinkedList<>();
        List<List<IntNode>> results = new ArrayList<>();
        findPathsDFS(root, targestSum, ancestors, results);
        return results;
    }

    private void findPathsDFS(IntNode root,
                              int targetSum,
                              List<IntNode> ancestors,
                              List<List<IntNode>> results) {

        if (root.value == targetSum) {
            List<IntNode> singleSum = new ArrayList<>();
            singleSum.add(root);
            results.add(singleSum);
        }

        List<IntNode> ongoingPaths = new ArrayList<>();
        ongoingPaths.add(root);
        int ongoingSum = root.value;

        for (IntNode node : ancestors) {

            ongoingPaths.add(node);
            ongoingSum += node.value;

            if (ongoingSum == targetSum) {
                List<IntNode> currentResult = new ArrayList<>();
                currentResult.addAll(ongoingPaths);
                results.add(currentResult);
            }

        }

        if (root.left != null) {
            ancestors.add(0, root);
            findPathsDFS(root.left, targetSum, ancestors, results);
            ancestors.remove(0);
        }

        if (root.right != null) {
            ancestors.add(0, root);
            findPathsDFS(root.right, targetSum, ancestors, results);
            ancestors.remove(0);
        }

    }

}
