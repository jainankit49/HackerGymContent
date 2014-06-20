package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Fathalian on 6/7/14.
 * HackerGym.com
 */
public class Palindrome {

    public boolean isPalindromeReverse(LinkedListNode<String> head) {

        if (head == null) return false;

        //a single element list is always palindrome
        if (head.next == null) return true;

        Reverse<String> reverser = new Reverse<>();
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
        MiddleFinder<String> middleFinder = new MiddleFinder<>();
        LinkedListNode<String> temp = middleFinder.findMiddlePointers(head);
        if (temp == null) return false;
        temp = temp.next;

        //now reverse the second half
        Reverse<String> reverser = new Reverse<>();
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
        MiddleFinder<String> middleFinder = new MiddleFinder<>();
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
