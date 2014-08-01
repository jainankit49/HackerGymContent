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

        int beginning = 0;
        //this may look like a o(n^2) but it's not.
        //we will only move through every element once
        int lastIndex = intervals.size();
        while (beginning < lastIndex) {
            int end = beginning;
            int leftItem = intervals.get(beginning).fst;
            int rightItem = intervals.get(beginning).snd;
            //move the end index to the last element that falls into the interval
            while (end + 1 < lastIndex &&
                    intervals.get(end + 1).fst >= leftItem &&
                    intervals.get(end+ 1).fst <= rightItem) {
                end++;
                rightItem = intervals.get(end).snd;
            }

            //there was nothing to merge move to the next index
            if (beginning != end) {

                //first set the new intervals
                Pair<Integer, Integer> newInterval = new Pair<>(
                        intervals.get(beginning).fst,
                        intervals.get(end).snd);

                intervals.set(beginning, newInterval);

                //shift all the elements to the left to delete the extra intervals
                //that were merged
                int intervalLength = end - beginning;
                int i = beginning + 1;
                while (i + intervalLength < lastIndex) {
                    intervals.set(i, intervals.get(i + intervalLength));
                    i++;
                }



                //adjust the new end for the array
                lastIndex -= intervalLength ;
            }

            beginning++;
        }

        //slice the list to the end and return it
        return intervals.subList(0, lastIndex);
    }
}
