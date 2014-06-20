package com.hackergym.samples.linkedlist.model;

/**
 * Created by Fathalian on 6/8/14.
 * HackerGym.com
 */
public class BigListNode<T> {

    public BigListNode<T> child;
    public BigListNode<T> next;
    public T value;

    public BigListNode(T value) {
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }
}
