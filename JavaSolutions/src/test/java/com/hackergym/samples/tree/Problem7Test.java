package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.GraphNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem7Test {

    Problem7 solver = new Problem7();

    @Test
    public void testCopyGraphCustom() throws Exception {

        Map<String, GraphNode<String>> origGraphNodes = new HashMap<>();
        GraphNode<String> origGraph = generateGraph(origGraphNodes);
        GraphNode<String> copiedGraph = solver.copyGraphCustom(origGraph);

        verifyCopy(copiedGraph, origGraphNodes);
    }

    @Test
    public void testCopyGraph() throws Exception {

        Map<String, GraphNode<String>> origGraphNodes = new HashMap<>();
        GraphNode<String> origGraph = generateGraph(origGraphNodes);
        GraphNode<String> copiedGraph = solver.copyGraph(origGraph);

        verifyCopy(copiedGraph, origGraphNodes);
    }

    public GraphNode<String> generateGraph(Map<String, GraphNode<String>> nodes) {
        GraphNode<String> nodeA = new GraphNode<>("A");
        GraphNode<String> nodeB = new GraphNode<>("B");
        GraphNode<String> nodeC = new GraphNode<>("C");
        GraphNode<String> nodeD = new GraphNode<>("D");
        GraphNode<String> nodeE = new GraphNode<>("E");

        nodeA.adjacents.add(nodeB);
        nodeB.adjacents.add(nodeA);
        nodeB.adjacents.add(nodeC);
        nodeC.adjacents.add(nodeD);
        nodeD.adjacents.add(nodeB);
        nodeD.adjacents.add(nodeE);
        nodeE.adjacents.add(nodeA);

        nodes.put("A", nodeA);
        nodes.put("B", nodeB);
        nodes.put("C", nodeC);
        nodes.put("D", nodeD);
        nodes.put("E", nodeE);

        return nodeA;
    }

    public void verifyCopy(GraphNode<String> copiedGraph,
                           Map<String, GraphNode<String>> originalGraphNodes) {

        assertThat(copiedGraph.value, is("A"));
        assertThat(copiedGraph, not(originalGraphNodes.get("A")));
        assertThat(copiedGraph.adjacents.size(), is(1));
        assertThat(copiedGraph.adjacents.get(0).value, is("B"));
        assertThat(copiedGraph.adjacents.get(0), not(originalGraphNodes.get("B")));

        GraphNode<String> nodeB = copiedGraph.adjacents.get(0);
        assertThat(nodeB.value, is("B"));
        assertThat(nodeB, not(originalGraphNodes.get("B")));
        assertThat(nodeB.adjacents.size(), is(2));
        assertThat(nodeB.adjacents.get(0).value, is("A"));
        assertThat(nodeB.adjacents.get(0), not(originalGraphNodes.get("A")));
        assertThat(nodeB.adjacents.get(1).value, is("C"));
        assertThat(nodeB.adjacents.get(1), not(originalGraphNodes.get("C")));

        GraphNode<String> nodeC = nodeB.adjacents.get(1);
        assertThat(nodeC.value, is("C"));
        assertThat(nodeC, not(originalGraphNodes.get("C")));
        assertThat(nodeC.adjacents.size(), is(1));
        assertThat(nodeC.adjacents.get(0).value, is("D"));
        assertThat(nodeC.adjacents.get(0), not(originalGraphNodes.get("D")));

        GraphNode<String> nodeD = nodeC.adjacents.get(0);
        assertThat(nodeD.value, is("D"));
        assertThat(nodeD, not(originalGraphNodes.get("D")));
        assertThat(nodeD.adjacents.size(), is(2));
        assertThat(nodeD.adjacents.get(0).value, is("B"));
        assertThat(nodeD.adjacents.get(0), not(originalGraphNodes.get("B")));
        assertThat(nodeD.adjacents.get(1).value, is("E"));
        assertThat(nodeD.adjacents.get(1), not(originalGraphNodes.get("E")));

        GraphNode<String> nodeE = nodeD.adjacents.get(1);
        assertThat(nodeE.value, is("E"));
        assertThat(nodeE, not(originalGraphNodes.get("E")));
        assertThat(nodeE.adjacents.size(), is(1));
        assertThat(nodeE.adjacents.get(0).value, is("A"));
        assertThat(nodeE.adjacents.get(0), not(originalGraphNodes.get("A")));
    }
}