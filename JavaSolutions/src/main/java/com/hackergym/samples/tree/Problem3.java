package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.GraphNode;

import java.util.*;

/**
 * Created by Fathalian on 9/17/14.
 * HackerGym.com
 */

/**
 * You are given a two dimensional matrix representing a maze.
 * Element (i, j), i-th row and j-th column of this matrix
 * has one of the values of ROAD, WALL, or TREASURE.
 * <p/>
 * <p/>
 * <p/>
 * Cell A and B are adjacent if cell B is on the immediate left, right, top, or bottom of cell A.
 * <p/>
 * A cell is considered walkable if it is not a wall.
 * <p/>
 * Write an algorithm that generates a graph where the nodes are walkable cells from this matrix.
 * There is an edge between two nodes if they are neighbors.
 * <p/>
 * Your algorithm should return the first node from top left that is not null.
 *
 *
 * see more details at :
 * http://hackergym.com/#!/problemview/8790c162-f125-44e7-88d5-d1cd94b98264?p=3
 */
public class Problem3 {

    public enum CellType {
        PATH, WALL, TREASURE;
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public GraphNode<CellType> generateGraphCustom(CellType[][] inputs) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testGenerateGraphCustom
        return generateGraph(inputs);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public GraphNode<CellType> findTreasureCustom(CellType[][] inputs) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindTreasureCustom
        return findTreasureDFS(inputs);
    }


    public GraphNode<CellType> generateGraph(CellType[][] inputs) {

        if (inputs.length == 0) return null;

        Map<Integer, GraphNode<CellType>> allNodes = new HashMap<>();
        int colSize = inputs[0].length;

        GraphNode<CellType> firstNode = null;

        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < colSize; j++) {

                if (inputs[i][j] != CellType.WALL) {

                    if (!allNodes.containsKey(location(i, j, colSize))) {
                        GraphNode<CellType> node = new GraphNode<>(inputs[i][j]);
                        allNodes.put(location(i, j, colSize), node);
                    }

                    GraphNode<CellType> mainNode = allNodes.get(location(i, j, colSize));

                    //this is to make sure we always return an answer
                    if (firstNode == null) {
                        firstNode = mainNode;
                    }

                    //We are going to add the adjacents in a clockwise manner starting from right
                    //first right, then bottom, then left, then up
                    if (j + 1 < colSize && inputs[i][j + 1] != CellType.WALL) {
                        if (!allNodes.containsKey(location(i, j + 1, colSize))) {
                            GraphNode<CellType> node = new GraphNode<>(inputs[i][j + 1]);
                            allNodes.put(location(i, j + 1, colSize), node);
                        }

                        GraphNode<CellType> adjNode = allNodes.get(location(i, j + 1, colSize));
                        mainNode.adjacents.add(adjNode);
                    }

                    if (i + 1 < inputs.length) {

                        if (!allNodes.containsKey(location(i + 1, j, colSize))) {
                            GraphNode<CellType> node = new GraphNode<>(inputs[i + 1][j]);
                            allNodes.put(location(i + 1, j, colSize), node);
                        }

                        GraphNode<CellType> adjNode = allNodes.get(location(i + 1, j, colSize));
                        mainNode.adjacents.add(adjNode);
                    }

                    if (j - 1 >= 0) {

                        if (!allNodes.containsKey(location(i, j - 1, colSize))) {
                            GraphNode<CellType> node = new GraphNode<>(inputs[i][j - 1]);
                            allNodes.put(location(i, j - 1, colSize), node);
                        }

                        GraphNode<CellType> adjNode = allNodes.get(location(i, j - 1, colSize));
                        mainNode.adjacents.add(adjNode);
                    }

                    if (i - 1 >= 0) {

                        if (!allNodes.containsKey(location(i - 1, j, colSize))) {
                            GraphNode<CellType> node = new GraphNode<>(inputs[i - 1][j]);
                            allNodes.put(location(i - 1, j, colSize), node);
                        }

                        GraphNode<CellType> adjNode = allNodes.get(location(i - 1, j, colSize));
                        mainNode.adjacents.add(adjNode);
                    }
                }
            }
        }
        return firstNode;

    }

    private Integer location(int row, int column, int columnSize) {
        return row * (columnSize) + column;
    }

    public GraphNode<CellType> findTreasureDFS(CellType[][] inputs) {

        GraphNode<CellType> startingNode = generateGraph(inputs);

        if (startingNode == null) return null;

        Set<GraphNode<CellType>> visitedNodes = new HashSet<>();
        return findTreasureDFSRecursive(startingNode, visitedNodes);
    }

    public GraphNode<CellType> findTreasureDFSRecursive(GraphNode<CellType> startNode,
                                                        Set<GraphNode<CellType>> visitedNodes) {
        //first visit the node
        visitedNodes.add(startNode);

        if (startNode.value == CellType.TREASURE) {
            return startNode;
        }

        //now look at adj nodes
        for (GraphNode<CellType> ajdc : startNode.adjacents) {
            if (!visitedNodes.contains(ajdc)) {
                GraphNode<CellType> answer = findTreasureDFSRecursive(ajdc, visitedNodes);
                if (answer != null) {
                    return answer;
                }
            }
        }
        return null;
    }

    public GraphNode<CellType> findTreasureBFS(CellType[][] inputs) {

        GraphNode<CellType> startingNode = generateGraph(inputs);

        if (startingNode == null) return null;

        Set<GraphNode<CellType>> visitedNodes = new HashSet<>();
        Queue<GraphNode<CellType>> queue = new ArrayDeque<>();

        queue.add(startingNode);

        while (!queue.isEmpty()) {
            GraphNode<CellType> node = queue.poll();
            if (!visitedNodes.contains(node)) {

                visitedNodes.add(node);
                if (node.value == CellType.TREASURE) {
                    return node;
                }

                for (GraphNode<CellType> adjc : node.adjacents) {
                    queue.add(adjc);
                }
            }
        }
        return null;
    }
}
