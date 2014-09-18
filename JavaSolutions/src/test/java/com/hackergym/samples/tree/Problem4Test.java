package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.TreeNode;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem4Test {

    Problem4 solver = new Problem4();

    @Test
    public void testGenerateBSTCustom() throws Exception {

        //       4
        //   2      6
        // 1  3   5   7

        Integer[] elements = {7, 3, 4, 5, 1, 0, 6, 2};
        TreeNode root = solver.generateBSTCustom(elements);

        assertThat(root.value.getValue(), is("4"));
        assertThat(root.left.value.getValue(), is("2"));
        assertThat(root.right.value.getValue(), is("6"));

        assertThat(root.left.left.value.getValue(), is("1"));
        assertThat(root.left.right.value.getValue(), is("3"));
        assertThat(root.right.left.value.getValue(), is("5"));
        assertThat(root.right.right.value.getValue(), is("7"));
    }


    @Test
    public void testGenerateBST() throws Exception {
        //       4
        //   2      6
        // 1  3   5   7

        Integer[] elements = {7, 3, 4, 5, 1, 0, 6, 2};
        TreeNode root = solver.generateBST(elements);

        assertThat(root.value.getValue(), is("4"));
        assertThat(root.left.value.getValue(), is("2"));
        assertThat(root.right.value.getValue(), is("6"));

        assertThat(root.left.left.value.getValue(), is("1"));
        assertThat(root.left.right.value.getValue(), is("3"));
        assertThat(root.right.left.value.getValue(), is("5"));
        assertThat(root.right.right.value.getValue(), is("7"));
    }

}