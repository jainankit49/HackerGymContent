package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Problem12Test {

    private Problem12 solver = new Problem12();

    @Test
    public void testIsPalindromeReverseEven() throws Exception {
        String str = "abba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeReverse(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeReverseEvenNegative() throws Exception {
        String str = "abca";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeReverse(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeReverseOdd() throws Exception {
        String str = "abcba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeReverse(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeReverseOddNegative() throws Exception {

        String str = "abcbc";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeReverse(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeReverseSingleElement() throws Exception {
        String str = "a";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeReverse(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeHalfReverseOdd() throws Exception {

        String str = "abcba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeHalfReverse(head);

        assertThat(isPalindrome, is(true));
    }


    @Test
    public void testIsPalindromeHalfReverseOddNegative() throws Exception {
        String str = "abcca";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeHalfReverse(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeHalfReverseEven() throws Exception {

        String str = "abba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeHalfReverse(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeHalfReverseEvenNegative() throws Exception {

        String str = "abbaba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeHalfReverse(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeStackEven() throws Exception {

        String str = "abba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeStack(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeStackEvenNegative() throws Exception {

        String str = "abbaba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeStack(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeStackOdd() throws Exception {

        String str = "abcba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeStack(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeStackOddNegative() throws Exception {
        String str = "abcbb";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeStack(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeStackSingle() throws Exception {
        String str = "a";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeStack(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeCustomEven() throws Exception {
        String str = "abba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeCustom(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeCustomEvenNegative() throws Exception {
        String str = "abca";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeCustom(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeCustomOdd() throws Exception {
        String str = "abcba";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeCustom(head);

        assertThat(isPalindrome, is(true));
    }

    @Test
    public void testIsPalindromeCustomOddNegative() throws Exception {

        String str = "abcbc";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeCustom(head);

        assertThat(isPalindrome, is(false));
    }

    @Test
    public void testIsPalindromeCustomSingleElement() throws Exception {
        String str = "a";
        LinkedListNode<String> head = LinkedListFactory.generateLinkedListFromString(str);
        boolean isPalindrome = solver.isPalindromeCustom(head);

        assertThat(isPalindrome, is(true));
    }
}