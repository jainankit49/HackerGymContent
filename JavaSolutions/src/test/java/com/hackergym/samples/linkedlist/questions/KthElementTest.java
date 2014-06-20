package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class KthElementTest {

    private final KthElement<String> solver = new KthElement<>();
    @Test
    public void testGetKthElementStack() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 2;
        performSearchTestSuccess(solver::getKthElementStack, head, k);
    }

    @Test
    public void testGetKthElementStackEmptyList() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);
        int k = 2;
        performSearchTestUnsuccess(solver::getKthElementStack, head, k);
    }

    @Test
    public void testGetKthElementStackSingleItemList() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        int k = 0;
        performSearchTestSuccess(solver::getKthElementStack, head, k);
    }

    @Test
    public void testGetKthElementStackInvalidK() throws  Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 20;
        performSearchTestUnsuccess(solver::getKthElementStack, head, k);

    }

    @Test
    public void testGetKthElementStackLastElement() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 0;
        performSearchTestSuccess(solver::getKthElementStack, head, k);
    }

    @Test
    public void testGetKthElementRecursively() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 2;
        performSearchTestSuccess(solver::getKthElementRecursively, head, k);
    }

    @Test
    public void testGetKthElementRecursivelyEmptyList() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);
        int k = 2;
        performSearchTestUnsuccess(solver::getKthElementRecursively, head, k);
    }

    @Test
    public void testGetKthElementRecursivelySingleItemList() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        int k = 0;
        performSearchTestSuccess(solver::getKthElementRecursively, head, k);
    }

    @Test
    public void testGetKthElementRecursiveInvalidK() throws  Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 20;
        performSearchTestUnsuccess(solver::getKthElementRecursively, head, k);

    }

    @Test
    public void testGetKthElementRecursiveLastElement() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 0;
        performSearchTestSuccess(solver::getKthElementRecursively, head, k);
    }

    @Test
    public void testGetKthElementPointers() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 2;
        performSearchTestSuccess(solver::getKthElementPointers, head, k);
    }

    @Test
    public void testGetKthElementPointersEmptyList() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(0);
        int k = 2;
        performSearchTestUnsuccess(solver::getKthElementPointers, head, k);

    }

    @Test
    public void testGetKthElementPointersSingleElement() throws Exception {
        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(1);
        int k = 0;
        performSearchTestSuccess(solver::getKthElementPointers, head, k);

    }

    @Test
    public void testGetKthElementPointerInvalidK() throws  Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 20;
        performSearchTestUnsuccess(solver::getKthElementPointers, head, k);

    }

    @Test
    public void testGetKthElementPointerLastElement() throws Exception {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(5);
        int k = 0;
        performSearchTestSuccess(solver::getKthElementPointers, head, k);
    }

    private void performSearchTestSuccess(BiFunction<LinkedListNode<String>, Integer, LinkedListNode<String>> function,
                                          LinkedListNode<String> head,
                                          int k) {

        List<String> expectedList = head.toJavaStandardList();
        int kthElementValueIndex = (expectedList.size() - 1) - k;
        String expectedKthElement = expectedList.get(kthElementValueIndex);

        LinkedListNode<String> actualKthElement = function.apply(head, k);

        assertThat(actualKthElement.value, is(expectedKthElement));
    }

    private void performSearchTestUnsuccess(BiFunction<LinkedListNode<String>, Integer, LinkedListNode<String>> function,
                                          LinkedListNode<String> head,
                                          int k) {

        LinkedListNode<String> actualKthElement = function.apply(head, k);
        assertThat(actualKthElement, is(nullValue()));
    }
}