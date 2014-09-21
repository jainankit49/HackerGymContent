package com.hackergym.samples.tree;

/**
 * Created by Fathalian on 9/19/14.
 * HackerGym.com
 */

import com.hackergym.samples.tree.model.ParentedTreeNode;
import com.hackergym.samples.tree.model.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * You have a binary tree in which each node has a link to its parent.
 * Write an algorithm that finds the first common ancestor of two nodes in a binary tree.
 * <p/>
 * How would you solve this problem when there are no links to parents ?
 *
 * see more details at :
 * http://hackergym.com/#!/problemview/8790c162-f125-44e7-88d5-d1cd94b98264?p=8
 */
public class Problem8 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public ParentedTreeNode getCommonAncestorCustom(ParentedTreeNode node1,
                                                    ParentedTreeNode node2) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testGetCommonAncestorHash
        return getCommonAncestorHash(node1, node2);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public TreeNode getCommonAncestorNoParentCustom(TreeNode root,
                                                    TreeNode node1,
                                                    TreeNode node2) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testGetCommonAncestorNoParentCustom
        return getCommonAncestorNoParent(root, node1, node2);
    }

    public ParentedTreeNode getCommonAncestorHash(ParentedTreeNode node1,
                                                  ParentedTreeNode node2) {

        Set<ParentedTreeNode> set = new HashSet<>();
        while(node1.parent != null && node2.parent != null) {

            set.add(node1);

            set.add(node2);

            node1 = node1.parent;
            node2 = node2.parent;

            if (set.contains(node1.parent)) return node1.parent;
            if (set.contains(node2.parent)) return node2.parent;

        }

        while(node1.parent == null && node2.parent != null)  {

            if (set.contains(node2)) {
                return node2;
            }

            set.add(node2);

            node2 = node2.parent;
        }

        while(node2.parent == null && node1.parent != null)  {

            if (set.contains(node1)) {
                return node1;
            }

            set.add(node1);

            node1 = node1.parent;
        }

        //Pitfall: both nodes could have stopped at the same height
        //You could have changed the first while loop to handle this
        //case but we want to explicitly point to this pitfall here
        if (node1 == node2) return node1;

        return null;
    }

    public ParentedTreeNode getCommonAncestorPointer(ParentedTreeNode node1,
                                                     ParentedTreeNode node2) {

        int node1Height = calculateNodeHeight(node1);
        int node2Height = calculateNodeHeight(node2);

        if(node1Height > node2Height) {
            while(node1Height > node2Height) {
                node1 = node1.parent;
                node1Height--;
            }
        } else if (node2Height > node1Height) {

            while(node2Height > node1Height) {
                node2 = node2.parent;
                node2Height--;
            }
        }

        while(node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return null;
    }

    private int calculateNodeHeight(ParentedTreeNode node1) {

        int height = 0;
        while(node1.parent != null) {
            height++;
            node1 = node1.parent;
        }
        return height;
    }

    public TreeNode getCommonAncestorNoParent(TreeNode root,
                                              TreeNode node1,
                                              TreeNode node2) {

        //first we need to fill up the stack
        Stack<TreeNode> node1Parents = new Stack<>();
        Stack<TreeNode> node2Parents = new Stack<>() ;

        //fill out node1Parents and node2Parents
        findNodes(root, node1, node2, node1Parents, node2Parents);

        while (node1Parents.size() > node2Parents.size()) {
            node1Parents.pop();
        }
        while(node2Parents.size() > node1Parents.size()) {
            node2Parents.pop();
        }

        //now both the stacks are in the same height
        while(!node1Parents.isEmpty()) {
            TreeNode currentNode1 = node1Parents.pop();
            TreeNode currentNode2 = node2Parents.pop();
            if(currentNode1 == currentNode2) return currentNode1;
        }

        return null;
    }

    private void findNodes(TreeNode root,
                           TreeNode node1,
                           TreeNode node2,
                           Stack<TreeNode> node1Parents,
                           Stack<TreeNode> node2Parents) {


        Stack<TreeNode> DFSStack = new Stack<>();
        Set<TreeNode> visistedNodes = new HashSet<>();

        //this is to ensure that our DFS does not continue when we find
        //the nodes
        int nodesFound = 0;

        DFSStack.push(root);
        while(!DFSStack.isEmpty()) {

            TreeNode currentNode = DFSStack.peek();

            if (currentNode == node1) {
                node1Parents.addAll(DFSStack);
                nodesFound++;
                if (nodesFound == 2) return;
            }

            if (currentNode == node2) {
                node2Parents.addAll(DFSStack);
                nodesFound++;
                if(nodesFound == 2) return;
            }

            if (currentNode.right != null && !visistedNodes.contains(currentNode.right)) {
                DFSStack.push(currentNode.right);
            }
            else if(currentNode.left != null && !visistedNodes.contains(currentNode.left)) {
                DFSStack.push(currentNode.left);
            } else {
                visistedNodes.add(currentNode);
                DFSStack.pop();
            }
        }
    }
}
