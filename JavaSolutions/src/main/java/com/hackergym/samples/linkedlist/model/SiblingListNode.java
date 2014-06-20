package com.hackergym.samples.linkedlist.model;

/**
 * Created by Fathalian on 6/9/14.
 * HackerGym.com
 */
public class SiblingListNode<T> extends LinkedListNode<T>{

    public SiblingListNode<T> next;
    public SiblingListNode<T> sibling;
    public SiblingListNode(T value) {
        super(value);
    }

    @Override
    public String printLinkedList() {
        StringBuilder builder = new StringBuilder();
        SiblingListNode<T> traverser = this;
        while (traverser != null) {
            builder.append(traverser.toString());
            builder.append(" (S: " + traverser.sibling + "  - " + traverser.hashCode() + ")");
            builder.append(" --> ");
            traverser = traverser.next;
        }
        builder.append("\n");
        return builder.toString();
    }

    public String toString() {
        return value.toString();
    }
}
