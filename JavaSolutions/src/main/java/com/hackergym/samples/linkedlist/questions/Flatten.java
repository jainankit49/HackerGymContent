package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.BigListNode;
import com.hackergym.samples.linkedlist.model.Pair;

/**
 * Created by Fathalian on 6/8/14.
 * HackerGym.com
 */
public class Flatten<T> {

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
