package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Problem3Test {

    Problem3<String> solver = new Problem3<>();

    @Test
    public void testFindMiddleIterativeOdd() throws Exception {

        int size = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddleIterative(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(size / 2);

        assertThat(expectedMid.value, is(actualMid.value));
    }

    @Test
    public void testFindMiddleIterativeEven() throws Exception {
        int size = 4;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddleIterative(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(size / 2 - 1);

        assertThat(expectedMid.value, is(actualMid.value));

    }

    @Test
    public void testFindMiddleIterativeSingleElement() throws Exception {
        int size = 1;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddleIterative(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(0);

        assertThat(expectedMid.value, is(actualMid.value));
    }

    @Test
    public void testFindMiddlePointersEvenElements() throws Exception {

        int size = 4;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddlePointers(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(size / 2 - 1);

        assertThat(expectedMid.value, is(actualMid.value));

    }

    @Test
    public void testFindMiddlePointersOddElements() throws Exception {
        int size = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddlePointers(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(size / 2);

        assertThat(expectedMid.value, is(actualMid.value));
    }

    @Test
    public void testFindMiddlePointersSingleElement() throws Exception {
        int size = 1;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddlePointers(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(0);

        assertThat(expectedMid.value, is(actualMid.value));

    }

    @Test
    public void testMiddleCustomOdd() throws Exception {

        int size = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddleCustom(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(size / 2);

        assertThat(expectedMid.value, is(actualMid.value));
    }

    @Test
    public void testMiddleCustomEven() throws Exception {

        int size = 4;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddleCustom(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(size / 2 - 1);

        assertThat(expectedMid.value, is(actualMid.value));
    }

    @Test
    public void testFindMiddleCustomSingleElement() throws Exception {
        int size = 1;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        LinkedListNode<String> actualMid = solver.findMiddleCustom(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> expectedMid = linkedListHelper.getNodeAtIndex(0);

        assertThat(expectedMid.value, is(actualMid.value));
    }
}