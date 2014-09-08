package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem24Test {

    Problem24 travers = new Problem24();

    @Test
    public void testTraverseSpiral() throws Exception {

        int[][] matrix =
                {
                        {1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35, 36}

                };
        String result = "1-2-3-4-5-6-12-18-24-30-36-35-34-33-32-31-25-19-13-7-8-9-10-11-17-23-29-28-27-26-20-14-15-16-22-21-";

        assertThat(travers.traverseSpiral(matrix), is(result));
    }

    @Test
    public void testTraverseTwoElements() throws Exception {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        String result = "1-2-4-3-";

        assertThat(travers.traverseSpiral(matrix), is(result));
    }

    @Test
    public void testTraverseOneElement() throws Exception {
        int[][] matrix = {{1}};
        String result = "1";

        assertThat(travers.traverseSpiral(matrix), is(result));
    }

    @Test
    public void testTraverseSpiralCustom() throws Exception {

        int[][] matrix =
                {
                        {1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35, 36}

                };
        String result = "1-2-3-4-5-6-12-18-24-30-36-35-34-33-32-31-25-19-13-7-8-9-10-11-17-23-29-28-27-26-20-14-15-16-22-21-";

        assertThat(travers.traverseSpiralCustom(matrix), is(result));
    }

    @Test
    public void testTraverseCustomTwoElements() throws Exception {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        String result = "1-2-4-3-";

        assertThat(travers.traverseSpiralCustom(matrix), is(result));
    }

    @Test
    public void testTraverseCustomOneElement() throws Exception {
        int[][] matrix = {{1}};
        String result = "1";

        assertThat(travers.traverseSpiralCustom(matrix), is(result));
    }
}