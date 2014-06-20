package com.hackergym.samples.linkedlist.model;

import java.util.ArrayList;
import java.util.List;

public class LinkedListNode<T> {

    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }

    public String printLinkedList() {
        StringBuilder builder = new StringBuilder();
        LinkedListNode<T> temp = this;
        while (temp != null) {
            builder.append(temp.value.toString());
            builder.append(" --> ");
            temp = temp.next;
        }
        builder.append("null\n");
        return builder.toString();
    }

    public List<T> toJavaStandardList() {
        List<T> result = new ArrayList<>();
        LinkedListNode<T> temp = this;
        while (temp != null) {
            result.add(temp.value);
            temp = temp.next;
        }
        return result;
    }

    public LinkedListNode<T> clone() {
        return new LinkedListNode<>(this.value);
    }

}
