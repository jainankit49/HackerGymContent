package com.hackergym.samples.array.questions;

import java.util.Arrays;

/**
 * Created by Fathalian on 8/2/14.
 * HackerGym.com
 */
public class Deleter {

    public String[] deleteWithMemory(String[] array, String delValue) {

        //first calculate the size of the reduced array
        int count = 0;
        for(int i = 0 ; i < array.length; i++) {
            if(array[i].equals(delValue)) {
                count++;
            }
        }

        //now create an appropriate size array
        String[] result = new String[array.length - count];

        //go through the elements of the array one by one and copy them
        //if they are not to be deleted
        int resultIndex = 0;
        for(int i = 0 ; i < array.length; i++) {
            if (!array[i].equals(delValue)) {
                result[resultIndex] = array[i];
                resultIndex++;
            }
        }

        return result;
    }

    public String[] deleteWithoutMemory(String[] array, String delValue) {

        int current = 0;
        int candidate = 0;

        while(candidate < array.length) {

            //first move to the first candidate (the first non deletable element)
            while(array[candidate].equals(delValue)) {
                candidate++;
                //break when we first hit out of bounds
                if(candidate >= array.length) {
                    break;
                }
            }

            //break when we first hit out of bounds
            if (candidate >= array.length) {
                break;
            }

            //check if the element current points to needs to be deleted
            if (array[current].equals(delValue)) {
                String temp = array[current];
                array[current] = array[candidate];
                array[candidate] = temp;
            }

            //now move the two pointers for the next step
            candidate++;
            current++;

        }

        //we have reached the array we need to return the sub array
        //starting from 0 and ending at current
        //this is technically, a little bit of extra memory, there are tricks
        //you can do in java to remove this but for simplicity we just copy the
        //array. If this was c++ or c we could have easily achieved the splice operation
       return Arrays.copyOfRange(array,0, current);

    }
}
