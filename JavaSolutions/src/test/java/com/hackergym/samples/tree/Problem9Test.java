package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.IntNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem9Test {

    Problem9 solver = new Problem9();

    @Test
    public void testFindPathSumRootCustom() throws Exception {

        IntNode root = getTree();
        List<List<IntNode>> result = solver.findPathSumRootCustom(root, 12);

        assertThat(result.size(), is(3));

        for(List<IntNode> summable : result) {

            int sum = 12;
            for(IntNode node : summable) {
                sum -= node.value;
            }
            assertThat(sum, is(0));
        }
    }

    @Test
    public void testFindPathSumAnyNodeCustom() throws Exception {

        IntNode root = getTree();
        List<List<IntNode>> result = solver.findPathSumAnyNodeCustom(root, 12);

        assertThat(result.size(), is(7));

        for(List<IntNode> summable : result) {

            int sum = 12;
            for(IntNode node : summable) {
                sum -= node.value;
            }
            assertThat(sum, is(0));
        }
    }

    @Test
    public void testFindPathSumRoot() throws Exception {

        IntNode root = getTree();
        List<List<IntNode>> result = solver.findPathSumRoot(root, 12);

        assertThat(result.size(), is(3));

        for(List<IntNode> summable : result) {

            int sum = 12;
            for(IntNode node : summable) {
                sum -= node.value;
            }
            assertThat(sum, is(0));
        }
    }

    @Test
    public void testFindPathSumAnyNode() throws Exception {

        IntNode root = getTree();
        List<List<IntNode>> result = solver.findPathSumAnyNode(root, 12);

//        (7, 5),
//        (5, 2, 4, 1),
//        (7, 3, 2),
//        (10, 2)
//        (12)
//        (12, 5, -5)
//        (7, 3, 10, -8)


        assertThat(result.size(), is(7));

        for(List<IntNode> summable : result) {

            int sum = 12;
            for(IntNode node : summable) {
                sum -= node.value;
            }
            assertThat(sum, is(0));
        }
    }

    public IntNode getTree() {
        IntNode node7 = new IntNode(7);
        IntNode node5 = new IntNode(5);
        IntNode node3 = new IntNode(3);
        IntNode node2 = new IntNode(2);
        IntNode node2B = new IntNode(2);
        IntNode node10 = new IntNode(10);
        IntNode node4 = new IntNode(4);
        IntNode node2C = new IntNode(2);
        IntNode nodeMinus8 = new IntNode(-8);
        IntNode node1 = new IntNode(1);
        IntNode node12 = new IntNode(12);
        IntNode node5B = new IntNode(5);
        IntNode nodeMinus5 = new IntNode(-5);

        node7.left = node5;
        node7.right = node3;

        node5.left  = node2;

        node3.left  = node2B;
        node3.right = node10;

        node2.right = node4;

        node10.left = node2C;
        node10.right = nodeMinus8;

        node4.left = node1;
        node4.right = node12;

        node12.left = node5B;
        node5B.right = nodeMinus5;

        return node7;
    }
}