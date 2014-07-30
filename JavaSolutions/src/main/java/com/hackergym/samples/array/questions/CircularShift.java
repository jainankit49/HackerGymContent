package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */
public class CircularShift {

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
