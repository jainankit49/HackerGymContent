package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */

/**
 *A circular right shift of an array is a shift of elements forward in which the items that overflow from the end
 * are added to the beginning of the array.
 * For instance, applying a circular shift of 3 to array [1,2,3,4,5,6] gives you [4,5,6,1,2,3].
 * Write the algorithm to perform a circular shift on arrays of a given size.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=3
 */
public class Problem3 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public Element[] shiftCustom(Element[] array, int shiftCount) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testShiftCustom
        return shiftWithExtraMemory(array, shiftCount);
    }

    public Element[] shiftWithExtraMemory(Element[] array, int shiftCount) {

        //because the number of shifts could be bigger than the size of the array
        //we need to calculate an effective shift. Each shift of the size array.length
        //will cause the array to go back to its original state.
        //we can be more effective by skipping those complete shifts
        int effectiveShifts = shiftCount % array.length;

        //first copy the overflow items into an auxilary array
        Element[] overflowns = new Element[effectiveShifts];
        int overFlowIndex = 0;
        for (int i = array.length - effectiveShifts; i <= array.length - 1; i++) {
            overflowns[overFlowIndex] = array[i];
            overFlowIndex++;
        }

        //now shift the elements of the original array effectiveShift times
        //to the right
        //start from the end and shift items forward one by one
        for (int i = array.length - 1 - effectiveShifts; i >= 0; i--) {
            array[i + effectiveShifts] = array[i];
        }

        //finally place the overflown items at the beginning
        for (int i = 0; i < effectiveShifts; i++) {
            array[i] = overflowns[i];
        }

        return array;
    }

    public Element[] shiftWithRotate(Element[] array, int shiftCount) {

        //because the number of shifts could be bigger than the size of the array
        //we need to calculate an effective shift. Each shift of the size array.length
        //will cause the array to go back to its original state.
        //we can be more effective by skipping those complete shifts
        int effectiveShifts = shiftCount % array.length;

        //first revers the whole array
        array = reverse(0, array.length - 1, array);

        //now reverse the first effectiveShifts items
        array = reverse(0, effectiveShifts - 1, array);

        //now reverse the rest
        array = reverse(effectiveShifts, array.length - 1, array);

        return array;
    }

    private Element[] reverse(int fromIndex, int toIndex, Element[] array) {

        while (fromIndex <= toIndex) {
            Element temp = array[fromIndex];
            array[fromIndex] = array[toIndex];
            array[toIndex] = temp;
            fromIndex++;
            toIndex--;
        }

        return array;
    }
}
