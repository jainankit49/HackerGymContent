package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.BigListNode;
import com.hackergym.samples.linkedlist.model.Pair;

/**
 * Created by Fathalian on 6/8/14.
 * HackerGym.com
 */

/**
 * We have an imaginary type of linked list called Big List.
 * A Big List is a linked list that, in addition to the ‘next’ fields, has a special field called child.
 * The child field either points to null or points to another big list.
 * Write an algorithm to flatten the big list.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=7
 */
public class Problem7<T> {

    public Pair<BigListNode<T>, BigListNode<T>> flattenListCustom(BigListNode<T> head) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFlattenListCustom
        return flattenList(head);
    }

    public Pair<BigListNode<T>, BigListNode<T>> flattenList(BigListNode<T> head) {

        if (head.child == null) {
            BigListNode<T> tail = head;
            while(tail.next != null) {
                tail = tail.next;
            }
            return new Pair<>(head, tail);

        }
        BigListNode<T> temp = head;
        BigListNode<T> tail = temp;
        while (temp != null) {
            if (temp.child != null) {
                BigListNode<T> ahead = temp.next;
                Pair<BigListNode<T>, BigListNode<T>> result = flattenList(temp.child);
                BigListNode<T> flattenedChildHead = result.fst;
                BigListNode<T> flattenedChildTail = result.snd;
                temp.child = null;
                temp.next = flattenedChildHead;
                flattenedChildTail.next = ahead;
                if (ahead == null) {
                    tail = flattenedChildTail;
                }
                temp = ahead;
            }
            else {
                if (temp.next == null) {
                    tail = temp;
                }
                temp = temp.next;
            }
        }
        return new Pair<>(head, tail);
    }
}
