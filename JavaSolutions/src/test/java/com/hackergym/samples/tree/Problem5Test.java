package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.IntNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem5Test {

    Problem5 solver = new Problem5();

    @Test
    public void testIsTreeCustom() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBST(nodes);

        assertThat(solver.isTreeCustom(nodes), is(true));
    }



    @Test
    public void testIsTreeCustomHasCycle() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBSTWithCycle(nodes);

        assertThat(solver.isTreeCustom(nodes), is(false));
    }

    @Test
    public void testIsTreeCustomHasTwoRoots() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBSTWithMoreThanOneRoot(nodes);

        assertThat(solver.isTreeCustom(nodes), is(false));
    }

    @Test
    public void testIsTreeCustomHasNoRoot() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBSTWithNoRoot(nodes);

        assertThat(solver.isTreeCustom(nodes), is(false));
    }

    @Test
    public void testIsBSTCustom() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        IntNode root = getBST(nodes);

        assertThat(solver.isBSTCustom(root), is(true));
    }

    @Test
    public void testIsBSTCustomFalse() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        IntNode root = getBSTBadlyOrdered(nodes);

        assertThat(solver.isBSTCustom(root), is(false));
    }

    @Test
    public void testIsBSTCustomSingleNode() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        IntNode root = getBSTSingleNode(nodes);

        assertThat(solver.isBSTCustom(root), is(true));
    }

    @Test
    public void testIsTree() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBST(nodes);

        assertThat(solver.isTree(nodes), is(true));
    }


    @Test
    public void testIsTreeHasCycle() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBSTWithCycle(nodes);

        assertThat(solver.isTree(nodes), is(false));
    }

    @Test
    public void testIsTreeHasTwoRoots() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBSTWithMoreThanOneRoot(nodes);

        assertThat(solver.isTree(nodes), is(false));
    }

    @Test
    public void testIsTreeHasNoRoot() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        getBSTWithNoRoot(nodes);

        assertThat(solver.isTree(nodes), is(false));
    }

    @Test
    public void testIsBST() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        IntNode root = getBST(nodes);

        assertThat(solver.isBST(root), is(true));
    }

    @Test
    public void testIsBSTFalse() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        IntNode root = getBSTBadlyOrdered(nodes);

        assertThat(solver.isBST(root), is(false));
    }

    @Test
    public void testIsBSTSingleNode() throws Exception {

        List<IntNode> nodes = new ArrayList<IntNode>();

        IntNode root = getBSTSingleNode(nodes);

        assertThat(solver.isBST(root), is(true));
    }

    private IntNode getBST(List<IntNode> allNodes) {

        IntNode root = new IntNode(4); //-
        root.left = new IntNode(2);
        root.right = new IntNode(6); //-
        root.left.left = new IntNode(1); //-
        root.left.right = new IntNode(3); //-
        root.right.right = new IntNode(7); //--

        List<IntNode> nodes = Arrays.asList(
                root.left.left,
                root.right,
                root,
                root.right.right,
                root.left.right,
                root.left);

        for(IntNode node : nodes) {
            allNodes.add(node);
        }
        return root;
    }

    private IntNode getBSTWithCycle(List<IntNode> allNodes) {

        IntNode root = new IntNode(4); //-
        root.left = new IntNode(2);
        root.right = new IntNode(6); //-
        root.left.left = new IntNode(1); //-
        root.right.right = new IntNode(7); //--
        root.left.right = root.right.right;

        List<IntNode> nodes = Arrays.asList(
                root.left.left,
                root.right,
                root,
                root.right.right,
                root.left.right,
                root.left);

        for(IntNode node : nodes) {
            allNodes.add(node);
        }

        return root;
    }

    private IntNode getBSTWithMoreThanOneRoot(List<IntNode> allNodes) {

        IntNode root = new IntNode(4); //-
        root.left = new IntNode(2);
        root.right = new IntNode(6); //-
        root.left.left = new IntNode(1); //-
        root.right.right = new IntNode(7); //--
        IntNode root2 = new IntNode(12);

        List<IntNode> nodes = Arrays.asList(
                root.left.left,
                root.right,
                root,
                root.right.right,
                root2,
                root.left);

        for(IntNode node : nodes) {
            allNodes.add(node);
        }

        return root;
    }

    private IntNode getBSTWithNoRoot(List<IntNode> allNodes) {

        IntNode root = new IntNode(4); //-
        root.left = new IntNode(2);
        root.right = new IntNode(6); //-
        root.left.left = new IntNode(1); //-
        root.right.right = new IntNode(7); //--
        root.right.right.left = root;

        List<IntNode> nodes = Arrays.asList(
                root.left.left,
                root.right,
                root,
                root.right.right,
                root.left);

        for(IntNode node : nodes) {
            allNodes.add(node);
        }

        return root;
    }

    private IntNode getBSTBadlyOrdered(List<IntNode> allNodes) {

        IntNode root = new IntNode(4); //-
        root.left = new IntNode(2);
        root.right = new IntNode(6); //-
        root.left.left = new IntNode(1); //-
        root.left.right = new IntNode(3); //-
        root.right.right = new IntNode(5); //--

        List<IntNode> nodes = Arrays.asList(
                root.left.left,
                root.right,
                root,
                root.right.right,
                root.left.right,
                root.left);

        for(IntNode node : nodes) {
            allNodes.add(node);
        }

        return root;
    }

    private IntNode getBSTSingleNode(List<IntNode> allNodes) {

        IntNode root = new IntNode(4);
        allNodes.add(root);
        return root;
    }
}