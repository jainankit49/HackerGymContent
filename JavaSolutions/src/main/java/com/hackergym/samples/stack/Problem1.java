package com.hackergym.samples.stack;

/**
 * Created by Fathalian on 9/8/14.
 * HackerGym.com
 */

import com.hackergym.samples.model.Element;

import java.util.EmptyStackException;

/**
 * Implement k stacks using a single array.
 * <p/>
 * Each stack has a maximum size of X and throws an error
 * if an element is pushed into it when it is full.
 * Here are the functions you should implement:
 * <p/>
 * public void push(int stackIndex, Element value);
 * public Element pop(int stackIndex);
 * public boolean isEmpty(int stackIndex);
 *
 * For more detailed solution see:
 * http://hackergym.com/#!/problemView/a7f47520-3945-11e4-916c-0800200c9a66?p=1
 */
public class Problem1 {

    public interface KStack {
        public void push(int stackIndex, Element value);

        public Element pop(int stackIndex);

        public boolean isEmpty(int stackIndex);
    }
    /*============================================
    *                Your Custom Solution
    ============================================*/

    /**
     * Remove the delegate object and add your own code to
     * the public methods. Unit tests will be automatically run
     * against your code. All the unit tests will start with
     * testKStackCustomFixedSize.
     */
    public class KStackCustomFixedSize implements KStack {

        private int k;
        private int stackSize;

        //remove this for your custom solution
        private KStackFixedSize delegate;

        public KStackCustomFixedSize(int k, int stackSize) {

            this.k = k;
            this.stackSize = stackSize;
            this.delegate = new KStackFixedSize(k, stackSize);

        }

        public void push(int stackIndex, Element value) {
            delegate.push(stackIndex, value);
        }

        public Element pop(int stackIndex) {
            return delegate.pop(stackIndex);
        }

        public boolean isEmpty(int stackIndx) {
            return delegate.isEmpty(stackIndx);
        }
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/

    /**
     * Remove the delegate object and add your own code to
     * the public methods. Unit tests will be automatically run
     * against your code. All the unit tests will start with
     * testKStackCustomFlexibleSize.
     */
    public class KStackCustomFlexibleSize implements KStack {

        private int k;
        private int stackSize;
        //remove this for your custom solution
        private KStackFlexibleSize delegate;

        public KStackCustomFlexibleSize(int k, int stackSize) {

            this.k = k;
            this.stackSize = stackSize;
            this.delegate = new KStackFlexibleSize(k, stackSize);
        }

        public void push(int stackIndex, Element value) {
            delegate.push(stackIndex, value);
        }

        public Element pop(int stackIndex) {
            return delegate.pop(stackIndex);
        }

        public boolean isEmpty(int stackIndex) {
            return delegate.isEmpty(stackIndex);
        }
    }

    public class KStackFixedSize implements KStack {

        private int k;
        private int stackSize;
        private Element[] stacks;
        private int[] tops;

        public KStackFixedSize(int k, int stackSize) {

            this.k = k;
            this.stackSize = stackSize;
            stacks = new Element[k * stackSize];
            tops = new int[k];
            for (int i = 0; i < k; i++) {
                tops[i] = -1;
            }
        }

        public void push(int stackIndex, Element value) {

            if (stackIndex < 0 || stackIndex >= k) {
                throw new IndexOutOfBoundsException();
            }

            tops[stackIndex]++;
            if (tops[stackIndex] >= stackSize) throw new StackOverflowError();

            int index = stackIndex * stackSize + tops[stackIndex];
            stacks[index] = value;

        }

        public Element pop(int stackIndex) {

            if (stackIndex < 0 || stackIndex >= k) {
                throw new IndexOutOfBoundsException();
            }

            if (isEmpty(stackIndex)) throw new EmptyStackException();

            int index = stackIndex * stackSize + tops[stackIndex];
            Element poppedElement = stacks[index];
            tops[stackIndex]--;
            return poppedElement;
        }

        public boolean isEmpty(int stackIndex) {
            return tops[stackIndex] == -1;
        }

    }

    public class KStackFlexibleSize implements KStack {

        private int k;
        private int stackSize;
        private Element[] stacks;
        private long[] tops;
        private int[] sizes;

        public KStackFlexibleSize(int k, int stackSize) {

            this.k = k;
            this.stackSize = stackSize;
            stacks = new Element[k * stackSize];
            sizes = new int[k];
            tops = new long[k];
            for (int i = 0; i < k; i++) {
                tops[i] = -1;
                sizes[i] = 0;
            }
        }

        public void push(int stackIndex, Element value) {

            if (stackIndex < 0 || stackIndex >= k) {
                throw new IndexOutOfBoundsException();
            }

            tops[stackIndex]++;

            int index = (int) (stackIndex * stackSize + (tops[stackIndex] % stackSize));

            stacks[index] = value;
            if(sizes[stackIndex] < stackSize) {
                sizes[stackIndex]++;
            }
        }

        public Element pop(int stackIndex) {

            if (stackIndex < 0 || stackIndex >= k) {
                throw new IndexOutOfBoundsException();
            }

            if (isEmpty(stackIndex)) throw new EmptyStackException();

            int index = (int) (stackIndex * stackSize + (tops[stackIndex] % stackSize));
            Element poppedElement = stacks[index];
            tops[stackIndex]--;
            sizes[stackIndex]--;
            return poppedElement;
        }

        public boolean isEmpty(int stackIndex) {
            return sizes[stackIndex] == 0;
        }
    }

    public KStackFixedSize getFixedSizeStack(int k, int size) {
        return new KStackFixedSize(k, size);
    }

    public KStackFlexibleSize getFlexibleSizeStack(int k, int size) {
        return new KStackFlexibleSize(k, size);
    }

    public KStackCustomFixedSize getFixedSizeCustomStack(int k, int size) {
        return new KStackCustomFixedSize(k, size);
    }

    public KStackCustomFlexibleSize getFlexibleSizeCustomStack(int k, int size) {
        return new KStackCustomFlexibleSize(k, size);
    }
}
