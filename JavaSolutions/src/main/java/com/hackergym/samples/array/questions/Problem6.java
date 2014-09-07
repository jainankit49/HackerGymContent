package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */

/**
 * Write code to reverse an array.
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=6
 */

public class Problem6 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public Element[] reverseCustom(Element[] array) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testReverseCustom
        return reverseWithMemory(array);
    }

    public Element[] reverseWithMemory(Element[] array) {

        Element[] result = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }

        return result;
    }

    public Element[] reverseWithoutMemory(Element[] array) {

        int start = 0;
        int end = array.length - 1;
        //for even size number of elements start will never meet end
        //and will get ahead of it so we use this check instead of
        //checking when they meet
        while (start <= end) {
            Element temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
}
