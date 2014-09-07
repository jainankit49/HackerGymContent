package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Fathalian on 6/7/14.
 * HackerGym.com
 */

/**
 * Write an algorithm to detect if a linked list of unknown size is palindrome.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=12
 */

public class Problem12 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public boolean isPalindromeCustom(LinkedListNode<String> head) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testIsPalindromeCustom
        return isPalindromeReverse(head);
    }

    public boolean isPalindromeReverse(LinkedListNode<String> head) {

        if (head == null) return false;

        //a single element list is always palindrome
        if (head.next == null) return true;

        Problem1<String> reverser = new Problem1<>();
        //because reverse works in place we need a new copy
        BasicLinkedList<String> helper = new BasicLinkedList<>(head);
        LinkedListNode<String> headCopy = helper.copyLinkedList(head);
        LinkedListNode<String> reversedHead = reverser.reverseWithPointers(headCopy);

        while (reversedHead != null) {
            if (!reversedHead.value.equals(head.value)) return false;
            reversedHead = reversedHead.next;
            head = head.next;
        }
        return true;
    }


    public boolean isPalindromeHalfReverse(LinkedListNode<String> head) {

        if (head == null) return false;

        if (head.next == null) return true;

        //The middle finder code is written in a way that if the list is odd it
        //returns the median and if the list is even returns the element closer
        //to the beginning. Because of that in both cases we just move the middle
        //one ahead so we reach the beginning of the possible palindrome second half
        Problem3<String> middleFinder = new Problem3<>();
        LinkedListNode<String> temp = middleFinder.findMiddlePointers(head);
        if (temp == null) return false;
        temp = temp.next;

        //now reverse the second half
        Problem1<String> reverser = new Problem1<>();
        temp = reverser.reverseWithPointers(temp);

        while (temp != null) {
            if (!temp.value.equals(head.value)) return false;
            temp = temp.next;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindromeStack(LinkedListNode<String> head) {

        if (head == null) return false;

        if (head.next == null) return true;

        //The middle finder code is written in a way that if the list is odd it
        //returns the median and if the list is even returns the element closer
        //to the beginning. Because of that in both cases we just move the middle
        //one ahead so we reach the beginning of the possible palindrome second half
        Problem3<String> middleFinder = new Problem3<>();
        LinkedListNode<String> temp = middleFinder.findMiddlePointers(head);
        if (temp == null) return false;
        temp = temp.next;

        Deque<LinkedListNode<String>> stack = new ArrayDeque<>();

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        //now reposition temp at the head
        temp = head;
        while (!stack.isEmpty()) {
            if (!temp.value.equals(stack.pop().value)) return false;
            temp = temp.next;
        }
        return true;
    }
}
