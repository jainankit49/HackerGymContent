package com.hackergym.samples.stack;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem2Test {

    Problem2 problem2 = new Problem2();
    @Test
    public void testMinStack() {

        Problem2.MinStack stack =  problem2.getMinStack();

        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(9);
        stack.push(1);
        stack.push(10);

        assertThat(stack.min(), is(1));
        //remove 10
        stack.pop();
        assertThat(stack.min(), is(1));
        //remove 1
        stack.pop();
        assertThat(stack.min(), is(2));
        //remove 9
        stack.pop();
        assertThat(stack.min(), is(2));
        //remove 2
        stack.pop();
        assertThat(stack.min(), is(3));
        //remove 3
        stack.pop();
        assertThat(stack.min(), is(5));
    }



    @Test
    public void testMinStackAllEquals() {

        Problem2.MinStack stack =  problem2.getMinStack();

        stack.push(2);
        stack.push(2);
        stack.push(2);

        assertThat(stack.min(), is(2));
        //remove 2
        stack.pop();
        assertThat(stack.min(), is(2));
        //remove 2
        stack.pop();
        assertThat(stack.min(), is(2));
    }

    @Test(expected = EmptyStackException.class)
    public void testMinStackNoElements() {

        Problem2.MinStack stack =  problem2.getMinStack();
        stack.push(2);
        assertThat(stack.min(), is(2));
        stack.pop();
        stack.min();
    }

    @Test
    public void testMinStackCustom() {

        Problem2.MinStackCustom stack =  problem2.getMinStackCustom();

        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(9);
        stack.push(1);
        stack.push(10);

        assertThat(stack.min(), is(1));
        //remove 10
        stack.pop();
        assertThat(stack.min(), is(1));
        //remove 1
        stack.pop();
        assertThat(stack.min(), is(2));
        //remove 9
        stack.pop();
        assertThat(stack.min(), is(2));
        //remove 2
        stack.pop();
        assertThat(stack.min(), is(3));
        //remove 3
        stack.pop();
        assertThat(stack.min(), is(5));
    }

    @Test
    public void testMinStackCustomAllEquals() {

        Problem2.MinStackCustom stack =  problem2.getMinStackCustom();

        stack.push(2);
        stack.push(2);
        stack.push(2);

        assertThat(stack.min(), is(2));
        //remove 2
        stack.pop();
        assertThat(stack.min(), is(2));
        //remove 2
        stack.pop();
        assertThat(stack.min(), is(2));
    }

    @Test(expected = EmptyStackException.class)
    public void testMinStackCustomPopAllElmenets() {

        Problem2.MinStack stack =  problem2.getMinStack();
        stack.push(2);
        assertThat(stack.min(), is(2));
        stack.pop();
        stack.min();
    }

}