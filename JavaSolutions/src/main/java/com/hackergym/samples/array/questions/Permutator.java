package com.hackergym.samples.array.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 8/6/14.
 * HackerGym.com
 */
public class Permutator {

    public char[] permutate(char[] input, int[] perm) {


        //first we check for validity of the permutation array

        //1- If the permutation is valid, then it must have the exact
        // same length as the input
        if (perm.length != input.length) throw new IllegalArgumentException();

        //2-if there are duplicate elements , then the perm array is invalid
        Set<Integer> duplicateChecker = new HashSet<>();
        for (int i = 0; i < perm.length; i++) {
            if (duplicateChecker.contains(perm[i])) throw new IllegalArgumentException();
            duplicateChecker.add(perm[i]);
        }

        //now we setup the main loop

        //we use checked Indexes to take account of the elements
        //we have visited during a cycle
        Set<Integer> checkedIndexes = new HashSet<>();

        for (int i = 0; i < perm.length; i++) {
            //elements of a valid permutation should be between 0 to input.length - 1
            //there should also be no duplicates in perm.
            //we use duplicateChecker hash set to detect those duplicates
            if (perm[i] >= input.length) {
                throw new IllegalArgumentException();
            }

            //if we haven't gone over this index of perm as a part of the
            //past cycle, then process the cycle that this index is involved in
            if (!checkedIndexes.contains(i)) {

                int nextIndex = i;
                char currentChar = input[i];
                do {
                    checkedIndexes.add(nextIndex);

                    //swap the elements and save the char
                    //to be moved to its final position
                    nextIndex = perm[nextIndex];
                    char temp = input[nextIndex];
                    input[nextIndex] = currentChar;
                    currentChar = temp;

                } while (nextIndex != i);
            }
        }
        //error check for perm
        return input;
    }
}
