package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.IntNode;
import com.hackergym.samples.tree.model.TreeFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem1Test {

    TreeFactory factory = new TreeFactory();
    Problem1 solver = new Problem1();

    @Test
    public void testSearchCustom() throws Exception {

        //Arrange
        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        IntNode node = solver.searchCustom(root, 1);
        assertThat(node.value, is(1));

        node = solver.searchCustom(root, 9);
        assertThat(node.value, is(9));

        node = solver.searchCustom(root, 5);
        assertThat(node.value, is(5));

        node = solver.searchCustom(root, 12);
        assertThat(node, nullValue());
    }

    @Test
    public void testInsertCustom() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.insertCustom(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));

        solver.insertCustom(root, 0);
        solver.insertCustom(root, 10);

        result = root.printPostOrder();
        expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(result, is(expected));
    }

    @Test
    public void testInsertCustomDuplicate() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.insertCustom(root, 5);
        solver.insertCustom(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));
    }

    @Test
    public void testInsertCustomRootDuplicate() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.insertCustom(root, 5);
        solver.insertCustom(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));
    }

    @Test
    public void testDeleteCustom() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.deleteCustom(root, 4);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));

        solver.deleteCustom(root, 1);
        solver.deleteCustom(root, 9);

        result = root.printPostOrder();
        expected = Arrays.asList(2, 3, 5, 6, 7, 8);

        assertThat(result, is(expected));

        solver.deleteCustom(root, 9);

        result = root.printPostOrder();
        expected = Arrays.asList(2, 3, 5, 6, 7, 8);

        assertThat(result, is(expected));
    }

    @Test
    public void testDeleteCustomRoot() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        root = solver.deleteCustom(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9);

        assertThat(result, is(expected));

        root = solver.deleteCustom(root, 4);
        root = solver.deleteCustom(root, 3);
        root = solver.deleteCustom(root, 2);
        root = solver.deleteCustom(root, 1);
        root = solver.deleteCustom(root, 6);
        root = solver.deleteCustom(root, 7);
        root = solver.deleteCustom(root, 8);


        result = root.printPostOrder();
        expected = Arrays.asList(9);

        assertThat(result, is(expected));

        IntNode newRoot = solver.deleteCustom(root, 9);

        assertThat(newRoot, nullValue());
    }

    @Test
    public void testSearch() throws Exception {

        //Arrange
        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        IntNode node = solver.search(root, 1);
        assertThat(node.value, is(1));

        node = solver.search(root, 9);
        assertThat(node.value, is(9));

        node = solver.search(root, 5);
        assertThat(node.value, is(5));

        node = solver.search(root, 12);
        assertThat(node, nullValue());
    }

    @Test
    public void testInsert() throws Exception {
        Integer[] treeNodes = {1, 2, 3, 4, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.insert(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));

        solver.insert(root, 0);
        solver.insert(root, 10);

        result = root.printPostOrder();
        expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(result, is(expected));
    }

    @Test
    public void testInsertDuplicate() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.insert(root, 5);
        solver.insert(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));
    }

    @Test
    public void testInsertRootDuplicate() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.insert(root, 5);
        solver.insert(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));
    }

    @Test
    public void testDelete() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        solver.delete(root, 4);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9);

        assertThat(result, is(expected));

        solver.delete(root, 1);
        solver.delete(root, 9);

        result = root.printPostOrder();
        expected = Arrays.asList(2, 3, 5, 6, 7, 8);

        assertThat(result, is(expected));

        solver.delete(root, 9);

        result = root.printPostOrder();
        expected = Arrays.asList(2, 3, 5, 6, 7, 8);

        assertThat(result, is(expected));
    }

    @Test
    public void testDeleteRoot() throws Exception {

        Integer[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntNode root = factory.generateBST(treeNodes);

        root = solver.delete(root, 5);

        List<Integer> result = root.printPostOrder();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9);

        assertThat(result, is(expected));

        root = solver.delete(root, 4);
        root = solver.delete(root, 3);
        root = solver.delete(root, 2);
        root = solver.delete(root, 1);
        root = solver.delete(root, 6);
        root = solver.delete(root, 7);
        root = solver.delete(root, 8);


        result = root.printPostOrder();
        expected = Arrays.asList(9);

        assertThat(result, is(expected));

        IntNode newRoot = solver.delete(root, 9);

        assertThat(newRoot, nullValue());
    }

}