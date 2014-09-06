package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Problem4Test {

    Problem4<String> solver = new Problem4<>();

    @Test
    public void testRemoveDuplicates() throws Exception {
        String listString = "AbcdAerf";
        char[] expectedResult = "Abcderf".toCharArray();
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(listString);
        LinkedListNode<String> result = solver.removeDuplicates(head);
        List<String> resultList = result.toJavaStandardList();
        for(int i = 0; i < expectedResult.length; i++) {
            String expectedValue = String.valueOf(expectedResult[i]);
            String actualValue = resultList.get(i);
            assertThat(actualValue, is(expectedValue));
        }
    }

    @Test
    public void testRemoveDuplicatesMoreThanOne() throws Exception {

        String listString = "AAcdAerA";
        char[] expectedResult = "Acder".toCharArray();
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(listString);
        LinkedListNode<String> result = solver.removeDuplicates(head);
        List<String> resultList = result.toJavaStandardList();
        for(int i = 0; i < expectedResult.length; i++) {
            String expectedValue = String.valueOf(expectedResult[i]);
            String actualValue = resultList.get(i);
            assertThat(actualValue, is(expectedValue));
        }
    }

    @Test
    public void testRemoveDuplicatesNoDuplicates() throws Exception {
        String listString = "abcde";
        char[] expectedResult = listString.toCharArray();
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(listString);
        LinkedListNode<String> result = solver.removeDuplicates(head);
        List<String> resultList = result.toJavaStandardList();
        for(int i = 0; i < expectedResult.length; i++) {
            String expectedValue = String.valueOf(expectedResult[i]);
            String actualValue = resultList.get(i);
            assertThat(actualValue, is(expectedValue));
        }
    }

    @Test
    public void testRemoveDuplicatesCustom() throws Exception {
        String listString = "AbcdAerf";
        char[] expectedResult = "Abcderf".toCharArray();
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(listString);
        LinkedListNode<String> result = solver.removeDuplicatesCustom(head);
        List<String> resultList = result.toJavaStandardList();
        for(int i = 0; i < expectedResult.length; i++) {
            String expectedValue = String.valueOf(expectedResult[i]);
            String actualValue = resultList.get(i);
            assertThat(actualValue, is(expectedValue));
        }
    }

    @Test
    public void testRemoveDuplicatesCustomMoreThanOne() throws Exception {

        String listString = "AAcdAerA";
        char[] expectedResult = "Acder".toCharArray();
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(listString);
        LinkedListNode<String> result = solver.removeDuplicatesCustom(head);
        List<String> resultList = result.toJavaStandardList();
        for(int i = 0; i < expectedResult.length; i++) {
            String expectedValue = String.valueOf(expectedResult[i]);
            String actualValue = resultList.get(i);
            assertThat(actualValue, is(expectedValue));
        }
    }

    @Test
    public void testRemoveDuplicatesCustomNoDuplicates() throws Exception {
        String listString = "abcde";
        char[] expectedResult = listString.toCharArray();
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(listString);
        LinkedListNode<String> result = solver.removeDuplicatesCustom(head);
        List<String> resultList = result.toJavaStandardList();
        for(int i = 0; i < expectedResult.length; i++) {
            String expectedValue = String.valueOf(expectedResult[i]);
            String actualValue = resultList.get(i);
            assertThat(actualValue, is(expectedValue));
        }
    }
}