package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Problem13Test {

    Problem13<String> solver = new Problem13<>();

    @Test
    public void testInterleaveStackEvent() throws Exception {

        int size = 10;
        performTestInterLeaving(solver::interleaveStack, size);
    }

    @Test
    public void testInterleaveStackOdd() throws Exception {
        int size = 9;
        performTestInterLeaving(solver::interleaveStack, size);
    }

    @Test
    public void testInterleaveSingleElement() throws Exception {
        int size = 1;
        performTestInterLeaving(solver::interleaveStack, size);
    }

    @Test
    public void testInterleaveReverseEven() throws Exception {
        int size = 12;
        performTestInterLeaving(solver::interleaveReverse, size);
    }

    @Test
    public void testInterleaveReverseOdd() throws Exception {
        int size = 11;
        performTestInterLeaving(solver::interleaveReverse, size);
    }

    @Test
    public void testInterleaveSingle() throws Exception {
        int size = 1;
        performTestInterLeaving(solver::interleaveReverse, size);
    }


    private void performTestInterLeaving(Function<LinkedListNode<String>, LinkedListNode<String>> func, int size) {

        LinkedListNode<String> head = LinkedListFactory.generateStringLinkedList(size);
        List<String> list = head.toJavaStandardList();
        LinkedListNode<String> interleavedHead = func.apply(head);

        List<String> expectedInterleave = interleave(list);
        List<String> actualeInterleave = interleavedHead.toJavaStandardList();
        System.out.printf(expectedInterleave.toString() + "\n");
        System.out.printf(actualeInterleave.toString() + "\n");
        for(int i=0; i < actualeInterleave.size(); i++) {
            assertThat(actualeInterleave.get(i), is(expectedInterleave.get(i)));
        }

    }

    private List<String> interleave(List<String> list) {

        List<String> result = new ArrayList<>();
        int mid = (list.size()-1) / 2;
        for (int i = 0 ; i <= mid; i++) {
            if (i != list.size() -1 -i) {
                result.add(list.get(i));
                result.add(list.get(list.size() - 1 - i));
            } else {
                result.add(list.get(i));
            }
        }
        return result;
    }
}