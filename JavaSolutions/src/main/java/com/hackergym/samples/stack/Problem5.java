package com.hackergym.samples.stack;

import java.util.Stack;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

/**
 * Write an algorithm that sorts a stack in ascending order.
 * (Top of the stack is the smallest element in the stack).

 *You can only use stacks as data structures.
 */
public class Problem5 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public Stack<Integer> sortStackCustom(Stack<Integer> stack) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testSortStackCustom
        return sortStackTwoStacks(stack);
    }

    public Stack<Integer> sortStackThreeStacks(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()) {
            Integer max = popMaximum(stack, helper);
            result.push(max);
            //all the elements of stack except the min are now in helper
            //so swap these two stack
            Stack<Integer> temp = helper;
            helper = stack;
            stack = temp;
        }
        return result;
    }

    private Integer popMaximum(Stack<Integer> stack,
                               Stack<Integer> helper) {

        Integer maximum = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            Integer elem = stack.pop();
            if (elem >= maximum) {

                //another common pitfall is to insert the MIN_VALUE into
                //the helper
                if (maximum != Integer.MIN_VALUE) {
                    helper.push(maximum);
                }

                maximum = elem;
            } else {
                helper.push(elem);
            }
        }
        return maximum;

    }

    public Stack<Integer> sortStackTwoStacks(Stack<Integer> stack) {

        Stack<Integer> result = new Stack<>();

        while(!stack.isEmpty()) {

            Integer elem = stack.pop();
            //if the element on top of result is bigger than elem
            //then just push elem into result
            if (result.isEmpty() || result.peek() >= elem) {
                result.push(elem);
            }
            //if the element on top of result is smaller than elem
            //offload result into stack until the top of result becomes
            //bigger or equal to elem. Then push elem into result.
            else {
                while(!result.isEmpty() && result.peek() < elem) {
                    stack.push(result.pop());
                }

                result.push(elem);
            }
        }
        return result;
    }

}
