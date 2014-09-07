package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 6/7/14.
 * HackerGym.com
 */

/**
 * We have a linked list that contains a loop (i.e., Instead of null, the last node points to another node).
 * Write an algorithm that detects and removes a loop from the linked list.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=11
 */

public class Problem11<T> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public LinkedListNode<T> removeLoopCustom(LinkedListNode<T> head) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testRemoveLoopCustom
        return removeLoopHash(head);
    }

    /**
     * removes any loop that are found in this linked list
     *
     * @return head of the linked list with the loop removed
     */
    public LinkedListNode<T> removeLoopHash(LinkedListNode<T> head) {

        if (head == null) return null;

        Set<LinkedListNode<T>> set = new HashSet<>();

        LinkedListNode<T> temp = head;
        boolean loopDetected = false;
        while (!loopDetected && temp.next != null) {
            if (set.contains(temp.next)) {
                loopDetected = true;
                break;
            } else {
                set.add(temp.next);
                temp = temp.next;
            }
        }

        if (loopDetected) {
            temp.next = null;
        }
        return head;
    }

    /**
     * removes any loop that are found in this linked list
     *
     * @return head of the linked list with the loop removed
     */
    public LinkedListNode<T> removeLoopPointers(LinkedListNode<T> head) {

        if (head == null) return null;

        LinkedListNode<T> slow = head;
        LinkedListNode<T> fast = head;
        boolean collision = false;

        //move the two pointers at different speeds until they collide
        while (!collision && fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                collision = true;
            }
        }

        //move the slow pointer to the head and move both at the same speed
        //until they collide
        if (collision) {
            slow = head;
            collision = false;
            //if the two nodes collided once, they will meet again
            while (!collision) {
                slow = slow.next;
                fast = fast.next;
                if (fast == slow) {
                    collision = true;
                }
            }
            //at this point fast and slow both point to the first node in the cycle

            //remove the cycle by bringing fast behind the first node and making it point to null
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        } else {
            //no loop
            return head;
        }

        return head;
    }
}
