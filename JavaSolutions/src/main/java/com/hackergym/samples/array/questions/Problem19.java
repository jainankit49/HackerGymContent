package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;

import java.util.List;

/**
 * Created by Fathalian on 7/31/14.
 * HackerGym.com
 */

/**
 * Imagine you have an array of time intervals that are sorted based on the start time:
 * [ (1,5), (3,7), (8, 12), (11, 15), (14, 19), (30, 34) ]
 * Write an algorithm that merges the overlapping intervals without using any extra memory:
 * [ (1,7), (8, 19), (30, 34) ]
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=19
 */

public class Problem19 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public List<Pair<Integer, Integer>> mergeIntervalsCustom(List<Pair<Integer, Integer>> intervals) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testMergeIntervalsCustom
        return mergeIntervals(intervals);
    }

    //we represent an interval as a Pair object
    public List<Pair<Integer, Integer>> mergeIntervals(List<Pair<Integer, Integer>> intervals) {

        int readPtr = 0;
        int lastIndex = intervals.size();
        int nextPosition = 0;

        while (readPtr < lastIndex) {

            int currentStartTime = intervals.get(readPtr).fst;
            int currentEndTime = intervals.get(readPtr).snd;

            //Try to capture a mergeable chunk
            readPtr++;
            while (readPtr < lastIndex &&
                    currentEndTime > intervals.get(readPtr).fst) {

                currentEndTime = intervals.get(readPtr).snd;
                readPtr++;
            }

            //first set the new intervals
            Pair<Integer, Integer> newInterval = new Pair<>(currentStartTime, currentEndTime);

            intervals.set(nextPosition, newInterval);
            nextPosition++;

        }

        //slice the list to the end and return it
        return intervals.subList(0, nextPosition);
    }
}
