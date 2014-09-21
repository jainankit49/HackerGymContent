package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/1/14.
 * HackerGym.com
 */

/**
 * Given an array of both positive and negative integers,
 * find a continuous sub array of it that contains the maximum sum.
 * Example: {1, -2, 3, 4}
 * The continuous sub-array with maximum sum is {3, 4}.
 * The sub-array {1, 3, 4} gives the most sum overall but is not continuous.
 * Note that an empty array is an acceptable answer and has a sum of zero.
 *
 * For more detailed solution see:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=13
 */
public class Problem13 {

    /**
     * You may design a better class for this.
     * Here for the sake of brevity we have chosen
     * to simulate a c like struct
     */
    public class SubarraySum {
        int startIndex;
        int endIndex;
        int sum;

        public SubarraySum(int startIndex, int endIndex, int sum) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.sum = sum;
        }
    }


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public SubarraySum findMaximumSubarrayCustom(int[] array) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindMaximumSubarrayCustom
        return findMaximumSubarrayEnumeration(array);
    }

    public SubarraySum findMaximumSubarrayEnumeration(int[] array) {

        //this indicates an empty array
        SubarraySum globalMaximum = new SubarraySum(0, -1, 0);

        for (int i = 0; i < array.length; i++) {
            //calculate all the possible subarray sums starting from i
            int ongoingSum = 0;
            for (int j = i; j < array.length; j++) {
                ongoingSum += array[j];
                if (ongoingSum >= globalMaximum.sum) {
                    globalMaximum = new SubarraySum(i, j, ongoingSum);
                }
            }
        }

        return globalMaximum;
    }

    public SubarraySum findMaximumSubarrayLinear(int[] array) {

        //we can define that a subarray with an index of negative is an empty array
        //not the best design, but will do the job
        SubarraySum currentMaxContinousSum = new SubarraySum(0, -1, 0);
        SubarraySum globalMaxContinousSum = new SubarraySum(0, -1, 0);

        for (int i = 0; i < array.length; i++) {
            if (array[i] + currentMaxContinousSum.sum >= 0) {
                currentMaxContinousSum.endIndex = i;
                currentMaxContinousSum.sum += array[i];
            } else {
                //we are going to skip over this element and start the
                //next currentMaxContinousSum from the next element
                currentMaxContinousSum = new SubarraySum(i+1, -1, 0);
            }

            if (currentMaxContinousSum.sum > globalMaxContinousSum.sum) {
                globalMaxContinousSum = new SubarraySum(
                        currentMaxContinousSum.startIndex,
                        currentMaxContinousSum.endIndex,
                        currentMaxContinousSum.sum);
            }
        }
        return globalMaxContinousSum;
    }
}
