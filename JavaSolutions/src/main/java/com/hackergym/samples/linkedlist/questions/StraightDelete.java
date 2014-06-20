package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */
public class StraightDelete<T> {
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
