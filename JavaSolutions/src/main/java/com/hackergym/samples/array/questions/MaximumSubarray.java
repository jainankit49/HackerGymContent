package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/1/14.
 * HackerGym.com
 */
public class MaximumSubarray {

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
