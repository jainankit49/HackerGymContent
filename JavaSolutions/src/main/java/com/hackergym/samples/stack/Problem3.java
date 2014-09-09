package com.hackergym.samples.stack;

import java.util.Stack;

/**
 * Created by Fathalian on 9/8/14.
 * HackerGym.com
 */

/**
 * In this problem we are going to solve the problem of “towers of Hanoi”.
 * You have three towers and N disks of different sizes.

 * Initially all the disks are sorted on the first tower.
 * The goal is to move all the disks in the same-sorted order to the third tower.
 * You have to follow these three rules at all time:

 * 1-	You can only move a single disk at a time.
 * 2-	You can only pick a disk from the top of a tower.
 * 3-	Disks can only be placed on top of larger disks.


 */
public class Problem3 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public void solveHanoiCustom(
            Stack<Integer> source,
            Stack<Integer> target,
            Stack<Integer> helper) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testSolveHanoiCustom
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
