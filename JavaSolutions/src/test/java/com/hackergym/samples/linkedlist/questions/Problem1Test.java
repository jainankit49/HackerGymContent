package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class Problem1Test {

    private final Problem1<String> solver = new Problem1<>();

    @Test
    public void testReverseStackNormal() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);

        performReverseTestSuccess(solver::reverseWithStack, head);
    }

    @Test
    public void testReverseStackEmpty() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);

        performReverseTestEmpty(solver::reverseWithStack, head);

    }

    @Test
    public void testReverseStackSingleElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);

        performReverseTestSuccess(solver::reverseWithStack, head);
    }

    @Test
    public void testReverseRecursiveNormal() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);

        performReverseTestSuccess(solver::reverseRecursively, head);
    }

    @Test
    public void testReverseRecursiveEmpty() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);

        performReverseTestEmpty(solver::reverseRecursively, head);

    }

    @Test
    public void testReverseRecursiveSingleElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);

        performReverseTestSuccess(solver::reverseRecursively, head);
    }

    @Test
    public void testReversePointerNormal() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);

        performReverseTestSuccess(solver::reverseWithPointers, head);

    }

    @Test
    public void testReversePointerEmpty() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);

        performReverseTestEmpty(solver::reverseWithPointers, head);
    }

    @Test
    public void testReversePointerSingleElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);

        performReverseTestSuccess(solver::reverseWithPointers, head);

    }

    @Test
    public void testReversePointerTwoElements() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(2);

        performReverseTestSuccess(solver::reverseWithPointers, head);

    }

    @Test
    public void testReversePointerThreeElements() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(3);

        performReverseTestSuccess(solver::reverseWithPointers, head);

    }

    @Test
    public void testReversePointerEvenElements() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(4);

        performReverseTestSuccess(solver::reverseWithPointers, head);

    }

    @Test
    public void testReversePointerOddElements() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(4);

        performReverseTestSuccess(solver::reverseWithPointers, head);

    }

    @Test
    public void testReverseCustom() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);

        performReverseTestSuccess(solver::reverseCustomSolution, head);

    }

    @Test
    public void testReverseCustomEmpty() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);

        performReverseTestEmpty(solver::reverseCustomSolution, head);
    }

    @Test
    public void testReverseStackCustomSingleElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);

        performReverseTestSuccess(solver::reverseCustomSolution, head);
    }

    private void performReverseTestSuccess(Function<LinkedListNode<String>, LinkedListNode<String>> reverseFunction,
                                           LinkedListNode<String> head) {

        List<String> expectedList = head.toJavaStandardList();
        Collections.reverse(expectedList);

        LinkedListNode<String> actualReversed = reverseFunction.apply(head);
        List<String> actualReversedList = actualReversed.toJavaStandardList();

        assertThat(expectedList.size(), is(actualReversedList.size()));

        for (int i = 0; i < expectedList.size(); i++) {
            String expectedValue = expectedList.get(i);
            String actualValue = actualReversedList.get(i);
            assertThat(expectedValue, is(actualValue));
        }

    }

    private void performReverseTestEmpty(Function<LinkedListNode<String>, LinkedListNode<String>> reverseFunction,
                                           LinkedListNode<String> head) {

        LinkedListNode<String> actualReversed = reverseFunction.apply(head);

        assertThat(actualReversed, is(nullValue()));
    }
}