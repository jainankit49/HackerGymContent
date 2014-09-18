package com.hackergym.samples.tree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fathalian on 9/17/14.
 * HackerGym.com
 */
public class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> adjacents = new ArrayList<>();

    public GraphNode(T value) {
        this.value = value;
    }

}
