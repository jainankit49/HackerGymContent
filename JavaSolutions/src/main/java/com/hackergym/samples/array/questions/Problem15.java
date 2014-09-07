package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/1/14.
 * HackerGym.com
 */

/**
 * Given an unsorted array of numbers and a pivot point index of x,
 * rearrange the array in a way that all elements smaller than a[x] come before index x
 * and all the elements larger than a[x] come after it.
 * Note that there could be duplicates in the array.
 * Your algorithm should run in O(1) memory.
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=15
 */
public class Problem15 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int[] performPivotCustom(int[] array, int pivotIndex) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testPerformPivotCustom
        return performPivot(array, pivotIndex);
    }

    public int[] performPivot(int[] array, int pivotIndex) {

        int smallers = 0;
        int equals = 0;
        int largers = array.length - 1;
        int pivotValue = array[pivotIndex];

        while (equals < largers) {
            //If an element is smaller pivot value, we swap it with equals we move
            // “smallers” and “equals” one step ahead.
            if (array[equals] < pivotValue) {
                int temp = array[smallers];
                array[smallers] = array[equals];
                array[equals] = temp;
                smallers++;
                equals++;
            }
            //If an element is equal to the pivot value, we move “equals”
            // one step forward and keep “smallers” and “largers” where they are
            else if (array[equals] == pivotValue) {
                equals++;
            }

            //If an element is larger than pivot , we swap it
            // with the “largers”,  and move largers one step backwards.
            else if (array[equals] > pivotValue) {
                int temp = array[equals];
                array[equals] = array[largers];
                array[largers] = temp;
                largers--;
            }
        }

        return array;
    }

}
