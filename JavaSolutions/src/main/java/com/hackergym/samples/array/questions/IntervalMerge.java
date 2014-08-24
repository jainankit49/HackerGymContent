package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;

import java.util.List;

/**
 * Created by Fathalian on 7/31/14.
 * HackerGym.com
 */
public class IntervalMerge {

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
