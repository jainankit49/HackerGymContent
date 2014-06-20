package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/8/14.
 * HackerGym.com
 */
public class DuplicateRemover<T extends Comparable> {

    /**
     * @return the head of the linked list without the duplicates
     */
    public LinkedListNode<T> removeDuplicates(LinkedListNode<T> head) {

        LinkedListNode<T> temp = head;
        LinkedListNode<T> traverser = temp;
        while (temp != null) {
            //since we might be moving traverser twice
            while (traverser != null && traverser.next != null) {
                if (temp.value.equals(traverser.next.value)) {
                    traverser.next = traverser.next.next;
                }
                traverser = traverser.next;
            }

            temp = temp.next;
        }

        return head;
    }
}
