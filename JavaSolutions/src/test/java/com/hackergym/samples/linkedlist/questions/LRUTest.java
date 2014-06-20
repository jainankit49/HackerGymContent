package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LRUTest {

    @Test
    public void testLRUInsert() throws Exception {
        int size = 4;
        LRU<String> lru = new LRU<>(4);

        for (int i = 0; i < 4; i++) {
            LinkedListNode<String> node = new LinkedListNode<>(String.valueOf(i));
            lru.insert(node);
        }

        for (int i = 0; i < 4; i++) {
            assertThat(lru.contains(String.valueOf(i)), is(true));
        }

        int extraItem1 = 4;
        LinkedListNode<String> newNode = new LinkedListNode<>(String.valueOf(extraItem1));
        lru.insert(newNode);
        assertThat(lru.contains(String.valueOf(extraItem1)), is(true));
        assertThat(lru.length(), is(size));

        for(int i = 5; i < 8; i++) {
            LinkedListNode<String> node = new LinkedListNode<>(String.valueOf(i));
            lru.insert(node);
            assertThat(lru.contains(String.valueOf(i)), is(true));
            assertThat(lru.length(), is(size));
        }

        for (int i = 0; i < 4; i++) {
            assertThat(lru.contains(String.valueOf(i)), is(false));
        }
    }

    @Test
    public void testLRUGet() throws Exception {

        int size = 4;
        LRU<String> lru = new LRU<>(4);

        for (int i = 0; i < 4; i++) {
            LinkedListNode<String> node = new LinkedListNode<>(String.valueOf(i));
            lru.insert(node);
        }

        //access a node
        String accessedValue1 = "2";
        LinkedListNode<String> accessedNode1 = lru.getNode(accessedValue1);
        assertThat(accessedNode1.value, is(accessedValue1));
        assertThat(lru.length(), is(size));

        //now insert 3 other nodes
        for (int i = 4; i < 7; i++) {
            LinkedListNode<String> node = new LinkedListNode<>(String.valueOf(i));
            lru.insert(node);
            assertThat(lru.length(), is(size));
            assertThat(lru.contains(String.valueOf(i)), is(true));
        }

        //check that the node we accessed still exists
        assertThat(lru.contains(accessedValue1), is(true));


        //now access two nodes
        for(int i=4; i < 6; i++) {
            LinkedListNode<String> accessedNode = lru.getNode(String.valueOf(i));
            assertThat(accessedNode.value, is(String.valueOf(i)));
            assertThat(lru.length(), is(size));
        }

        //insert 2 other nodes
        for (int i = 6 ; i < 8; i++) {
            LinkedListNode<String> node = new LinkedListNode<>(String.valueOf(i));
            lru.insert(node);
            assertThat(lru.length(), is(size));
            assertThat(lru.contains(String.valueOf(i)), is(true));
        }

        //the only items should now be : 4,5,6,7
        for (int i = 4; i < 8; i++) {
            assertThat(lru.contains(String.valueOf(i)), is(true));
        }

        //finally, add 4 new items
        for (int i = 8; i < 12; i++) {
            LinkedListNode<String> node = new LinkedListNode<>(String.valueOf(i));
            lru.insert(node);
            assertThat(lru.contains((String.valueOf(i))), is(true));
        }
        for (int i = 4; i < 8; i++) {
            assertThat(lru.contains((String.valueOf(i))), is(false));
        }
    }

    @Test
    public void testLRUSizeOne() throws Exception {
        int size = 1;
        String value = "0";
        LRU<String> lru = new LRU<>(size);
        LinkedListNode<String> node = new LinkedListNode<>(value);
        lru.insert(node);

        LinkedListNode<String> actualNode = lru.getNode(value);
        assertThat(node.value, is(actualNode.value));
   }

}