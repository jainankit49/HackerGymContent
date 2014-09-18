package com.hackergym.samples.tree;

/**
 * Created by Fathalian on 9/18/14.
 * HackerGym.com
 */

import com.hackergym.samples.tree.model.GraphNode;

import java.util.*;

/**
 * Imagine that you have a directed graph.
 * This graph is connected so you any reach any node
 * of your choosing from any other node.
 *
 * Write an algorithm to copy this graph.
 */

public class Problem7 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    /*  The method takes a single node of the original graph
        and returns a single node of the copied graph.
        These two single nodes should be exactly copies of each other
     */
    public GraphNode<String> copyGraphCustom(GraphNode<String> node) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testCopyGraphCustom
        return copyGraph(node);
    }

    /*  The method takes a single node of the original graph
        and returns a single node of the copied graph.
        These two single nodes should be exactly copies of each other
     */
    public GraphNode<String> copyGraph(GraphNode<String> node) {

        Map<String, GraphNode<String>> copiedNodes = new HashMap<>();
        Queue<GraphNode<String>> queue = new ArrayDeque<>();
        Set<GraphNode<String>> visitedNodes = new HashSet<>();

        queue.add(node);

        //this is the node we are going to return which is exactly the copy of
        //the node that was passed in
        GraphNode<String> copiedResult = null;

        while(!queue.isEmpty()) {

            GraphNode<String> workingNode = queue.poll();

            GraphNode<String> copy = copyNode(workingNode, copiedNodes);

            if(copiedResult == null) {
                copiedResult = copy;
            }

            visitedNodes.add(workingNode);

            for(GraphNode<String> adj : workingNode.adjacents) {
                if (!visitedNodes.contains(adj)) {
                    queue.add(adj);
                }
            }
        }

        return copiedResult;
    }

    private GraphNode<String> copyNode(GraphNode<String> node,
                          Map<String, GraphNode<String>> copiedNodes) {

        //copy the node if it hadn't been copied before
        if(!copiedNodes.containsKey(node.value)) {
            copiedNodes.put(node.value, new GraphNode<>(node.value));
        }

        GraphNode<String> copy = copiedNodes.get(node.value);

        //now add references to the adjacent nodes
        for(GraphNode<String> adj : node.adjacents) {

            //copy the adjacent node if it hasn't been copied before
            if (!copiedNodes.containsKey(adj.value)) {
                copiedNodes.put(adj.value, new GraphNode<>(adj.value));
            }

            GraphNode<String> adjCopy = copiedNodes.get(adj.value);
            copy.adjacents.add(adjCopy);
        }

        return copy;
    }

}
