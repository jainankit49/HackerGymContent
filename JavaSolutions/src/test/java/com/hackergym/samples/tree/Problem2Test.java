package com.hackergym.samples.tree;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem2Test {

    Problem2 problem2 = new Problem2();
    @Test
    public void testMaxHeapCustom() throws Exception {

        int[] elements = {10, 2, -5, 1, 3, 3, 0, -2, 11, 3, 6, 7};

        Problem2.MaxHeap maxHeap = problem2.getMaxHeapCustom();

        for(int i = 0 ; i < elements.length; i++) {
            maxHeap.insert(elements[i]);
        }

        Arrays.sort(elements);

        for(int i = elements.length - 1; i >= 0 ; i--) {
            assertThat(maxHeap.peekMax(), is(elements[i]));
            assertThat(maxHeap.getSize(), is(i + 1));
            assertThat(maxHeap.extractMax(), is(elements[i]));
        }
    }


    @Test
    public void testMaxHeap() throws Exception {

        int[] elements = {10, 2, -5, 1, 3, 3, 0, -2, 11, 3, 6, 7};

        Problem2.MaxHeap maxHeap = problem2.getMaxHeapArray();

        for(int i = 0 ; i < elements.length; i++) {
            maxHeap.insert(elements[i]);
        }

        Arrays.sort(elements);

        for(int i = elements.length - 1; i >= 0 ; i--) {
            assertThat(maxHeap.peekMax(), is(elements[i]));
            assertThat(maxHeap.getSize(), is(i + 1));
            int val = maxHeap.extractMax();
            assertThat(val, is(elements[i]));
        }
    }

    @Test
    public void testMaxHeapDuplicates() throws Exception {

    }
}