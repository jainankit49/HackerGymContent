package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/7/14.
 * HackerGym.com
 */

/**
 * Question:
 * Write an algorithm to find the middle of a linked list.
 * If the list is even-sized, the middle is the node that is closer to the beginning.
 *
 * For detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=3
 */

public class Problem3<T> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public LinkedListNode<T> findMiddleCustom(LinkedListNode<T> head) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testMiddleCustom
        return findMiddleIterative(head);
    }


    public LinkedListNode<T> findMiddleIterative(LinkedListNode<T> head) {

        if (head == null) return null;

        int size = 1;
        LinkedListNode<T> temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        int mid = size / 2;
        if (size % 2 == 0) {
            mid--;
        }

        //now get the middle element
        temp = head;
        while (mid != 0) {
            mid--;
            temp = temp.next;
        }
        return temp;
    }

    public LinkedListNode<T> findMiddlePointers(LinkedListNode<T> head) {

        if (head == null) return null;
        LinkedListNode<T> slow = head;
        LinkedListNode<T> fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null || fast.next == null) {
                return slow;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
