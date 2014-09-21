package com.hackergym.samples.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fathalian on 9/17/14.
 * HackerGym.com
 */

/**
 * A max heap or priority queue is a type of binary tree in which
 * each node has the maximum value of the subtree that starts from that node.
 *
 * In addition, a heap is always balanced and
 * new nodes get added from left to right in the lower level.

 Implement a min heap that provides two operations:
 -	Insert: inserts a given node into the heap.
 -	ExtractMax: Removes the maximum value from the heap.


 * see more details at :
 * http://hackergym.com/#!/problemview/8790c162-f125-44e7-88d5-d1cd94b98264?p=2
 */
public class Problem2 {

    public interface MaxHeap {

        public int getSize();
        public int peekMax();
        public int extractMax();
        public void insert(int value);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/

    /**
     * Remove the delegate object and add your own code to
     * the public methods. Unit tests will be automatically run
     * against your code. All the unit tests will start with
     * testMaxHeapCustom
     */
    public class MaxHeapCustom implements MaxHeap {

        private MaxHeap delegate  = new MaxHeapArray();

        @Override
        public int getSize() {
            return delegate.getSize();
        }

        @Override
        public int peekMax() {
            return delegate.peekMax();
        }

        @Override
        public int extractMax() {
            return delegate.extractMax();
        }

        @Override
        public void insert(int value) {
            delegate.insert(value);

        }
    }

    public class MaxHeapArray implements MaxHeap {

        List<Integer> nodes = new ArrayList<>();

        @Override
        public int getSize() {
            return nodes.size();
        }

        @Override
        public int peekMax() {
            return nodes.get(0);
        }

        @Override
        public int extractMax() {
            return extractMaxRecursive(0);
        }

        private Integer extractMaxRecursive(int rootIndex) {

            Integer root = nodes.get(rootIndex);
            Integer leftChild = getLeftChild(rootIndex);
            Integer rightChild = getRightChild(rootIndex);

            if (leftChild == null && rightChild == null) {
                nodes.remove(rootIndex);
                return root;
            }

            else if (leftChild == null || (rightChild != null && rightChild > leftChild)) {
                Integer newChild = extractMaxRecursive(rightChildIndex(rootIndex));
                nodes.set(rootIndex, newChild);

            }
            else if (rightChild == null || (leftChild != null && leftChild >= rightChild)) {
                Integer newChild = extractMaxRecursive(leftChildIndex(rootIndex));
                nodes.set(rootIndex, newChild);
            }

            return root;
        }

        @Override
        public void insert(int nodeValue) {

            nodes.add(nodeValue);

            //the new node is added to the end of the array
            int nodeIndex = nodes.size() - 1;

            //heapify the nodes up
            Integer nodeParent  = getParent(nodeIndex);

            while(nodeParent != null && nodeValue > nodeParent) {

                //swap the node and parent
                int parentIndex = parentIndex(nodeIndex);
                Integer parentValue = nodes.get(parentIndex);
                nodes.set(parentIndex, nodeValue);
                nodes.set(nodeIndex, parentValue);

                //go one level up
                nodeIndex = parentIndex;
                nodeParent = getParent(nodeIndex);
            }
        }

        //	Left child of node at index i is at index 2* i  + 1.
        private int leftChildIndex(int index) {
            return 2 * index + 1;
        }


        // Right child of node at index i is at index 2*i + 2
        private int rightChildIndex(int index) {
            return 2 * index + 2;
        }


        //	Parent of node at index i is at index ( i – 1) /2
        private int parentIndex(int index) {
            return ( index - 1) / 2;
        }

        private Integer getLeftChild(int index) {
            int childIndex = leftChildIndex(index);
            if (childIndex < 0 || childIndex >= nodes.size()) {
                return null;
            } else {
                return nodes.get(childIndex);
            }
        }

        private Integer getRightChild(int index) {
            int childIndex = rightChildIndex(index);
            if (childIndex < 0 || childIndex >= nodes.size()) {
                return null;
            } else {
                return nodes.get(childIndex);
            }
        }

        private Integer getParent(int index) {

            int childIndex = parentIndex(index);
            if (childIndex < 0 || childIndex >= nodes.size()) {
                return null;
            } else {
                return nodes.get(childIndex);
            }
        }
    }

    public MaxHeap getMaxHeapArray() {
        return new MaxHeapArray();
    }

    public MaxHeap getMaxHeapCustom() {
        return new MaxHeapCustom();
    }
}
