package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.ParentedTreeNode;
import com.hackergym.samples.tree.model.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem8Test {

    Problem8 solver = new Problem8();

    @Test
    public void testGetCommonAncestorCustomSameHeight() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorCustom(nodes.get("9"), nodes.get("4"));

        assertThat(result.value, is("7"));
    }

    @Test
    public void testGetCommonAncestorCustomNode1Lower() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorCustom(nodes.get("9"),
                nodes.get("8"));

        assertThat(result.value, is("3"));
    }

    @Test
    public void testGetCommonAncestorCustomNode2Lower() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorCustom(nodes.get("8"),
                nodes.get("9"));

        assertThat(result.value, is("3"));
    }

    @Test
    public void testGetCommonAncestorCustomOneParentOfTheOther() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorCustom(
                nodes.get("5"),
                nodes.get("1"));

        assertThat(result.value, is("5"));
    }

    @Test
    public void testGetCommonAncestorCustomNoParentSameHeight() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParentCustom(root, nodes.get("9"), nodes.get("4"));

        assertThat(result.value.getValue(), is("7"));
    }

    @Test
    public void testGetCommonAncestorCustomNoParentNode1Lower() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParentCustom(
                root,
                nodes.get("9"),
                nodes.get("8"));

        assertThat(result.value.getValue(), is("3"));
    }

    @Test
    public void testGetCommonAncestorCustomNoParentNode2Lower() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParentCustom(
                root,
                nodes.get("8"),
                nodes.get("9"));

        assertThat(result.value.getValue(), is("3"));
    }

    @Test
    public void testGetCommonAncestorCustomNoParentOneParentOfTheOther() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParentCustom(
                root,
                nodes.get("5"),
                nodes.get("1"));

        assertThat(result.value.getValue(), is("5"));
    }

    @Test
    public void testGetCommonAncestorHashSameHeight() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorHash(nodes.get("9"), nodes.get("4"));

        assertThat(result.value, is("7"));
    }

    @Test
    public void testGetCommonAncestorHashNode1Lower() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorHash(nodes.get("9"),
                nodes.get("8"));

        assertThat(result.value, is("3"));
    }

    @Test
    public void testGetCommonAncestorHashNode2Lower() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorHash(nodes.get("8"),
                nodes.get("9"));

        assertThat(result.value, is("3"));
    }

    @Test
    public void testGetCommonAncestorHashOneParentOfTheOther() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorHash(
                nodes.get("5"),
                nodes.get("1"));

        assertThat(result.value, is("5"));
    }


    @Test
    public void testGetCommonAncestorPointerSameHeight() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorPointer(nodes.get("9"), nodes.get("4"));

        assertThat(result.value, is("7"));
    }

    @Test
    public void testGetCommonAncestorPointerNode1Lower() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorPointer(nodes.get("9"),
                nodes.get("8"));

        assertThat(result.value, is("3"));
    }

    @Test
    public void testGetCommonAncestorPointerNode2Lower() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorPointer(nodes.get("8"),
                nodes.get("9"));

        assertThat(result.value, is("3"));
    }

    @Test
    public void testGetCommonAncestorPointerOneParentOfTheOther() throws Exception {

        Map<String, ParentedTreeNode> nodes = new HashMap<>();
        getParentedTree(nodes);

        ParentedTreeNode result = solver.getCommonAncestorPointer(
                nodes.get("5"),
                nodes.get("1"));

        assertThat(result.value, is("5"));
    }



    @Test
    public void testGetCommonAncestorNoParentSameHeight() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParent(root, nodes.get("9"), nodes.get("4"));

        assertThat(result.value.getValue(), is("7"));
    }

    @Test
    public void testGetCommonAncestorNoParentNode1Lower() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParent(
                root,
                nodes.get("9"),
                nodes.get("8"));

        assertThat(result.value.getValue(), is("3"));
    }

    @Test
    public void testGetCommonAncestorNoParentNode2Lower() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParent(
                root,
                nodes.get("8"),
                nodes.get("9"));

        assertThat(result.value.getValue(), is("3"));
    }

    @Test
    public void testGetCommonAncestorNoParentOneParentOfTheOther() throws Exception {

        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = getUnparentedTree(nodes);

        TreeNode result = solver.getCommonAncestorNoParent(
                root,
                nodes.get("5"),
                nodes.get("1"));

        assertThat(result.value.getValue(), is("5"));
    }

    public ParentedTreeNode getParentedTree(Map<String, ParentedTreeNode> nodes) {

        ParentedTreeNode node7 = new ParentedTreeNode("7");
        ParentedTreeNode node5 = new ParentedTreeNode("5");
        ParentedTreeNode node3 = new ParentedTreeNode("3");
        ParentedTreeNode node2 = new ParentedTreeNode("2");
        ParentedTreeNode node8 = new ParentedTreeNode("8");
        ParentedTreeNode node10 = new ParentedTreeNode("10");
        ParentedTreeNode node4 = new ParentedTreeNode("4");
        ParentedTreeNode node9 = new ParentedTreeNode("9");
        ParentedTreeNode node1 = new ParentedTreeNode("1");

        nodes.put("7", node7);
        nodes.put("5", node5);
        nodes.put("3", node3);
        nodes.put("2", node2);
        nodes.put("8", node8);
        nodes.put("10", node10);
        nodes.put("4", node4);
        nodes.put("9", node9);
        nodes.put("1", node1);

        node7.left = node5;
        node7.right = node3;

        node5.left = node2;
        node5.parent = node7;

        node3.left = node8;
        node3.right = node10;
        node3.parent = node7;

        node2.right = node4;
        node2.parent = node5;

        node8.parent = node3;

        node10.left = node9;
        node10.parent = node3;

        node4.left = node1;
        node4.parent = node2;

        node9.parent = node10;

        node1.parent = node4;

        return node7;
    }


    public TreeNode getUnparentedTree(Map<String, TreeNode> nodes) {

        TreeNode node7 = new TreeNode("7");
        TreeNode node5 = new TreeNode("5");
        TreeNode node3 = new TreeNode("3");
        TreeNode node2 = new TreeNode("2");
        TreeNode node8 = new TreeNode("8");
        TreeNode node10 = new TreeNode("10");
        TreeNode node4 = new TreeNode("4");
        TreeNode node9 = new TreeNode("9");
        TreeNode node1 = new TreeNode("1");

        nodes.put("7", node7);
        nodes.put("5", node5);
        nodes.put("3", node3);
        nodes.put("2", node2);
        nodes.put("8", node8);
        nodes.put("10", node10);
        nodes.put("4", node4);
        nodes.put("9", node9);
        nodes.put("1", node1);

        node7.left = node5;
        node7.right = node3;

        node5.left = node2;

        node3.left = node8;
        node3.right = node10;

        node2.right = node4;

        node10.left = node9;

        node4.left = node1;

        return node7;
    }
}