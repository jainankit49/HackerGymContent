package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListFactory;
import com.hackergym.samples.linkedlist.model.SiblingListNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Problem6Test {

    private Problem6<String> solver = new Problem6<>();

    @Test
    public void testCopyWithHash() throws Exception {

        SiblingListNode<String> head = LinkedListFactory.generateRandomSiblingList(10);
        SiblingListNode<String> copyHead = solver.copyWithHash(head);


        while (head != null) {
            assertThat(head != copyHead, is(true));
            assertThat(copyHead.value, is(head.value));
            if (copyHead.sibling != null && head.sibling != null) {
                assertThat(head.toString(), copyHead.sibling != head.sibling, is(true));
                assertThat(copyHead.sibling.value, is(head.sibling.value));
            }
            head = head.next;
            copyHead = copyHead.next;
        }

    }

    @Test
    public void testCopyWithHashSingleNode() throws Exception {

        SiblingListNode<String> head = LinkedListFactory.generateRandomSiblingList(1);
        SiblingListNode<String> copyHead = solver.copyWithHash(head);

        while (head != null) {
            assertThat(head != copyHead, is(true));
            assertThat(copyHead.value, is(head.value));
            if (copyHead.sibling != null && head.sibling != null) {
                assertThat(head.toString(), copyHead.sibling != head.sibling, is(true));
                assertThat(copyHead.sibling.value, is(head.sibling.value));
            }
            head = head.next;
            copyHead = copyHead.next;
        }


    }

    @Test
    public void testCopyWithPointers() throws Exception {

        SiblingListNode<String> head = LinkedListFactory.generateRandomSiblingList(10);
        SiblingListNode<String> copyHead = solver.copyWithPointer(head);

        while (head != null) {
            assertThat(head != copyHead, is(true));
            assertThat(copyHead.value, is(head.value));
            if (copyHead.sibling != null && head.sibling != null) {
                assertThat(head.toString(), copyHead.sibling != head.sibling, is(true));
                assertThat(copyHead.sibling.value, is(head.sibling.value));
            }
            head = head.next;
            copyHead = copyHead.next;
        }
    }

    @Test
    public void testCopyWithPointersSingleList() throws Exception {

        SiblingListNode<String> head = LinkedListFactory.generateRandomSiblingList(1);
        SiblingListNode<String> copyHead = solver.copyWithPointer(head);

        while (head != null) {
            assertThat(head != copyHead, is(true));
            assertThat(copyHead.value, is(head.value));
            if (copyHead.sibling != null && head.sibling != null) {
                assertThat(head.toString(), copyHead.sibling != head.sibling, is(true));
                assertThat(copyHead.sibling.value, is(head.sibling.value));
            }
            head = head.next;
            copyHead = copyHead.next;
        }


    }

    @Test
    public void testCopyCustom() throws Exception {

        SiblingListNode<String> head = LinkedListFactory.generateRandomSiblingList(10);
        SiblingListNode<String> copyHead = solver.copyCustom(head);


        while (head != null) {
            assertThat(head != copyHead, is(true));
            assertThat(copyHead.value, is(head.value));
            if (copyHead.sibling != null && head.sibling != null) {
                assertThat(head.toString(), copyHead.sibling != head.sibling, is(true));
                assertThat(copyHead.sibling.value, is(head.sibling.value));
            }
            head = head.next;
            copyHead = copyHead.next;
        }

    }

    @Test
    public void testCopyCustomSingleNode() throws Exception {

        SiblingListNode<String> head = LinkedListFactory.generateRandomSiblingList(1);
        SiblingListNode<String> copyHead = solver.copyCustom(head);

        while (head != null) {
            assertThat(head != copyHead, is(true));
            assertThat(copyHead.value, is(head.value));
            if (copyHead.sibling != null && head.sibling != null) {
                assertThat(head.toString(), copyHead.sibling != head.sibling, is(true));
                assertThat(copyHead.sibling.value, is(head.sibling.value));
            }
            head = head.next;
            copyHead = copyHead.next;
        }


    }



}