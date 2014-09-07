package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem19Test {

    Problem19 merger = new Problem19();

    @Test
    public void testMergeIntervals() throws Exception {

        //Arrange
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<Integer, Integer>(1, 5),
                new Pair<Integer, Integer>(3, 7),
                new Pair<Integer, Integer>(8, 12),
                new Pair<Integer, Integer>(11, 15),
                new Pair<Integer, Integer>(14, 19),
                new Pair<Integer, Integer>(30, 34)
        );

        List<Pair<Integer, Integer>> expectedResult = Arrays.asList(
                new Pair<Integer, Integer>(1, 7),
                new Pair<Integer, Integer>(8, 19),
                new Pair<Integer, Integer>(30, 34)
                );
        //Act
        List<Pair<Integer, Integer>> result = merger.mergeIntervals(intervals);

        //Assert
        assertThat(result.size(), is(expectedResult.size()));
        for(int i = 0 ; i < result.size(); i++) {
            assertThat(result.get(i), is(expectedResult.get(i)));
        }
    }

    @Test
    public void testMergeIntervalsNonOverlapping() {

        //Arrange
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<Integer, Integer>(1, 5),
                new Pair<Integer, Integer>(6, 9),
                new Pair<Integer, Integer>(10, 12)
        );

        //Act
        List<Pair<Integer, Integer>> result = merger.mergeIntervals(intervals);

        assertThat(result.size(), is(intervals.size()));
        for(int i = 0 ; i < result.size(); i++) {
            assertThat(result.get(i), is(intervals.get(i)));
        }
    }

    @Test
    public void testMergeIntervalsAllOverlapping() {

        //Arrange
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<Integer, Integer>(1, 5),
                new Pair<Integer, Integer>(3, 9),
                new Pair<Integer, Integer>(5, 12),
                new Pair<Integer, Integer>(8, 15)
        );

        //Act
        //Act
        List<Pair<Integer, Integer>> result = merger.mergeIntervals(intervals);

        //Assert
        assertThat(result.size(), is(1));
        assertThat(result.get(0), is(new Pair<Integer, Integer>(1, 15)));
    }

    @Test
    public void testMergeIntervalsCustom() throws Exception {

        //Arrange
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<Integer, Integer>(1, 5),
                new Pair<Integer, Integer>(3, 7),
                new Pair<Integer, Integer>(8, 12),
                new Pair<Integer, Integer>(11, 15),
                new Pair<Integer, Integer>(14, 19),
                new Pair<Integer, Integer>(30, 34)
        );

        List<Pair<Integer, Integer>> expectedResult = Arrays.asList(
                new Pair<Integer, Integer>(1, 7),
                new Pair<Integer, Integer>(8, 19),
                new Pair<Integer, Integer>(30, 34)
        );
        //Act
        List<Pair<Integer, Integer>> result = merger.mergeIntervalsCustom(intervals);

        //Assert
        assertThat(result.size(), is(expectedResult.size()));
        for(int i = 0 ; i < result.size(); i++) {
            assertThat(result.get(i), is(expectedResult.get(i)));
        }
    }

    @Test
    public void testMergeIntervalsCustomNonOverlapping() {

        //Arrange
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<Integer, Integer>(1, 5),
                new Pair<Integer, Integer>(6, 9),
                new Pair<Integer, Integer>(10, 12)
        );

        //Act
        List<Pair<Integer, Integer>> result = merger.mergeIntervalsCustom(intervals);

        assertThat(result.size(), is(intervals.size()));
        for(int i = 0 ; i < result.size(); i++) {
            assertThat(result.get(i), is(intervals.get(i)));
        }
    }

    @Test
    public void testMergeIntervalsCustomAllOverlapping() {

        //Arrange
        List<Pair<Integer, Integer>> intervals = Arrays.asList(
                new Pair<Integer, Integer>(1, 5),
                new Pair<Integer, Integer>(3, 9),
                new Pair<Integer, Integer>(5, 12),
                new Pair<Integer, Integer>(8, 15)
        );

        //Act
        List<Pair<Integer, Integer>> result = merger.mergeIntervalsCustom(intervals);

        //Assert
        assertThat(result.size(), is(1));
        assertThat(result.get(0), is(new Pair<Integer, Integer>(1, 15)));
    }
}