package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Fathalian on 6/7/14.
 * HackerGym.com
 */
public class Interleaving<T> {

    public LinkedListNode<T> interleaveStack(LinkedListNode<T> head) {

        if (head == null) return null;

        if (head.next == null) return head;

        //The middle finder code is written in a way that if the list is odd it
        //returns the median and if the list is even returns the element closer
        //to the beginning. Because of that in both cases we just move the middle
        //one ahead so we reach the beginning of the possible palindrome second half
        MiddleFinder<T> middleFinder = new MiddleFinder<>();
        LinkedListNode<T> temp = middleFinder.findMiddlePointers(head);
        temp = temp.next;

        Deque<LinkedListNode<T>> stack = new ArrayDeque<>();

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;
        LinkedListNode<T> newHead = null;
        LinkedListNode<T> tempAdder = null;
        //because of the way the middle is calculated, there will be less or equal
        // items in the stack than the first half of the linked list.
        // For this reason, it is the stack which will become empty
        // before temp reaches null
        while (!stack.isEmpty()) {
            if (newHead == null) {
                newHead = temp;
                tempAdder = newHead;
            }else {
                tempAdder.next = temp;
                tempAdder = tempAdder.next;
            }
            //this is a gotcha. If you dont move the temp before moving the tempAdder,
            // temp will get corrupted and we wont have access to the elements of
            // the linkedlist.

            temp = temp.next;

            tempAdder.next = stack.pop();
            tempAdder = tempAdder.next;
            tempAdder.next = null;
        }

        //In case odd number of elements, there will be an extra item in the original
        //linkedlist
        if (temp != null) {
            tempAdder.next = temp;
            temp.next = null;
        }

        return newHead;
    }

    public LinkedListNode<T> interleaveReverse(LinkedListNode<T> head) {

        if (head == null) return null;

        if (head.next == null) return head;

        //The middle finder code is written in a way that if the list is odd it
        //returns the median and if the list is even returns the element closer
        //to the beginning. Because of that in both cases we just move the middle
        //one ahead so we reach the beginning of the possible palindrome second half
        MiddleFinder<T> middleFinder = new MiddleFinder<>();
        LinkedListNode<T> temp = middleFinder.findMiddlePointers(head);
        temp = temp.next;

        //now reverse the second half
        Reverse<T> reverser = new Reverse<>();
        //because reverse works in place we need a new copy
        BasicLinkedList<T> helper = new BasicLinkedList<>(head);
        LinkedListNode<T> midSliceCopy = helper.copyLinkedList(temp);
        LinkedListNode<T> midHead = reverser.reverseWithPointers(midSliceCopy);

        LinkedListNode<T> firstHalfTraverser = head;
        LinkedListNode<T> secondHalfTraverser = midHead;
        LinkedListNode<T> newHead = null;
        LinkedListNode<T> newTraverser = null;

        //because of the way middle is calculated, secondHalfTraverser will always reach end sooner or
        //at the same time firstHalfTraverser reaches mid
        while (secondHalfTraverser != null) {
            if (newHead == null) {
                newHead = firstHalfTraverser;
                newTraverser = newHead;
            }else {
                newTraverser.next = firstHalfTraverser;
                newTraverser = newTraverser.next;
            }

            //this is a gotcha. If you dont move the temp before moving the tempAdder,
            // temp will get corrupted and we wont have access to the elements
            // of the linkedlist.
            firstHalfTraverser = firstHalfTraverser.next;

            newTraverser.next = secondHalfTraverser;
            newTraverser = newTraverser.next;
            newTraverser.next = null;
            secondHalfTraverser = secondHalfTraverser.next;

        }
        return newHead;
    }

}
