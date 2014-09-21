package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/1/14.
 * HackerGym.com
 */

/**
 * Given a sorted array of distinct numbers, find an index i at which a[i] = i.
 * Your solution must be better than O(n).
 *
 * For more detailed solution see:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=14
 */

public class Problem14 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int findMagicIndexCustom(int[] array) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindMagicIndexCustom
        return findMagicIndex(array);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int findMagicIndexWithDuplicatesCustom(int[] array) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindMagicIndexWithDuplicatesCustom
        return findMagicIndexWithDuplicates(array);
    }

    /*
    Returns -1, in case nothing is found
     */
    public int findMagicIndex(int[] array) {

        int start = 0;
        int end = array.length - 1;
        while(start >= 0 && end < array.length && start < end) {
            //for even elements middle be the element toward the right
            int middle = start + end + 1 / 2;
           if(array[middle] == middle)  {
               return middle;
           } else if (array[middle] < middle) {
               //search the right side
               start = middle + 1;
           } else {
               //search the left side
               end = middle - 1;
           }
        }
        return -1;
    }

    public int findMagicIndexWithDuplicates(int[] array) {

        int start = 0;
        int end = array.length - 1;
        return findMagicRecursively(start, end, array);
    }

    private int findMagicRecursively(int startIndex, int endIndex, int[] array) {

        if (startIndex < 0 || endIndex >= array.length || startIndex > endIndex) {
            return -1;
        }

        //for even elements middle be the element toward the right
        int middle = startIndex + endIndex + 1 / 2;
        if (array[middle] == middle) {
            return middle;
        }

        //search right side
        int rightIndexStart = Math.max(middle + 1, array[middle]);
        int result = findMagicRecursively(rightIndexStart, endIndex, array);
        if (result > -1) return result;

        //search left side
        //now search left
        int leftIndexEnd = Math.min(middle - 1, array[middle]);
        result = findMagicRecursively(startIndex, leftIndexEnd, array);

        return result;
    }
}
