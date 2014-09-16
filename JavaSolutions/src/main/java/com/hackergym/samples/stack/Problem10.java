package com.hackergym.samples.stack;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

import java.util.Stack;

/**
 * You have a group of buildings that are built next to each other.
 * <p/>
 * Each building has the same width but the their height may be different.
 * <p/>
 * Given an array of building heights, calculate the area of the largest rectangle
 * that only contains buildings.
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/a7f47520-3945-11e4-916c-0800200c9a66?p=10
 */

public class Problem10 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int findMaxRectCustom(Integer[] heights) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testCalculateRPNStack
        return findMaxRect(heights);
    }

    public int findMaxRect(Integer[] heights) {

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int finalMax = 0;
        while (i < heights.length) {

            //Move through the heights and add building to the stack
            // while they are in the increasing order
            while (i < heights.length &&
                    (stack.isEmpty() || heights[i] >= heights[stack.peek()])) {
                stack.push(i);
                i++;
            }

            // If we haven't reached the end of heights
            // then we are at a building that has a height that is smaller
            // than top of the stack,
            // This is the smallerRight building for an increasing building heights
            // that end at the current op of the stack
            if (i < heights.length) {
                int smallerRight = i;
                int smallerRightValue = heights[i];
                // we now need to pop building off one by one until
                // we reach a building that has a smaller height
                // than smallerRight or the stack becomes empty
                while (!stack.isEmpty() && heights[stack.peek()] >= smallerRightValue) {
                    int currentHeight = heights[stack.pop()];
                    // Each time we pop a building y,
                    // the smallerLeft for y is the new top of the stack
                    // or -1 if the stack is empty.
                    // On the other hand, smallerRight for building y is
                    // the same smallerRight we found at the beginning 2.

                    int smallerLeft = stack.isEmpty() ? -1 : stack.peek();
                    // calculate the biggest rectangular area that contains y
                    // as the smallest building.
                    // This area is (smallerRight – smallerLeft - 1) * y.height. .
                    int currentMaxArea = (smallerRight - smallerLeft - 1) * currentHeight;

                    //If the calculated area is bigger than max, we replace max with the calculated area.
                    if (currentMaxArea >= finalMax) {
                        finalMax = currentMaxArea;
                    }
                }
            }

            // At the end of this iteration there might still be buildings
            // left inside the stack.
            // If at the end of the iteration, building x is at the top stack,
            // it means there is no building in front of it that is smaller than x.
            // For this building, we let smallerRight to be the end of the array plus one.
            // then we continue popping the stack
            int smallerRight = heights.length;
            while (!stack.isEmpty()) {

                int currentHeight = heights[stack.pop()];
                int smallerLeft = stack.isEmpty() ? -1 : stack.peek();
                int currentMaxArea = (smallerRight - smallerLeft - 1) * currentHeight;
                if (currentMaxArea >= finalMax) {
                    finalMax = currentMaxArea;
                }
            }
        }

        return finalMax;

    }

}
