package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import com.hackergym.samples.linkedlist.model.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OddSeparatorTest {

    private OddSeparator<String> solver = new OddSeparator<>();

    @Test
    public void testSeparateOddsQueueEvenSize() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(8);
        performTestSeparation(solver::separateOddsQueue, head);
    }


    @Test
    public void testSeparateOddsQueueOddSize() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(7);
        performTestSeparation(solver::separateOddsQueue, head);
    }

    @Test
    public void testSeparateOddsQueueSingleSize() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        performTestSeparation(solver::separateOddsQueue, head);

    }

    @Test
    public void testSeparateOddsPointersEvenSize() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(8);
        performTestSeparation(solver::separateOddsPointers, head);
    }

    @Test
    public void testSeparateOddsPointersOddSize() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(9);
        performTestSeparation(solver::separateOddsPointers, head);

    }

    @Test
    public void testSeparateOddsPointersSingleSize() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        performTestSeparation(solver::separateOddsPointers, head);
    }

    private void performTestSeparation(Function<LinkedListNode<String>, Pair<LinkedListNode<String>, LinkedListNode<String>>> func,
                                       LinkedListNode<String> head) {

        List<String> headList = head.toJavaStandardList();

        Pair<LinkedListNode<String>, LinkedListNode<String>> pair = func.apply(head);
        LinkedListNode<String> odds = pair.snd;
        LinkedListNode<String> evens = pair.fst;
        List<String> oddsList = null;
        //in case there is only single element in the list
        if (odds == null) {
            oddsList = new ArrayList<>();
        } else {
            oddsList = odds.toJavaStandardList();
        }
        List<String> evensList = evens.toJavaStandardList();

        for (int i = 0; i < headList.size(); i++) {
            String value = headList.get(i);
            boolean oddContains = oddsList.contains(value);
            boolean evenContains = evensList.contains(value);
            if (i % 2 == 0) {
                assertThat(oddContains, is(false));
                assertThat(evenContains, is(true));
                assertThat(evensList.indexOf(value), is(i / 2));
            } else {
                assertThat(oddContains, is(true));
                assertThat(evenContains, is(false));
                assertThat(oddsList.indexOf(value), is(i / 2));
            }
        }
    }
}