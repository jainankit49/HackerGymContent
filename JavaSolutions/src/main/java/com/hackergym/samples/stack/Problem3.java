package com.hackergym.samples.stack;

import java.util.Stack;

/**
 * Created by Fathalian on 9/8/14.
 * HackerGym.com
 */
public class Problem3 {

    public void solveHanoiCustom(
            Stack<Integer> source,
            Stack<Integer> target,
            Stack<Integer> helper) {
        solveHanoi(source, target, helper);

    }

    /**
     *  Moves the elements from source to target using helper
     */
    public void solveHanoi(
            Stack<Integer> source,
            Stack<Integer> target,
            Stack<Integer> helper) {

        if (source.isEmpty()) return;
        solveHanoiRecursively(source.size(), source, target, helper);

    }

    private void solveHanoiRecursively(int elementsToMoveCount,
                                       Stack<Integer> source,
                                       Stack<Integer>target,
                                       Stack<Integer>helper) {

        if(elementsToMoveCount == 1 &&
                (target.isEmpty() || target.peek() >= source.peek())) {
            target.push(source.pop());
            return;
        }

        //Move the top n-1 elements from Source to Helper using Target as a helper.
        solveHanoiRecursively(elementsToMoveCount - 1, source, helper, target);
        //Move the last element on Source to Target.
        solveHanoiRecursively(1, source, target, helper);
        //Move all the elements from Helper to Target using Source as a helper stack.
        solveHanoiRecursively(elementsToMoveCount - 1, helper, target, source);
    }
}
