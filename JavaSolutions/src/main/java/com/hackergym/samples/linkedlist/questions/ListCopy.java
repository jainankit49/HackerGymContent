package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.SiblingListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fathalian on 6/9/14.
 * HackerGym.com
 */
public class ListCopy<T> {

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
