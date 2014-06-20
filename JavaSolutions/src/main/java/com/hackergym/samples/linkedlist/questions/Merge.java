package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */
public class Merge<T extends Comparable> {

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
