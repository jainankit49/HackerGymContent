package com.hackergym.samples.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Fathalian on 9/18/14.
 * HackerGym.com
 */

/**
 * have an unlimited stream of integers presented to you.

 * You can only call a get function on this stream to
 * retrieve and remove the first element from the stream.

 * Write an algorithm that can give you the top k largest integers at any point.
 */
public class Problem6 {

    public interface IntegerStream {

        public Integer read();
        public boolean isEmpty();

    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public List<Integer> topKCustom(int k, IntegerStream stream) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testTopKCustom
        return topK(k, stream);
    }


    //returns the topK elements in the stream
    //this is a simulate solution for this problem. In reality
    //the stream would be endless
    public List<Integer> topK(int k, IntegerStream stream) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while(!stream.isEmpty()) {
            Integer num = stream.read();
            //first we need to fill the heap with the first k elements
            if(minHeap.size() < k) {
                    minHeap.add(num);
            } else if (num > minHeap.peek()) {
                //we can modify our existing heap implementation
                //to combine these two operations into one.
                //to keep the length of the solution short
                //we are not adding a dedicated modify operation here
                minHeap.remove();
                minHeap.add(num);
            }
        }
        List<Integer> list = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            list.add(minHeap.remove());
        }
        return list;
    }

}
