package com.hackergym.samples.stack;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem5Test {

    Problem5 solver = new Problem5();
    @Test
    public void testSortStackCustom() throws Exception {

        Stack<Integer> stack = new Stack<>();

        //[9, 8, 5, 3, 7, 7, 2, 4, 6, 3, 1]
        stack.push(9);
        stack.push(8);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(7);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(3);
        stack.push(1);

        Stack<Integer> result = solver.sortStackCustom(stack);

        assertThat(result.isEmpty(), is(false));

        //[1, 2, 3, 3, 4, 5, 6, 7, 7, 9, 9]
        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));
        assertThat(result.pop(), is(5));
        assertThat(result.pop(), is(6));
        assertThat(result.pop(), is(7));
        assertThat(result.pop(), is(7));
        assertThat(result.pop(), is(8));
        assertThat(result.pop(), is(9));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackCustomAlreadySorted() throws Exception {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack<Integer> result = solver.sortStackCustom(stack);

        assertThat(result.isEmpty(), is(false));

        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackCustomAllEquals() throws Exception {

        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);

        Stack<Integer> result = solver.sortStackCustom(stack);

        assertThat(result.isEmpty(), is(false));

        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackThreeStacks() throws Exception {

        Stack<Integer> stack = new Stack<>();

        //[9, 8, 5, 3, 7, 7, 2, 4, 6, 3, 1]
        stack.push(9);
        stack.push(8);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(7);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(3);
        stack.push(1);

        Stack<Integer> result = solver.sortStackThreeStacks(stack);

        assertThat(result.isEmpty(), is(false));

        //[1, 2, 3, 3, 4, 5, 6, 7, 7, 9, 9]
        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));
        assertThat(result.pop(), is(5));
        assertThat(result.pop(), is(6));
        assertThat(result.pop(), is(7));
        assertThat(result.pop(), is(7));
        assertThat(result.pop(), is(8));
        assertThat(result.pop(), is(9));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackThreeStacksAlreadySorted() throws Exception {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack<Integer> result = solver.sortStackThreeStacks(stack);

        assertThat(result.isEmpty(), is(false));

        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackThreeStacksAllEquals() throws Exception {

        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);

        Stack<Integer> result = solver.sortStackThreeStacks(stack);

        assertThat(result.isEmpty(), is(false));

        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackTwoStacks() throws Exception {

        Stack<Integer> stack = new Stack<>();

        //[9, 8, 5, 3, 7, 7, 2, 4, 6, 3, 1]
        stack.push(9);
        stack.push(8);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(7);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(3);
        stack.push(1);

        Stack<Integer> result = solver.sortStackTwoStacks(stack);

        assertThat(result.isEmpty(), is(false));

        //[1, 2, 3, 3, 4, 5, 6, 7, 7, 9, 9]
        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));
        assertThat(result.pop(), is(5));
        assertThat(result.pop(), is(6));
        assertThat(result.pop(), is(7));
        assertThat(result.pop(), is(7));
        assertThat(result.pop(), is(8));
        assertThat(result.pop(), is(9));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackTwoStacksAlreadySorted() throws Exception {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack<Integer> result = solver.sortStackTwoStacks(stack);

        assertThat(result.isEmpty(), is(false));

        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));

        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testSortStackTwoStacksAllEquals() throws Exception {

        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);

        Stack<Integer> result = solver.sortStackTwoStacks(stack);

        assertThat(result.isEmpty(), is(false));

        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(3));

        assertThat(result.isEmpty(), is(true));
    }
}