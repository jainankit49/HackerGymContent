package com.hackergym.samples.stack;

import java.util.Stack;

/**
 * Created by Fathalian on 9/8/14.
 * HackerGym.com
 */

/**
 *Implement a stack that other than push and pop contains a min operator
 * that gives you the element with the minimum value in the stack.
 * The min operator should not remove the element from the stack.

 * Push, pop, and min operations should be in O(1) time complexity.

 */

public class Problem2 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    /**
     * Remove the delegate object and add your own code to
     * the public methods. Unit tests will be automatically run
     * against your code. All the unit tests will start with
     * testMinStackCustom.
     */
    public class MinStackCustom {

        //remove this delegate object and add your own solution
        private MinStack delegate = new MinStack();

        public void push(Integer e) {
            delegate.push(e);
        }

        public Integer pop() {
            return delegate.pop();
        }

        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        public Integer min() {
            return delegate.min();
        }
    }

    public class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(Integer e) {

            stack.push(e);
            if (minStack.isEmpty() || minStack.peek() >= e) {
                minStack.push(e);
            }
        }

        public Integer pop() {

            Integer poppedInt = stack.pop();
            if (poppedInt == minStack.peek()) {
                minStack.pop();
            }
            return poppedInt;
        }

        public boolean isEmpty() {
            return stack.isEmpty();

        }

        public Integer min() {
            return minStack.peek();
        }
    }

    public MinStack getMinStack() {
        return new MinStack();
    }

    public MinStackCustom getMinStackCustom() {
        return new MinStackCustom();
    }
}
