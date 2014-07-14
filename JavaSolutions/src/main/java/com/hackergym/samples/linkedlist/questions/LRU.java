package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */
public class LRU<T> {

    private LinkedListNode<T> head;
    //for constant insertion time at the end
    private LinkedListNode<T> tail;
    private final int size;
    private int currentLength = 0;

    public LRU(int size) {
        this.size = size;
    }

    /**
     * inserts the node in the cache. If the cache is not full the item is simply
     * inserted.
     * If cache is full. The Least Recently Used item will be kicked out of the cache.
     * Usage is determined by the get method on this class
     *
     * @param node the value to look for in the cache
     */
    public void insert(LinkedListNode<T> node) {

        //we always insert nodes at the end and remove the least recently used from the head

        if (node == null) return;
        if (head == null) {
            head = node;
            tail = node;
            currentLength++;
            return;
        }

        //if inserting this node will make the size of the cache go over
        //first move the head then add the new node at the end
        if (currentLength == size) {
            head = head.next;
            currentLength--;
        }

        //tail never could be null, since we handle the case of it being null at the
        //beginning
        tail.next = node;
        tail = tail.next;
        tail.next = null;
        currentLength++;
    }

    /**
     * checks whether the item is in the cache. Does not count as access and
     * hence doesnt promote the item as used.
     *
     * @param value the value to look for in the cache
     */
    public boolean contains(T value) {
        LinkedListNode<T> temp = head;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Getting a node will promote its usage and will become most recently used
     *
     * @param value the value to look for in the cache
     * @return the node with specified value. Null if its not found
     */
    public LinkedListNode<T> getNode(T value) {
        //whenever a node is accessed we delete it from wherever in the list it is and then append it
        // to the tail
        if (head == null) return null;

        //for simplicity, handle the special case of only single node in list here.
        if (head == tail) {
            return head;
        }

        LinkedListNode<T> temp = head;
        while (temp.next != null) {
            if (temp.next.value.equals(value)) {

                LinkedListNode<T> promotedNode = temp.next;
                temp.next = temp.next.next;
                tail.next = promotedNode;
                tail = promotedNode;
                promotedNode.next = null;
                return tail;
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * traverses the cache and returns the actual number of nodes in it
     */
    public int length() {
        int calculateLength = 0;
        LinkedListNode<T> temp = head;
        while (temp != null) {
            temp = temp.next;
            calculateLength++;
        }

        //make sure that always calculated length and the explicit length match
        assert calculateLength == currentLength;

        return calculateLength;
    }
}
