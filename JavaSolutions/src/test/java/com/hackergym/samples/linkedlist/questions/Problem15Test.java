package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import com.hackergym.samples.linkedlist.model.Pair;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class Problem15Test {

    Problem15<String> solver = new Problem15<>();

    @Test
    public void testDetectIntersectionWithHashEqualSize() throws Exception {
        int sharedIndexInList1 = 3;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(7, 7, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionWithHash,
                pair.fst,
                pair.snd,
                sharedIndexInList1);
    }


    @Test
    public void testDetectIntersectionWithHashDifferentSizes() throws Exception {

        int sharedIndexInList1 = 3;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(7, 6, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionWithHash,
                pair.fst,
                pair.snd,
                sharedIndexInList1);

    }

    @Test
    public void testDetectIntersectionWithHashNotIntersecting() throws Exception {

        LinkedListNode<String> head1 = LinkedListFactory.generateStringLinkedList(5);
        LinkedListNode<String> head2 = LinkedListFactory.generateStringLinkedList(6);
        LinkedListNode<String> intersection = solver.detectIntersectionWithHash(head1, head2);
        assertThat(intersection, nullValue());
    }

    @Test
    public void testDetectIntersectionWithHashIntersectAtBeginning() throws Exception {
        int sharedIndexInList1 = 0;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(12, 15, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionWithHash,
                pair.fst,
                pair.snd,
                sharedIndexInList1);

    }

    @Test
    public void testDetectIntersectionWithPointersEqualSize() throws Exception {

        int sharedIndexInList1 = 3;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(7, 7, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionWithPointers,
                pair.fst,
                pair.snd,
                sharedIndexInList1);
    }

    @Test
    public void testDetectIntersectionWithPointersDifferentSizes() throws Exception {

        int sharedIndexInList1 = 3;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(5, 7, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionWithPointers,
                pair.fst,
                pair.snd,
                sharedIndexInList1);

    }

    @Test
    public void testDetectIntersectionWithPointerIntersectAtBeginning() throws Exception {

        int sharedIndexInList1 = 0;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(5, 9, 0);

        testIntersection(
                solver::detectIntersectionWithPointers,
                pair.fst,
                pair.snd,
                sharedIndexInList1);

    }

    @Test
    public void testDetectIntersectionWithPointersNotIntersecting() throws Exception {

        LinkedListNode<String> head1 = LinkedListFactory.generateStringLinkedList(5);
        LinkedListNode<String> head2 = LinkedListFactory.generateStringLinkedList(6);
        LinkedListNode<String> intersection = solver.detectIntersectionWithHash(head1, head2);
        assertThat(intersection, nullValue());

    }

    @Test
    public void testDetectIntersectionCustomEqualSize() throws Exception {
        int sharedIndexInList1 = 3;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(7, 7, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionCustom,
                pair.fst,
                pair.snd,
                sharedIndexInList1);
    }


    @Test
    public void testDetectIntersectionCustomDifferentSizes() throws Exception {

        int sharedIndexInList1 = 3;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(7, 6, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionCustom,
                pair.fst,
                pair.snd,
                sharedIndexInList1);

    }

    @Test
    public void testDetectIntersectionCustomNotIntersecting() throws Exception {

        LinkedListNode<String> head1 = LinkedListFactory.generateStringLinkedList(5);
        LinkedListNode<String> head2 = LinkedListFactory.generateStringLinkedList(6);
        LinkedListNode<String> intersection = solver.detectIntersectionCustom(head1, head2);
        assertThat(intersection, nullValue());
    }

    @Test
    public void testDetectIntersectionCustomIntersectAtBeginning() throws Exception {
        int sharedIndexInList1 = 0;
        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = LinkedListFactory.
                generateIntersectingLinkedLists(12, 15, sharedIndexInList1);

        testIntersection(
                solver::detectIntersectionCustom,
                pair.fst,
                pair.snd,
                sharedIndexInList1);

    }

    private void testIntersection(
            BiFunction<
                    LinkedListNode<String>,
                    LinkedListNode<String>,
                    LinkedListNode<String>> func,
            LinkedListNode<String> head1,
            LinkedListNode<String> head2,
            int intersectionIndex1) {

        LinkedListNode<String> sharedNode = func.apply(head1, head2);
        BasicLinkedList<String> helper = new BasicLinkedList<>(head1);
        LinkedListNode<String> expectedSharedNode = helper.getNodeAtIndex(intersectionIndex1);

        assertThat(expectedSharedNode == sharedNode, is(true));

    }
}