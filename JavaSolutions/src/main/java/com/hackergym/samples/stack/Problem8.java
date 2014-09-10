package com.hackergym.samples.stack;

import java.util.Stack;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

/**
 *
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
