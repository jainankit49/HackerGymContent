package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/5/14.
 * HackerGym.com
 */
class BasicLinkedList<T> {

    private LinkedListNode<T> head;

    /**
     * @param head head of the completely populated linked list
     */
    public BasicLinkedList(LinkedListNode<T> head) {
        this.head = head;
    }

    public int length() {
        int length = 0;
        LinkedListNode<T> temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    /**
     * @param value the value to search for. Note that this is not the actual node but the value of a node
     *              we are searching for
     * @return The first node that had the value we were looking for or null if the search was unsuccessful
     */
    public LinkedListNode<T> searchForValue(T value) {

        if (head == null) return null;

        LinkedListNode<T> temp = head;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * returns the node at the index specified.
     *
     * @param index an index starting from 0
     * @return the node found at index or null if the index is invalid
     */
    public LinkedListNode<T> getNodeAtIndex(int index) {

        if (head == null || index < 0) return null;

        LinkedListNode<T> temp = head;
        int indexCounter = 0;
        while (indexCounter < index) {
            temp = temp.next;
            if (temp == null) return null;
            indexCounter++;
        }

        //at this point indexCount
        return temp;
    }

    /**
     * returns whether the element was inserted or not
     *
     * @param node  the node to insert into the linked list
     * @param index the index at which to add the node. If the index is not a valid index in the linked list
     *              The node wont be inserted and the method will return false
     * @return the head of the linked list if successful and null if unsuccessful.
     * Please note that returning null may not be the best design decision but for this question
     * its good enough
     */
    public LinkedListNode<T> insertAtIndex(LinkedListNode<T> node, int index) {

        if (head == null || node == null) return null;

        //here is the edge case for inserting at the beginning of the list
        if (index == 0) {
            node.next = head;
            this.head = node;
            return node;
        }
        //first we need to find a node at index - 1 to add the new node after it
        LinkedListNode<T> before = getNodeAtIndex(index - 1);

        if (before == null) return null;

        LinkedListNode<T> after = before.next;

        before.next = node;

        if (after != null) {
            node.next = after;
        }

        return head;
    }

    public LinkedListNode<T> deleteNode(T valueToDelete) {

        if (head == null) return null;

        if (head.value.equals(valueToDelete)) {
            head = head.next;
            return head;
        }

        LinkedListNode<T> temp = head;
        while (temp.next != null) {
            //because we have already compared the value for head, its not
            //possible to miss it in the first iteration by looking into next
            if (temp.next.value.equals(valueToDelete)) {
                break;
            }
            temp = temp.next;
        }

        if (temp.next == null) return null;

        temp.next = temp.next.next;

        return head;
    }

    public boolean equalsLinkedList(LinkedListNode<T> other) {

        LinkedListNode<T> temp1 = this.head;
        LinkedListNode<T> temp2 = other;
        while (temp1 != null && temp2 != null) {
            if (!temp1.value.equals(temp2.value)) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 == null && temp2 == null) return true;
        return false;
    }

    public LinkedListNode<T> copyLinkedList(LinkedListNode<T> head) {

        if (head == null) return null;

        LinkedListNode<T> newHead = new LinkedListNode<>(head.value);
        LinkedListNode<T> temp = newHead;
        head = head.next;

        while (head != null) {
            temp.next = new LinkedListNode<>(head.value);
            temp = temp.next;
            head = head.next;
        }

        return newHead;
    }
}
