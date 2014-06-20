package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.BigListNode;
import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.Pair;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FlattenTest {

    Flatten<String> solver = new Flatten<>();

    @Test
    public void testFlattenList() throws Exception {
        Pair<BigListNode<String>, String[]> pair = LinkedListFactory.generateBigList();
        BigListNode<String> head = pair.fst;
        String[] expectedResult = pair.snd;
        Pair<BigListNode<String>, BigListNode<String>> resultPair = solver.flattenList(head);
        BigListNode<String> resultHead = resultPair.fst;

        for(int i = 0 ; i <expectedResult.length; i++) {
            String expectedValue = expectedResult[i];
            String actualValue = resultHead.value;
            resultHead = resultHead.next;
            assertThat(actualValue, is(expectedValue));
        }

    }

    @Test
    public void testFlattenListNoChildren() throws Exception {

        Pair<BigListNode<String>, String[]> pair = LinkedListFactory.generateFlatBigList(10);
        BigListNode<String> head = pair.fst;
        Pair<BigListNode<String>, BigListNode<String>> resultPair = solver.flattenList(head);
        BigListNode<String> resultHead = resultPair.fst;
        String[] expectedResult = pair.snd;

        for(int i = 0 ; i <expectedResult.length; i++) {
            String expectedValue = expectedResult[i];
            String actualValue = resultHead.value;
            resultHead = resultHead.next;
            assertThat(actualValue, is(expectedValue));
        }
    }

}