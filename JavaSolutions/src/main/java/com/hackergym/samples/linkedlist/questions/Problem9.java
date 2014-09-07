package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */

/**
 * Given access to only a single node in the middle of a linked list, remove that node.
 * Note that you don’t have access to the head and the size of the linked list.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=9
 */

public class Problem9<T> {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public void straightDeleteCustom(LinkedListNode<T> nodeToDelete) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testStraightDeleteCustom
        straightDelete(nodeToDelete);
    }

    public void straightDelete(LinkedListNode<T> nodeToDelete) {
        if (nodeToDelete == null) return;

        LinkedListNode<T> current = nodeToDelete;
        LinkedListNode<T> next = nodeToDelete.next;
        while(next != null) {
            current.value = next.value;
            current = current.next;
            next = next.next;
        }
    }
}
