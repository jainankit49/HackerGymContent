package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/7/14.
 * HackerGym.com
 */
public class MiddleFinder<T> {

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
