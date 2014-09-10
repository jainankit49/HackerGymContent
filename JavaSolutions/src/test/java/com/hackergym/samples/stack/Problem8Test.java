package com.hackergym.samples.stack;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem8Test {

    Problem8 solver = new Problem8();

    @Test
    public void testReverseCustom() throws Exception {

        Stack<String> stack = new Stack<>();
        int size = 10;
        for(int i = 0 ; i <= size; i++) {
            stack.push(String.valueOf(i));
        }

        Stack<String> result = solver.reverseCustom(stack);

        for(int i = 0 ; i <= size ; i++) {
            assertThat(result.pop(), is(String.valueOf(i)));
        }
    }

    @Test
    public void testReverseRecursively() throws Exception {

        Stack<String> stack = new Stack<>();
        int size = 10;
        for(int i = 0 ; i <= size; i++) {
            stack.push(String.valueOf(i));
        }

        Stack<String> result = solver.reverseRecursively(stack);

        for(int i = 0 ; i <= size ; i++) {
            assertThat(result.pop(), is(String.valueOf(i)));
        }
    }
}