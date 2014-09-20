package com.hackergym.samples.tree;

import java.util.PriorityQueue;

import static com.hackergym.samples.tree.Problem6.*;

/**
 * Created by Fathalian on 9/20/14.
 * HackerGym.com
 */

/*
* You are given a stream of integers that you are reading one element at a time. You can only perform a get operation on this stream – the get operation retrieves and removes the first element from the stream.

* Write an algorithm that computes the median element at our current location.

* In the following example: [15, 7, 13, 6, 4, 8, 19, 3, 1, ….]
* 7 is the median value when we have read 9 elements.

* If there are even number of elements, the median is the smaller value.

 */
public class Problem10 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int findMedianCustom(IntegerStream stream) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindMedianCustom
        return findMedianHeap(stream);
    }

    public int findMedianHeap(IntegerStream stream) {
        //use a standard java PriorityQueue which is an
        // implementation of a minHeap
        PriorityQueue<Integer> largers = new PriorityQueue<>();

        //use the max heap implementation for problem2
        //we want to eat our own dogfood so apologies for incosistent
        //syntax
        Problem2.MaxHeap smallers = new Problem2().getMaxHeapArray();

        while (!stream.isEmpty()) {

            int value = stream.read();
            if (!largers.isEmpty() && value > largers.peek()) {
                largers.add(value);
            } else {
                smallers.insert(value);
            }

            if (smallers.getSize() > largers.size() + 1) {
                int movingValue = smallers.extractMax();
                largers.add(movingValue);
            }
            else if(largers.size() > smallers.getSize()) {
                int movingValue = largers.poll();
                smallers.insert(movingValue);
            }
        }

        return smallers.peekMax();
    }
}
