package com.hackergym.samples.stack;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem10Test {

    Problem10 solver = new Problem10();
    @Test
    public void testFindMaxRectCustom() throws Exception {
        Integer[] heights = {1, 9, 11, 12, 2, 15};
        assertThat(solver.findMaxRectCustom(heights), is(27));
    }

    @Test
    public void testFindMaxRectCustomAllEqual() throws Exception {

        Integer[] heights = {2, 2, 2, 2, 2, 2};
        assertThat(solver.findMaxRectCustom(heights), is(12));
    }

    @Test
    public void testFindMaxRectCustomSingleTall() throws Exception {

        Integer[] heights = {1, 2, 3, 200, 4, 5};
        assertThat(solver.findMaxRectCustom(heights), is(200));
    }

    @Test
    public void testFindMaxRect() throws Exception {

        Integer[] heights = {1, 9, 11, 12, 2, 15};
        assertThat(solver.findMaxRect(heights), is(27));
    }

    @Test
    public void testFindMaxRectAllEqual() throws Exception {

        Integer[] heights = {2, 2, 2, 2, 2, 2};
        assertThat(solver.findMaxRectCustom(heights), is(12));
    }

    @Test
    public void testFindMaxRectSingleTall() throws Exception {

        Integer[] heights = {1, 2, 3, 200, 4, 5};
        assertThat(solver.findMaxRect(heights), is(200));
    }
}