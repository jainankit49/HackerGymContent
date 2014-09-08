package com.hackergym.samples.array.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 7/30/14.
 * HackerGym.com
 */

/**
 * You have a string that has extra spaces.
 * Write an algorithm to remove those whitespaces.
 *
 * For a more detailed solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=2
 */
public class Problem2Followup {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public String removeWhiteSpaceCustom(String s) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testWhitespaceCustom
        return removeWhiteSpaceExtraMemory(s);
    }

    public String removeWhiteSpaceInPlace(String s) {

        char[] chars = s.toCharArray();

        //first iterate over the elements and select the ones that
        //need to be deleted
        Set<Integer> toBeDeleted = findExtraSpaces(chars);


        //follow the same approach as delete but look into the
        //toBeDeleted set to determine if something needs to be deleted
        int current = 0;
        int candidate = 0;

        while (candidate < chars.length) {

            //first move to the candidate (the first non deletable element)
            while (candidate < chars.length &&
                    toBeDeleted.contains(candidate)) {
                candidate++;
            }

            //break when we first hit out of bounds
            if (candidate >= chars.length) {
                break;
            }

            //check if the currentElement needs to be deleted
            if (toBeDeleted.contains(current)) {
                char temp = chars[current];
                chars[current] = chars[candidate];
                chars[candidate] = temp;
                toBeDeleted.add(candidate);
            }

            candidate++;
            current++;
        }

        return String.valueOf(Arrays.copyOfRange(chars, 0, current));
    }

    public Set<Integer> findExtraSpaces(char[] chars) {

        Set<Integer> toBeDeleted = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (i == 0) {
                    toBeDeleted.add(i);
                } else if (chars[i - 1] == ' ') {
                    toBeDeleted.add(i);
                }

                if (i == chars.length - 1) {
                    int j = i;
                    while (j > 0 && chars[j] == ' ') {
                        toBeDeleted.add(j);
                        j--;
                    }
                }
            }
        }
        return toBeDeleted;
    }

    public String removeWhiteSpaceExtraMemory(String s) {

        char[] chars = s.toCharArray();

        //first find the number of extra whitespaces
        int extraWhitespaceCount = 0;
        int currentIndex = 0;

        while (currentIndex < chars.length) {
            if (chars[currentIndex] == ' ') {
                //see if there are following spaces and remove them
                int j = currentIndex + 1;
                while (j < chars.length &&
                        chars[j] == ' ') {

                    extraWhitespaceCount++;
                    j++;

                }
                if (currentIndex == 0 || j == chars.length) {
                    extraWhitespaceCount++;
                }
                currentIndex = j;
            } else {
                currentIndex++;
            }
        }

        //now build an appropriate sized array
        char[] resultArray = new char[chars.length - extraWhitespaceCount];

        //now copy elements from the first array while skipping over extra whitespaces
        int resultIndex = 0;
        for (int i = 0; i < chars.length; i++) {

            int skipWhitespaces = 0;
            if (chars[i] == ' ') {
                int j = i + 1;
                while (j < chars.length &&
                        chars[j] == ' ') {

                    skipWhitespaces++;
                    j++;

                }
                //if we are dealing with whitespaces at the beginning and end
                //everything should be considered whitespace
                if (i != 0 && j != chars.length) {
                    resultArray[resultIndex] = chars[i];
                    resultIndex++;
                }
                i = i + skipWhitespaces;

            } else {
                resultArray[resultIndex] = chars[i];
                resultIndex++;
            }
        }

        return String.valueOf(resultArray);

    }
}
