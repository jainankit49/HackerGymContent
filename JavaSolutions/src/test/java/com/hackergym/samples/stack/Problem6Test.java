package com.hackergym.samples.stack;

import com.hackergym.samples.tree.*;
import com.hackergym.samples.tree.Problem5;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem6Test {

    Problem6 solver = new Problem6();
    Problem5 treeGen = new com.hackergym.samples.tree.Problem5();


    @Test
    public void testPrintCustomEven() throws Exception {
        Integer[] treeNodes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        StringNode root = treeGen.generateBST(treeNodes);
        List<Integer> result = solver.printCustom(root);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintCustomOdd() throws Exception {

        Integer[] treeNodes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        StringNode root = treeGen.generateBST(treeNodes);
        List<Integer> result = solver.printCustom(root);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintWithHashEven() throws Exception {

        Integer[] treeNodes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        StringNode root = treeGen.generateBST(treeNodes);
        List<Integer> result = solver.printWithHash(root);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintWithHashOdd() throws Exception {

        Integer[] treeNodes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        StringNode root = treeGen.generateBST(treeNodes);
        List<Integer> result = solver.printWithHash(root);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintWithAuxEven() throws Exception {

        Integer[] treeNodes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        StringNode root = treeGen.generateBST(treeNodes);
        List<Integer> result = solver.printWithAux(root);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintWithAuxOdd() throws Exception {
        Integer[] treeNodes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        StringNode root = treeGen.generateBST(treeNodes);
        List<Integer> result = solver.printWithAux(root);

        assertThat(result, is(expected));

    }
}