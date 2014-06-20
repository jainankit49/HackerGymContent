package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;
import com.hackergym.samples.linkedlist.model.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Fathalian on 6/9/14.
 * HackerGym.com
 */
public class OddSeparator<T> {

    /**
     * separates Nodes at even index from nodes at odd index in a linkedList pointed to by head
     *
     * @return a pair containing (EvenNodes, OddNodes) in which even nodes are nodes at the even
     * indexes and OddNodes are nodes at odd indexes
     */
    public Pair<LinkedListNode<T>, LinkedListNode<T>> separateOddsQueue(LinkedListNode<T> head) {

        if (head == null) return null;
        if (head.next == null) return new Pair<>(head, null);
        //use linked list as an underlying queue data structure
        Deque<LinkedListNode<T>> queue = new LinkedList<>();

        LinkedListNode<T> headTraverser = head;
        int index = 0;
        while (headTraverser != null) {
            if (index % 2 == 1) {
                queue.push(headTraverser);
            }
            headTraverser = headTraverser.next;
            index++;

        }

        LinkedListNode<T> oddHead = null;
        LinkedListNode<T> evenTraverser = head;
        LinkedListNode<T> oddTraverser = null;
        while (!queue.isEmpty()) {
            LinkedListNode<T> currentOdd = queue.removeLast();
            LinkedListNode<T> nextEven = currentOdd.next;
            if (evenTraverser != null) {
                evenTraverser.next = nextEven;
                evenTraverser = nextEven;
            }
            if (oddHead == null) {
                oddHead = currentOdd;
                oddTraverser = oddHead;
            } else {
                oddTraverser.next = currentOdd;
                oddTraverser = oddTraverser.next;
            }
        }

        if (evenTraverser != null) {
            evenTraverser.next = null;
        }
        if (oddTraverser != null) {
            oddTraverser.next = null;
        }

        Pair <LinkedListNode<T>, LinkedListNode<T>> result = new Pair<>(head, oddHead);
        return result;
    }

    /**
     * separates Nodes at even index from nodes at odd index in a linkedList pointed to by head
     *
     * @return a pair containing (EvenNodes, OddNodes) in which even nodes are nodes at the even
     * indexes and OddNodes are nodes at odd indexes
     */
    public Pair<LinkedListNode<T>, LinkedListNode<T>> separateOddsPointers(LinkedListNode<T> head) {

        if (head == null) return null;
        if (head.next == null) return new Pair<>(head, null);

        LinkedListNode<T> oddHead = head.next;
        LinkedListNode<T> oddTraverser = oddHead;
        LinkedListNode<T> evenTraverser = head;
        while (oddTraverser != null && evenTraverser != null) {
            LinkedListNode<T> nextEven = oddTraverser.next;
            evenTraverser.next = nextEven;
            evenTraverser = nextEven;
            if (oddTraverser != null && evenTraverser != null) {
                oddTraverser.next = evenTraverser.next;
                oddTraverser = oddTraverser.next;

            }
        }

        if (evenTraverser != null) {
            evenTraverser.next = null;
        }
        if (oddTraverser != null) {
            oddTraverser.next = null;
        }

        return new Pair<>(head, oddHead);
    }
}
