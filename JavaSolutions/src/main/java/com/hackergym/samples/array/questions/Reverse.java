package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */
public class Reverse {

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
