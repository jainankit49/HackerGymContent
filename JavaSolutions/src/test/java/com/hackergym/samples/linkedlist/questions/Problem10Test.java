package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Problem10Test {

    Problem10 solver = new Problem10();

    @Test
    public void testSumEqualLength() throws Exception {

        int num1 = 902;
        int num2 = 942;
        testPerformOperation(solver::sum, num1, num2, num1 + num2);
    }

    @Test
    public void testSumNonEqualLength() throws Exception {

        int num1 = 162;
        int num2 = 9942;
        testPerformOperation(solver::sum, num1, num2, num1 + num2);
    }

    @Test
    public void testSumCarry() throws Exception {
        int num1 = 987;
        int num2 = 9877;
        testPerformOperation(solver::sum, num1, num2, num1 + num2);
    }

    @Test
    public void testSumReverseEqualLength() throws Exception {

        int num1 = 192;
        int num2 = 102;
        testPerformOperation(solver::sumReverse, num1, num2, num1 + num2);
    }

    @Test
    public void testSumReverseNonEqualLength() throws Exception {
        int num1 = 1000;
        int num2 = 102;
        testPerformOperation(solver::sumReverse, num1, num2, num1 + num2);
    }

    @Test
    public void testSumReverseCarry() throws Exception {
        int num1 = 1087;
        int num2 = 102;
        testPerformOperation(solver::sumReverse, num1, num2, num1 + num2);
    }

    @Test
    public void testSumCustomEqualLength() throws Exception {

        int num1 = 902;
        int num2 = 942;
        testPerformOperation(solver::sumCustom, num1, num2, num1 + num2);
    }

    @Test
    public void testSumCustomNonEqualLength() throws Exception {

        int num1 = 162;
        int num2 = 9942;
        testPerformOperation(solver::sumCustom, num1, num2, num1 + num2);
    }

    @Test
    public void testSumCustomCarry() throws Exception {
        int num1 = 987;
        int num2 = 9877;
        testPerformOperation(solver::sumCustom, num1, num2, num1 + num2);
    }

    @Test
    public void testSubtractEqualLength() throws Exception {
        int num1 = 192;
        int num2 = 102;
        testPerformOperation(solver::subtract, num1, num2, num1 - num2);
    }

    @Test
    public void testSubtractNonEqualLength() throws Exception {
        int num1 = 8192;
        int num2 = 102;
        testPerformOperation(solver::subtract, num1, num2, num1 - num2);
    }

    @Test
    public void testSubtractSmallerFirst() throws Exception {
        int num1 = 8192;
        int num2 = 102;
        testPerformOperation(solver::subtract, num2, num1, num1 - num2);

    }

    @Test
    public void testSubtractBorrow() throws Exception {
        int num1 = 1000;
        int num2 = 9;
        testPerformOperation(solver::subtract, num1, num2, num1 - num2);
    }
    @Test
    public void testSubtractCustomBorrow() throws Exception {
        int num1 = 1000;
        int num2 = 9;
        testPerformOperation(solver::subtractCustom, num1, num2, num1 - num2);
    }

    @Test
    public void testSubtractCustomEqualLength() throws Exception {
        int num1 = 192;
        int num2 = 102;
        testPerformOperation(solver::subtractCustom, num1, num2, num1 - num2);
    }

    @Test
    public void testSubtractCustomNonEqualLength() throws Exception {
        int num1 = 8192;
        int num2 = 102;
        testPerformOperation(solver::subtractCustom, num1, num2, num1 - num2);
    }

    @Test
    public void testSubtractCustomSmallerFirst() throws Exception {
        int num1 = 8192;
        int num2 = 102;
        testPerformOperation(solver::subtractCustom, num2, num1, num1 - num2);

    }

    private void testPerformOperation(BiFunction<LinkedListNode<Integer>, LinkedListNode<Integer>, LinkedListNode<Integer>> function,
                                      int num1, int num2, int expectedResultInt) {

        LinkedListNode<Integer> num1Head = LinkedListFactory.generateLinkedListFromNumber(num1);
        LinkedListNode<Integer> num2Head = LinkedListFactory.generateLinkedListFromNumber(num2);
        LinkedListNode<Integer> expectedResult = LinkedListFactory.generateLinkedListFromNumber(expectedResultInt);
        LinkedListNode<Integer> actualResult = function.apply(num1Head, num2Head);

        BasicLinkedList<Integer> linkedListHelper = new BasicLinkedList<>(expectedResult);

        assertThat(linkedListHelper.equalsLinkedList(actualResult), is(true));

    }
}