package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;

/**
 * Created by Fathalian on 8/2/14.
 * HackerGym.com
 */
public class LongestIncreasing {

    public Pair<Integer, Integer> getLongestIncreasingRollingBest(int[] array) {

        Pair<Integer, Integer> globalLongestIncreasing = new Pair<>(0, 0);
        Pair<Integer, Integer> longestIncreasingSoFar = new Pair<>(0, 0);

        for (int i = 1; i < array.length; i++) {

            //if we can increase the longestIncreasingSoFar,
            //it's a no brainer that we should do it
            if (array[i - 1] <= array[i]) {
                longestIncreasingSoFar.snd = i;

                //check to see if we are doing better than the global maximum
                int globalLength = globalLongestIncreasing.snd - globalLongestIncreasing.fst + 1;
                int soFarLength = longestIncreasingSoFar.snd - longestIncreasingSoFar.fst + 1;
                if (soFarLength > globalLength) {
                    globalLongestIncreasing.fst = longestIncreasingSoFar.fst;
                    globalLongestIncreasing.snd = longestIncreasingSoFar.snd;
                }
            }
            //if we can't add the current element, then
            //we need to start a new longIncreasingSoFar starting
            //at the element
            else {
                longestIncreasingSoFar = new Pair<>(i, i);
            }
        }
        return globalLongestIncreasing;
    }

    public Pair<Integer, Integer> getLongestIncreasingOptimized(int[] array) {

        Pair<Integer, Integer> globalLongestIncreasing = new Pair<>(0, 0);
        Pair<Integer, Integer> longestIncreasingSoFar = new Pair<>(0, 0);

        int i = 1;
        while (i < array.length) {

            if (array[i - 1] <= array[i]) {
                longestIncreasingSoFar.snd = i;

                int globalLength = globalLongestIncreasing.snd - globalLongestIncreasing.fst ;
                int soFarLength = longestIncreasingSoFar.snd - longestIncreasingSoFar.fst ;
                if (soFarLength > globalLength) {
                    globalLongestIncreasing.fst = longestIncreasingSoFar.fst;
                    globalLongestIncreasing.snd = longestIncreasingSoFar.snd;
                }
                i++;
            } else {
                longestIncreasingSoFar = new Pair<>(i, i);

                //here is the actual optimization
                int globalLength = globalLongestIncreasing.snd - globalLongestIncreasing.fst ;
                int possibleEnd = i + globalLength;

                //there is no hope that we will get a longer sub array than global
                if (possibleEnd > array.length) {
                    return globalLongestIncreasing;
                }

                //if the sub array from (i, possibleEnd) is
                //a valid sub array of length L.
                //Then each element must follow the increasing order
                //go from the end to the beginning and verify that
                int j = possibleEnd;
                boolean isValid = true;

                while(j-1 > i) {
                    if(array[j-1] > array[j]) {
                        //we should start
                        i++;
                        isValid = false;
                        break;
                    }
                    j--;
                }

                if(isValid) {
                    globalLongestIncreasing.fst = i;
                    globalLongestIncreasing.snd = globalLength + i;
                    longestIncreasingSoFar.fst = i;
                    longestIncreasingSoFar.snd = globalLength + i;
                    i++;
                }
            }
        }
        return globalLongestIncreasing;

    }
}
