package com.hackergym.samples.stack;

import com.hackergym.samples.tree.TreeNode;

import java.util.*;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

/**
 * A binary search tree is a set of nodes in which:
 * 1-	Each node has two pointers called left and right and a value called value.
 * 2-	left and right pointers, point to other nodes or null.
 * 3-	All the nodes on the left sub tree of a node have a smaller value than that node’s value and all the nodes on the right sub tree of a node have larger value than that node’s value.
 * <p/>
 * Write a non-recursive algorithm to print the nodes in the sorted order.
 */
public class Problem6 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public List<Integer> printCustom(TreeNode root) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testPrintWithHash
        return printWithHash(root);
    }

    public List<Integer> printWithHash(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            //If the node has a left child that is not visited yet, we push the left child to the stack.
            if (top.left != null && !visited.contains(top.left)) {
                stack.push(top.left);
            }
            //If the node doesn’t have left a left child or its left child is visited,
            // we pop the node and print it.
            // Additionally, we add the node to the hashset to mark it as visited.
            //If the node has a right child, we push the right child to the stack.
            else {
                stack.pop();
                result.add(Integer.valueOf(top.value.getValue()));
                visited.add(top);
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
        }
        return result;
    }

    public List<Integer> printWithAux(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode aux = root;
        while(!stack.isEmpty() || aux != null) {

            //First run aux to the left side of a nodes and push every node
            // that we visit to the stack.
            while(aux != null) {
                stack.push(aux);
                aux = aux.left;
            }

            //now pop the stack, print, and reposition aux to the right child
            // (which could be null)
            TreeNode top = stack.pop();
            result.add(Integer.valueOf(top.value.getValue()));
            aux = top.right;
        }
        return result;
    }
}
