package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */

/**
 * The merge sort algorithm involves merging two lists that have been sorted individually.
 * Imagine that you have two individually sorted lists. Write a function that merges those two lists.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=8
 */
public class Problem8<T extends Comparable> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public LinkedListNode<T> mergeCustom(LinkedListNode<T> head1,
                                   LinkedListNode<T> head2) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testMergeCustom
        return merge(head1, head2);
    }
    public LinkedListNode<T> merge(LinkedListNode<T> head1,
                                   LinkedListNode<T> head2) {

        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        LinkedListNode<T> temp1 = head1;
        LinkedListNode<T> temp2 = head2;
        LinkedListNode<T> head3 = null;
        LinkedListNode<T> temp3 = null;

        //its easier to first establish the head of the third linked list
        //then iterate through it. This makes the while loop easier to read

        if (temp1.value.compareTo(temp2.value) <= 0) {
            head3 = temp1;
            temp1 = temp1.next;
        } else {
            head3 = temp2;
            temp2 = temp2.next;
        }

        head3.next = null;
        temp3 = head3;

        while (temp1 != null && temp2 != null) {

            if (temp1.value.compareTo(temp2.value) <= 0) {
                temp3.next = temp1;
                temp1 = temp1.next;
                temp3 = temp3.next;
                temp3.next = null;
            } else {
                temp3.next = temp2;
                temp2 = temp2.next;
                temp3 = temp3.next;
                temp3.next = null;
            }
        }

        //the case where one of the lists is smaller
        if (temp1 == null) {
            temp3.next = temp2;
        } else if (temp2 == null) {
            temp3.next = temp1;
        }

        return head3;
    }
}
