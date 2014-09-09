package com.hackergym.samples.stack;

import com.hackergym.samples.model.Element;

import java.util.Stack;

/**
 * Created by Fathalian on 9/8/14.
 * HackerGym.com
 */

/**
 * Implement a queue using only stacks.
 * <p/>
 * Your queue should have dequeue, enqueue, and isEmpty operations.
 * Stack provides you with push, pop, and isEmpty operations.
 */
public class Problem4 {

    public interface QueueStack {
        public void enqueue(Element e);

        public Element dequeue();

        public boolean isEmpty();
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/

    /**
     * Remove the delegate object and add your own code to
     * the public methods. Unit tests will be automatically run
     * against your code. All the unit tests will start with
     * testQueueStackCustom.
     */
    public class QueueStackCustom implements QueueStack {

        private QueueStack delegate = new QueueStackTwoStack();

        @Override
        public void enqueue(Element e) {
            delegate.enqueue(e);
        }

        @Override
        public Element dequeue() {
            return delegate.dequeue();
        }

        @Override
        public boolean isEmpty() {
            return delegate.isEmpty();
        }
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/

    /**
     * Remove the delegate object and add your own code to
     * the public methods. Unit tests will be automatically run
     * against your code. All the unit tests will start with
     * testQueueStackCustomOptimized.
     */
    public class QueueStackCustomOptimized implements QueueStack {

        private QueueStack delegate = new QueueStackTwoStackOptimized();

        @Override
        public void enqueue(Element e) {
            delegate.enqueue(e);
        }

        @Override
        public Element dequeue() {
            return delegate.dequeue();
        }

        @Override
        public boolean isEmpty() {
            return delegate.isEmpty();
        }
    }

    public class QueueStackTwoStack implements QueueStack {

        Stack<Element> original = new Stack<>();
        Stack<Element> auxiliary = new Stack<>();

        @Override
        public void enqueue(Element e) {
            original.push(e);
        }

        @Override
        public Element dequeue() {

            //offload all the elements of original to auxiliary
            while (!original.isEmpty()) {
                auxiliary.push(original.pop());
            }

            Element result = auxiliary.pop();

            //now revert back the original
            while (!auxiliary.isEmpty()) {
                original.push(auxiliary.pop());
            }
            return result;
        }

        @Override
        public boolean isEmpty() {
            return original.isEmpty();
        }
    }

    public class QueueStackTwoStackOptimized implements QueueStack {

        Stack<Element> original = new Stack<>();
        Stack<Element> auxiliary = new Stack<>();

        @Override
        public void enqueue(Element e) {

            //If we had moved the elements of the original to auxiliary
            //offload them to original to revert to the initial state
            if (auxiliary.size() != 0) {

                while (!auxiliary.isEmpty()) {
                    original.push(auxiliary.pop());
                }
            }

            original.push(e);
        }

        @Override
        public Element dequeue() {

            //if we have already organized the original stacks element into
            //auxiliary, then everything is in the form of a stack right now,
            //so just return the top of the auxiliary stack
            if (auxiliary.size() != 0) {
                return auxiliary.pop();
            }

            //offload all the elements of original to auxiliary
            while (!original.isEmpty()) {
                auxiliary.push(original.pop());
            }

            Element result = auxiliary.pop();
            return result;
        }

        @Override
        public boolean isEmpty() {
            return (original.size() + auxiliary.size() == 0);
        }
    }

    public QueueStack getQueueStackTwoStack() {
        return new QueueStackTwoStack();
    }

    public QueueStack getQueueStackTwoStackOptimized() {
        return new QueueStackTwoStackOptimized();
    }

    public QueueStack getQueueStackCustom() {
        return new QueueStackCustom();
    }

    public QueueStack getQueueStackCustomOptimized() {
        return new QueueStackCustomOptimized();
    }
}
