package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */

/**
 *Imagine that you can only create arrays of fixed size.
 *Implement a Dynamic Array data structure that gives its user the perception
 *that it has a flexible size.
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=5
 */

public class Problem5 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    /**
     * To add your custom solution, replace the code in all the public methods
     * with your own code.
     */
    
    private static final int INIT_SIZE = 4;
    private Element[] array;
    private int expansionPoint = INIT_SIZE  - 1;
    private int shrinkagePoint = INIT_SIZE / 2 - 1;
    private int lastIndex = -1;

    public Problem5() {
        //we setup the array with initial size
        //if this was a real world code we would have probably set it
        //to a much large value
        array = new Element[INIT_SIZE];
    }


    /**
     * Inserts element to the end of the array
     */
    public void insert(Element e) {

        if (e == null) throw new IllegalArgumentException();
        lastIndex++;
        array[lastIndex] = e;

        //expand the array if we have reached the expansion point
        if (lastIndex == expansionPoint) {

            Element[] replacement = new Element[2 * (expansionPoint + 1)];
            //copy the original elements
            for (int i = 0; i < array.length; i++) {
                replacement[i] = array[i];
            }
            expansionPoint = (2 * (expansionPoint + 1)) - 1;
            array = replacement;
        }
    }

    /**
     * Deletes the element at index i, throws out of bound exception
     * if index is invalid
     */
    public void delete(int i) {
        if (i > lastIndex) throw new IndexOutOfBoundsException();
        //don't need to delete the last item just point the last index
        //one index behind
        for (int j = i; j < lastIndex; j++) {
            array[j] = array[j + 1];
        }
        lastIndex--;

        //shrink if needed
        if (lastIndex == shrinkagePoint &&
                shrinkagePoint != 1) {
            Element[] replacement = new Element[(shrinkagePoint + 1) / 2];
            for (int j = 0 ; j < lastIndex; j++) {
                replacement[j] = array[j];
            }
            shrinkagePoint = ((shrinkagePoint + 1) / 2) - 1;
            array = replacement;
        }
    }


    /**
     * Returns the element at index i. throws out of bound exception
     * if index is invalid
     */
    public Element get(int i) {
        return array[i];
    }

    public int length() {
        return lastIndex + 1;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i = 0 ; i <= lastIndex; i ++) {
            builder.append(array[i].getValue());
            if (i != lastIndex) {
                builder.append(", ");
            }
        }
        builder.append(" ]");
        return builder.toString();
    }

}
