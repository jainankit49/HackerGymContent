package com.hackergym.samples.array.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 8/6/14.
 * HackerGym.com
 */

/**
 * You have two arrays, A and P of size n.
 * Array A, contains arbitrary elements and P has all the indexes of A, arranged in an arbitrary order:
 * A = { a, b, c, d, e, f }
 * P = { 3, 0, 1, 2, 5, 4 }
 * We call P a permutation array for A.
 * Applying P to A causes each element of A to be mapped to a new position indicated
 * by the value of the corresponding P index.
 * In the example above, ‘a’ will be mapped to position 3 and ‘b’ to position 0:
 * P(A) = { b, c, d, a, f, e }
 * Write an algorithm that can apply a permutation to an array.
 * You cannot use additional memory to copy elements of the array but you may use
 * additional memory for book keeping purposes.
 *
 * For more detailed solution see:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=18
 */
public class Problem18 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public char[] permutateCustom(char[] input, int[] perm) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testPermutateCustom
        return permutate(input, perm);
    }

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
