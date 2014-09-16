package com.hackergym.samples.stack;

import java.util.Stack;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

/**
 * Implement an algorithm that reverses a stack.
 * Your algorithm should not explicitly use any other data structure
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/a7f47520-3945-11e4-916c-0800200c9a66?p=8
 */
public class Problem8 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public Stack<String> reverseCustom(Stack<String> stack) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testReverseCustom
        return reverseRecursively(stack);
    }

    public Stack<String> reverseRecursively(Stack<String> stack) {

        if (stack.size() == 1) {
            return stack;
        }

        String top = stack.pop();
        stack = reverseRecursively(stack);
        pushAtBottom(stack, top);

        return stack;
    }

    private Stack<String> pushAtBottom(Stack<String> stack, String element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return stack;
        }

        String top = stack.pop();
        pushAtBottom(stack, element);
        stack.push(top);

        return stack;
    }
}
