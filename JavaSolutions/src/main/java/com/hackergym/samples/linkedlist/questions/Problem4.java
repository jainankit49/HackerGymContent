package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/8/14.
 * HackerGym.com
 */

/**
 * Question:
 * Imagine a linked list that has duplicate items.
 * Write an algorithm to remove duplicates without using any extra space or changing the data structure.
 *
 * For detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=4
 */
public class Problem4<T extends Comparable> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public LinkedListNode<T> removeDuplicatesCustom(LinkedListNode<T> head) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testRemoveDuplicatesCustom
        return removeDuplicates(head);
    }

    /**
     * @return the head of the linked list without the duplicates
     */
    public LinkedListNode<T> removeDuplicates(LinkedListNode<T> head) {

        LinkedListNode<T> temp = head;
        while (temp != null) {

            LinkedListNode<T> traverser = temp;
            //since we might be moving traverser twice
            while (traverser != null && traverser.next != null) {
                if (temp.value.equals(traverser.next.value)) {
                    traverser.next = traverser.next.next;
                }
                traverser = traverser.next;
            }


            temp = temp.next;
        }

        return head;
    }
}
