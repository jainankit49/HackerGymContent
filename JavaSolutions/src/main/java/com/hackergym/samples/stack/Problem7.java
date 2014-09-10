package com.hackergym.samples.stack;

import com.hackergym.samples.model.Element;
import com.hackergym.samples.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

/**
 * Imagine that you have a family tree in which each person has at most two children.
 * Write an algorithm that prints the family tree generation by generation.
 */
public class Problem7 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    List<String> printGenerationsCustom(TreeNode root) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testPrintGenerationsCustom
        return printGenerations(root);
    }

    List<String> printGenerations(TreeNode root) {

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.remove();
            result.add(head.value.getValue());
            if (head.left != null) queue.add(head.left);
            if (head.right != null) queue.add(head.right);
        }
        return result;
    }

    List<String> printGenerationsSeparator(TreeNode root) {

        List<String> result = new ArrayList<>();
        TreeNode seperator = new TreeNode(new Element("|"));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(seperator);

        while (!queue.isEmpty()) {
            TreeNode head = queue.remove();
            //if we are working with the separator
            //pick the separator and put it at the
            //end of the queue
            if (head.value.equals(seperator.value)) {
                //if the separator is the last
                //element we have reached the terminating condition
                if (queue.size() != 0) {
                    result.add("\n");
                    queue.add(seperator);
                }
            } else {
                result.add(head.value.getValue());
                if (head.left != null) queue.add(head.left);
                if (head.right != null) queue.add(head.right);
            }
        }
        return result;
    }

    List<String> printGenerationsCounters(TreeNode root) {
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currentGenCounter = 1;
        int nextGenCounter = 0;
        while (!queue.isEmpty()) {
            TreeNode head = queue.remove();
            result.add(head.value.getValue());
            if (head.left != null) {
                queue.add(head.left);
                nextGenCounter++;
            }
            if (head.right != null){
                queue.add(head.right);
                nextGenCounter++;
            }

            currentGenCounter--;
            if (currentGenCounter == 0) {
                //to ensure we don't add a new line for the last generation
                if (queue.size() != 0) {
                    result.add("\n");
                }
                currentGenCounter = nextGenCounter;
                nextGenCounter = 0;
            }
        }
        return result;
    }
}
