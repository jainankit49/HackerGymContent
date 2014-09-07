package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.SiblingListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fathalian on 6/9/14.
 * HackerGym.com
 */


/**
 * Imagine a linked list in which each node has two pointers.
 * One pointer points to the next node, and the other points to any other node or null (let’s call this a sibling pointer).
 * Implement an algorithm to copy this list.
 * <p/>
 * For detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=6
 */

public class Problem6<T> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public SiblingListNode<T> copyCustom(SiblingListNode<T> head) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testCopyCustom
        return copyWithHash(head);
    }

    /**
     * Copies the list pointed to by head and returns the copy.
     */
    public SiblingListNode<T> copyWithHash(SiblingListNode<T> head) {

        if (head == null) return null;


        //first copy all the elements sequentially
        SiblingListNode<T> copiedHead = null;
        SiblingListNode<T> copiedTraverser = null;
        SiblingListNode<T> headTraverser = head;

        Map<SiblingListNode<T>, SiblingListNode<T>> map = new HashMap<>();
        while (headTraverser != null) {
            SiblingListNode<T> copied = new SiblingListNode<>(headTraverser.value);
            if (copiedHead == null) {
                copiedHead = copied;
                copiedTraverser = copiedHead;
            } else {
                copiedTraverser.next = copied;
                copiedTraverser = copiedTraverser.next;
            }

            map.put(headTraverser, copied);

            headTraverser = headTraverser.next;
        }

        //now establish sibling links
        headTraverser = head;
        copiedTraverser = copiedHead;
        while (headTraverser != null) {
            SiblingListNode<T> copiedSibling = map.get(headTraverser.sibling);
            copiedTraverser.sibling = copiedSibling;
            copiedTraverser = copiedTraverser.next;
            headTraverser = headTraverser.next;
        }

        return copiedHead;
    }

    public SiblingListNode<T> copyWithPointer(SiblingListNode<T> head) {

        if (head == null) return null;

        //first copy each node and put it in from of the original node
        SiblingListNode<T> runner = head;
        while (runner != null) {
            SiblingListNode<T> next = runner.next;
            runner.next = new SiblingListNode<>(runner.value);
            runner = next;
        }

        //now establish sibling links for the copied elements
        runner = head;
        while (runner != null) {
            //there will always be a copy in front of the runner, so copy cannot be null here
            SiblingListNode<T> copy = runner.next;
            SiblingListNode<T> origSibling = runner.sibling;
            if (origSibling == null) {
                copy.sibling = null;
            } else {
                SiblingListNode<T> copySibling = origSibling.next;
                copy.sibling = copySibling;
            }

            //now move to the next original item
            runner = copy.next;
        }

        //finally separate even indexed and odd indexed items into two list
        return separateOdds(head);
    }

    private SiblingListNode<T> separateOdds(SiblingListNode<T> head) {

        if (head == null || head.next == null) return null;

        SiblingListNode<T> oddHead = head.next;
        SiblingListNode<T> oddTraverser = oddHead;
        SiblingListNode<T> evenTraverser = head;
        while (oddTraverser != null && evenTraverser != null) {
            SiblingListNode<T> nextEven = oddTraverser.next;
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

        return oddHead;

    }
}
