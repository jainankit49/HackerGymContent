package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class Problem8Test {

    private Problem8<Integer> solver = new Problem8<>();

    @Test
    public void testMergeTwoDifferentSizes() throws Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(10);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(5);

        testMerge(list1Head, list2Head);
    }

    @Test
    public void testMergeSameSize() throws Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(5);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(5);

        testMerge(list1Head, list2Head);
    }

    @Test
    public void testMergeOneEmpty() throws Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(5);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(0);

        testMerge(list1Head, list2Head);
    }

    @Test
    public void testMergeBothEmpty() throws  Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(0);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(0);

        LinkedListNode<Integer> actualMerged = solver.merge(list1Head, list2Head);
        assertThat(actualMerged, nullValue());
    }

    @Test
    public void testMergeCustomTwoDifferentSizes() throws Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(10);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(5);

        testMergeCustom(list1Head, list2Head);
    }

    @Test
    public void testMergeCustomSameSize() throws Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(5);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(5);

        testMergeCustom(list1Head, list2Head);
    }

    @Test
    public void testMergeCustomOneEmpty() throws Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(5);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(0);

        testMergeCustom(list1Head, list2Head);
    }

    @Test
    public void testMergeCustomBothEmpty() throws  Exception {
        LinkedListNode<Integer> list1Head = LinkedListFactory.generateSortedListOfNumbers(0);
        LinkedListNode<Integer> list2Head = LinkedListFactory.generateSortedListOfNumbers(0);

        LinkedListNode<Integer> actualMerged = solver.mergeCustom(list1Head, list2Head);
        assertThat(actualMerged, nullValue());
    }

    private void testMerge(LinkedListNode<Integer> list1Head,
                           LinkedListNode<Integer> list2Head) {

        List<Integer> expectedList = list1Head.toJavaStandardList();
        if (list2Head != null) {
            expectedList.addAll(list2Head.toJavaStandardList());
        }
        expectedList.sort((i1, i2) -> i1.compareTo(i2));

        LinkedListNode<Integer> actualMerged = solver.merge(list1Head, list2Head);
        List<Integer> actualMergedList = actualMerged.toJavaStandardList();
        assertThat(expectedList.size(), is (actualMergedList.size()));
        for (int i = 0 ; i < expectedList.size(); i++) {
            Integer expected = expectedList.get(i);
            Integer actual = actualMergedList.get(i);
            assertThat(expected, is(actual));
        }
    }

    private void testMergeCustom(LinkedListNode<Integer> list1Head,
                           LinkedListNode<Integer> list2Head) {

        List<Integer> expectedList = list1Head.toJavaStandardList();
        if (list2Head != null) {
            expectedList.addAll(list2Head.toJavaStandardList());
        }
        expectedList.sort((i1, i2) -> i1.compareTo(i2));

        LinkedListNode<Integer> actualMerged = solver.mergeCustom(list1Head, list2Head);
        List<Integer> actualMergedList = actualMerged.toJavaStandardList();
        assertThat(expectedList.size(), is (actualMergedList.size()));
        for (int i = 0 ; i < expectedList.size(); i++) {
            Integer expected = expectedList.get(i);
            Integer actual = actualMergedList.get(i);
            assertThat(expected, is(actual));
        }
    }
}