package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/1/14.
 * HackerGym.com
 */
public class MagicIndex {

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
