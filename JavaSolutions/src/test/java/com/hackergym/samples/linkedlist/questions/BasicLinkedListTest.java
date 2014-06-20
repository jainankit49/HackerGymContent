package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class BasicLinkedListTest {

    @Test
    public void testGetNodeAtIndexValid() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);
        int index = 1;
        LinkedListNode<String> node = linkedList.getNodeAtIndex(index);
        assertThat(node.value, is(String.valueOf(index)));
    }

    @Test
    public void testGetNodeAtIndexEmptyList() throws Exception {
        int index = 0;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(index);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        LinkedListNode<String> node = linkedList.getNodeAtIndex(index);
        assertThat(node, nullValue());
    }

    @Test
    public void testGetNodeAtIndexOneElementList() throws Exception {

        int index = 0;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        LinkedListNode<String> node = linkedList.getNodeAtIndex(index);
        assertThat(node.value, is(String.valueOf(index)));
    }

    @Test
    public void testSearchNodeWhenExists() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToLookFor = "3";
        LinkedListNode<String> node = linkedList.searchForValue(valueToLookFor);
        assertThat(node.value, is(valueToLookFor));
    }

    @Test
    public void testSearchNodeWhenDoesntExist() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToLookFor = "100";
        LinkedListNode<String> node = linkedList.searchForValue(valueToLookFor);
        assertThat(node, nullValue());
    }

    @Test
    public void testSearchNodeWhenListIsEmpty() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToLookFor = "100";
        LinkedListNode<String> node = linkedList.searchForValue(valueToLookFor);
        assertThat(node, nullValue());
    }

    @Test
    public void testSearchNodeWhenListHasOneElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToLookFor = "0";
        LinkedListNode<String> node = linkedList.searchForValue(valueToLookFor);

        assertThat(node.value, is(valueToLookFor));
    }

    @Test
    public void testInsertNodeInMiddle() throws Exception {

        int initialSize = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);
        int index = 2;
        String newNodeValue = "newValue";
        LinkedListNode<String> nodeToInsert = new LinkedListNode<>(newNodeValue);

        LinkedListNode<String> newHead = linkedList.insertAtIndex(nodeToInsert, index);

        assertThat(newHead, notNullValue());

        LinkedListNode<String> actualNode = linkedList.getNodeAtIndex(index);

        assertThat(actualNode.value, is(nodeToInsert.value));

        assertThat(actualNode.next, notNullValue());

        assertThat(linkedList.length(), is(initialSize +1));
    }

    @Test
    public void testInsertNodeInFront() throws Exception {

        int initialSize = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        int index = 0;
        String newNodeValue = "newValue";
        LinkedListNode<String> nodeToInsert = new LinkedListNode<>(newNodeValue);

        LinkedListNode<String> newHead = linkedList.insertAtIndex(nodeToInsert, index);

        assertThat(newHead, notNullValue());

        LinkedListNode<String> actualNode = linkedList.getNodeAtIndex(index);

        assertThat(actualNode.value, is(nodeToInsert.value));

        assertThat(actualNode.next, notNullValue());

        assertThat(linkedList.length(), is(initialSize +1));
    }

    @Test
    public void testInsertNodeAtEnd() throws Exception {

        int initialSize = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        int index = 5;
        String newNodeValue = "newValue";
        LinkedListNode<String> nodeToInsert = new LinkedListNode<>(newNodeValue);
        LinkedListNode<String> newHead = linkedList.insertAtIndex(nodeToInsert, index);

        assertThat(newHead, notNullValue());

        LinkedListNode<String> actualNode = linkedList.getNodeAtIndex(index);

        assertThat(actualNode.value, is(nodeToInsert.value));

        assertThat(actualNode.next, nullValue());

        assertThat(linkedList.length(), is(initialSize +1));
    }

    @Test
    public void testInsertNodeEmptyList() throws Exception {

        int initialSize = 0;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        int index = 3;
        String newNodeValue = "newValue";
        LinkedListNode<String> nodeToInsert = new LinkedListNode<>(newNodeValue);
        LinkedListNode<String> newHead = linkedList.insertAtIndex(nodeToInsert, index);

        assertThat(newHead, nullValue());

        assertThat(linkedList.length(), is(initialSize));
    }

    @Test
    public void testInsertNodeInvalidIndex() throws Exception {

        int initialSize = 4;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        int index = 9;
        String newNodeValue = "newValue";
        LinkedListNode<String> nodeToInsert = new LinkedListNode<>(newNodeValue);
        LinkedListNode<String> newHead = linkedList.insertAtIndex(nodeToInsert, index);

        assertThat(newHead, nullValue());

        assertThat(linkedList.length(), is(initialSize));
    }

    @Test
    public void testDeleteNodeInMiddle() throws Exception {

        int initialSize = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToDelete = "3";
        LinkedListNode<String> newHead = linkedList.deleteNode(valueToDelete);

        assertThat(linkedList.length(), is(initialSize-1));
        assertThat(newHead, notNullValue());
        assertThat(linkedList.searchForValue(valueToDelete), nullValue());
    }

    @Test
    public void testDeleteNodeInFront() throws Exception {

        int initialSize = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToDelete = "0";
        LinkedListNode<String> newHead = linkedList.deleteNode(valueToDelete);

        assertThat(linkedList.length(), is(initialSize-1));
        assertThat(newHead, notNullValue());
        assertThat(linkedList.searchForValue(valueToDelete), nullValue());
    }

    @Test
    public void testDeleteNodeAtEnd() throws Exception {
        int initialSize = 5;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToDelete = "4";
        LinkedListNode<String> newHead = linkedList.deleteNode(valueToDelete);

        assertThat(linkedList.length(), is(initialSize-1));
        assertThat(newHead, notNullValue());
        assertThat(linkedList.searchForValue(valueToDelete), nullValue());
    }

    @Test
    public void testDeleteNodeEmptyList() throws Exception {

        int initialSize = 0;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToDelete = "4";
        LinkedListNode<String> newHead = linkedList.deleteNode(valueToDelete);

        assertThat(linkedList.length(), is(initialSize));
        assertThat(newHead, nullValue());
    }

    @Test
    public void testDeleteNodeSingleList() throws Exception {

        int initialSize = 1;
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(initialSize);
        BasicLinkedList<String> linkedList = new BasicLinkedList<>(head);

        String valueToDelete = "0";
        LinkedListNode<String> newHead = linkedList.deleteNode(valueToDelete);

        assertThat(linkedList.length(), is(initialSize - 1));
        assertThat(newHead, nullValue());
    }
}