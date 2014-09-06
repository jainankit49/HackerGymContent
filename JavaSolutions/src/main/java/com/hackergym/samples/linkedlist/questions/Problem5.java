package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */

/**
 * Question:
 * We have an ascending sorted linked list of unknown size. Implement an algorithm to find the kth largest element.
 * For simplicity, assume that there are no duplicates.
 * <p/>
 * For detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=5
 */
public class Problem5<T> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public LinkedListNode<T> getKthElementCustom(LinkedListNode<T> head, int k) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testGetKthElementCustom
        return getKthElementStack(head, k);
    }

    public LinkedListNode<T> getKthElementStack(LinkedListNode<T> head, int k) {

        if (head == null || k < 0) return null;
        //using java class Deque for stack.
        Deque<LinkedListNode<T>> stack = new ArrayDeque<>();
        LinkedListNode<T> temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        //check to see if we have k items in the stack (k is smaller than the total number
        //of items in linked list
        if (k > stack.size()) return null;

        while (k != 0) {
            stack.pop();
            k--;
        }

        return stack.pop();
    }

    public LinkedListNode<T> getKthElementRecursively(LinkedListNode<T> head,
                                                      int k) {
        if (head == null || k < 0) return null;
        List<LinkedListNode<T>> container = new ArrayList<>();
        performGetKthElementRecursively(head, k, container);

        //one reason that the container might be empty is that k is bigger than
        //the actual elements in the linked list
        return container.size() != 0 ? container.get(0) : null;
    }

    private int performGetKthElementRecursively(LinkedListNode<T> head, int k, List<LinkedListNode<T>> container) {

        //here is another gotcha. Make sure that if we are getting the
        // last we cover it in out recursive method
        if (head.next == null) {
            if (k == 0) {
                container.add(head);
            }
            return 0;
        }
        int selfIndex = performGetKthElementRecursively(head.next, k, container) + 1;
        if (selfIndex == k) {
            container.add(head);
        }
        return selfIndex;
    }

    public LinkedListNode<T> getKthElementPointers(LinkedListNode<T> head, int k) {

        if (head == null) return null;
        LinkedListNode<T> first = head;
        LinkedListNode<T> second = head;
        while (k != 0) {
            second = second.next;
            if (second == null) {
                return null;
            }
            k--;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        return first;
    }

}
