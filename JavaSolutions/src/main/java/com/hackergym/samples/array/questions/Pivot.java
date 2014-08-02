package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/1/14.
 * HackerGym.com
 */
public class Pivot {

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
