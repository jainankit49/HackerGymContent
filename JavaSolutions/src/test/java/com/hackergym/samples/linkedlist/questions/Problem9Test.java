package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class Problem9Test {

    Problem9<String> solver = new Problem9<>();

    @Test
    public void testStraightDelete() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);
        testDelete(head, 3);
    }

    @Test
    public void testStraightLastElement() throws Exception {

        //note that the algorithm won't work for the last element.
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);

        //use basic linked list helper to get the node to delete
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> nodeToDelete = linkedListHelper.getNodeAtIndex(6);
        String valueToDelete = nodeToDelete.value;
        solver.straightDelete(nodeToDelete);

        LinkedListNode<String> deletedNode = linkedListHelper.searchForValue(valueToDelete);
        assertThat(deletedNode, is(notNullValue()));
    }

    @Test
    public void testStraightFirstElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);
        testDelete(head, 0);
    }

    @Test
    public void testStraightDeleteCustom() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);
        testDeleteCustom(head, 3);
    }

    @Test
    public void testStraightDeleteCustomLastElement() throws Exception {

        //note that the algorithm won't work for the last element.
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);

        //use basic linked list helper to get the node to delete
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> nodeToDelete = linkedListHelper.getNodeAtIndex(6);
        String valueToDelete = nodeToDelete.value;
        solver.straightDeleteCustom(nodeToDelete);

        LinkedListNode<String> deletedNode = linkedListHelper.searchForValue(valueToDelete);
        assertThat(deletedNode, is(notNullValue()));
    }

    @Test
    public void testStraightDeleteFirstElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);
        testDeleteCustom(head, 0);
    }

    private void testDelete(LinkedListNode<String> head, int indexToDelete) {

        //use basic linked list helper to get the node to delete
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> nodeToDelete = linkedListHelper.getNodeAtIndex(indexToDelete);
        String valueToDelete = nodeToDelete.value;
        solver.straightDelete(nodeToDelete);

        LinkedListNode<String> deletedNode = linkedListHelper.searchForValue(valueToDelete);
        assertThat(deletedNode, is(nullValue()));

    }

    private void testDeleteCustom(LinkedListNode<String> head, int indexToDelete) {

        //use basic linked list helper to get the node to delete
        BasicLinkedList<String> linkedListHelper = new BasicLinkedList<>(head);
        LinkedListNode<String> nodeToDelete = linkedListHelper.getNodeAtIndex(indexToDelete);
        String valueToDelete = nodeToDelete.value;
        solver.straightDeleteCustom(nodeToDelete);

        LinkedListNode<String> deletedNode = linkedListHelper.searchForValue(valueToDelete);
        assertThat(deletedNode, is(nullValue()));

    }
}