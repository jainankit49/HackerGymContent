package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Problem11Test {

    Problem11<String> solver = new Problem11<>();

    @Test
    public void testRemoveLoopHash() throws Exception {
        int loopIndex = 5;
        int size = 9;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopHash, head, size);
    }


    @Test
    public void testRemoveLoopHashSingleNode() throws Exception {
        int loopIndex = 0;
        int size = 1;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopHash, head, size);
    }

    @Test
    public void testRemoveLoopHashNoLoop() throws Exception {
        int size = 7;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        testLoop(solver::removeLoopHash, head, size);
    }


    @Test
    public void testRemoveLoopPointersEvenNodes() throws Exception {
        int loopIndex = 5;
        int size = 10;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopPointers, head, size);
    }

    @Test
    public void testRemoveLoopPointersSingleNode() throws Exception {
        int loopIndex = 0;
        int size = 1;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopPointers, head, size);
    }

    @Test
    public void testRemoveLoopPointersOddNodes() throws Exception {
        int loopIndex = 6;
        int size = 11;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopPointers, head, size);
    }

    @Test
    public void testRemoveLoopPointersNoLoop() throws Exception {
        int size = 7;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        testLoop(solver::removeLoopPointers, head, size);
    }

    @Test
    public void testRemoveLoopCustomPointersEvenNodes() throws Exception {
        int loopIndex = 5;
        int size = 10;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopCustom, head, size);
    }

    @Test
    public void testRemoveLoopCustomSingleNode() throws Exception {
        int loopIndex = 0;
        int size = 1;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopCustom, head, size);
    }

    @Test
    public void testRemoveLoopCustomOddNodes() throws Exception {
        int loopIndex = 6;
        int size = 11;
        LinkedListNode<String> head = LinkedListFactory.generateCircularLinkedList(size, loopIndex);
        testLoop(solver::removeLoopCustom, head, size);
    }

    @Test
    public void testRemoveLoopCustomNoLoop() throws Exception {
        int size = 7;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        testLoop(solver::removeLoopCustom, head, size);
    }
   
    private void testLoop(Function<LinkedListNode<String>, LinkedListNode<String>> function,
                          LinkedListNode<String> head,
                          int expectedSize) {

        head = function.apply(head);
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        int actualSize = linkedListHelper.length();

        assertThat(expectedSize, is(actualSize));
    }
}