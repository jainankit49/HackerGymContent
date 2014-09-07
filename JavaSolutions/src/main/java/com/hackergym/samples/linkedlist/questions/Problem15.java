package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 6/8/14.
 * HackerGym.com
 */

/**
 * Imagine two linked lists of different sizes that merge at a single point.
 * Write an algorithm to find the merging point
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/3489afb7-9dad-4310-a907-02a265bea32c?p=15
 */

public class Problem15<T> {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public LinkedListNode<T> detectIntersectionCustom(LinkedListNode<T> head1,
                                                        LinkedListNode<T> head2) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testDetectIntersectionCustom
        return detectIntersectionWithHash(head1, head2);
    }

    /**
     * finds the intersection of two linked list if one exists
     *
     * @return the intersection point, or null if the linkedLists dont intersect
     */
    public LinkedListNode<T> detectIntersectionWithHash(LinkedListNode<T> head1,
                                                        LinkedListNode<T> head2) {

        if (head1 == null || head2 == null) return null;

        Set<LinkedListNode<T>> set = new HashSet<>();

        //first go through head1 and push everything into the linked list
        while(head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        //now go through the second head and check whether we
        // have seen an element before
        while (head2 != null) {
            if (set.contains(head2)) return head2;
            head2 = head2.next;
        }

        //we havent found anything , return
        return null;
    }

    /**
     * finds the intersection of two linked list if one exists
     *
     * @return the intersection point, or null if the linkedLists dont intersect
     */
    public LinkedListNode<T> detectIntersectionWithPointers(LinkedListNode<T> head1,
                                                            LinkedListNode<T> head2) {

        if (head1 == null || head2 == null) return null;

        //fist calculate the length of both lists
        LinkedListNode<T> temp = head1;
        int size1 = 0;
        while(temp != null) {
            temp = temp.next;
            size1++;
        }

        temp = head2;
        int size2 = 0;
        while (temp != null) {
            temp = temp.next;
            size2++;
        }

        LinkedListNode<T> longerListTraverser = size1 > size2 ? head1 : head2;

        LinkedListNode<T> shorterTraverser = longerListTraverser == head1 ? head2 : head1;
        //find the number of nodes to skip
        int skipNotes = Math.abs(size1-size2);
        while(skipNotes != 0) {
            longerListTraverser = longerListTraverser.next;
            skipNotes--;
        }


        //now both of the lists are aligned, move pointers at the same speed
        while(longerListTraverser != null && shorterTraverser != null) {
            if (longerListTraverser == shorterTraverser) return longerListTraverser;
            longerListTraverser = longerListTraverser.next;
            shorterTraverser = shorterTraverser.next;
        }

        //we dont have any intersection
        return null;
    }

}
