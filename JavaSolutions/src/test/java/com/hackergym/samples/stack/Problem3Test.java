package com.hackergym.samples.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem3Test {

    Problem3 solver = new Problem3();

    @Test
    public void testSolveHanoiCustom() throws Exception {

        //Arrange
        Arrays.asList(1, 2, 3, 4, 5, 6);
        Stack<Integer> source = new Stack<>();
        source.push(5);
        source.push(4);
        source.push(3);
        source.push(2);
        source.push(1);

        Stack<Integer> helper = new Stack<>();
        Stack<Integer> target = new Stack<>();
        //Act
        solver.solveHanoiCustom(source, target, helper);

        //Assert
        assertThat(source.isEmpty(), is(true));
        assertThat(helper.isEmpty(), is(true));
        assertThat(target.isEmpty(), is(false));
        for (int i = 1; i <= 5; i++) {
           assertThat(target.pop(), is(i));
        }
    }

    @Test
    public void testSolveHanoiCustomEmpty() throws Exception {

        Stack<Integer> helper = new Stack<>();
        Stack<Integer> target = new Stack<>();
        Stack<Integer> source = new Stack<>();

        solver.solveHanoiCustom(source, target, helper);

        assertThat(source.isEmpty(), is(true));
        assertThat(helper.isEmpty(), is(true));
        assertThat(target.isEmpty(), is(true));
    }

    @Test
    public void testSolveHanoi() throws Exception {

        //Arrange
        Arrays.asList(1, 2, 3, 4, 5, 6);
        Stack<Integer> source = new Stack<>();
        source.push(5);
        source.push(4);
        source.push(3);
        source.push(2);
        source.push(1);

        Stack<Integer> helper = new Stack<>();
        Stack<Integer> target = new Stack<>();
        //Act
        solver.solveHanoi(source, target, helper);

        //Assert
        assertThat(source.isEmpty(), is(true));
        assertThat(helper.isEmpty(), is(true));
        assertThat(target.isEmpty(), is(false));
        for (int i = 1; i <= 5; i++) {
            assertThat(target.pop(), is(i));
        }
    }

    @Test
    public void testSolveHanoiEmpty() throws Exception {

        Stack<Integer> helper = new Stack<>();
        Stack<Integer> target = new Stack<>();
        Stack<Integer> source = new Stack<>();

        solver.solveHanoi(source, target, helper);

        assertThat(source.isEmpty(), is(true));
        assertThat(helper.isEmpty(), is(true));
        assertThat(target.isEmpty(), is(true));
    }
}