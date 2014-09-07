package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem16Test {

    Problem16 increasing = new Problem16();

    @Test
    public void testGetLongestIncreasingRollingBest() throws Exception {

        //Arrange
        int[] elements = {5, 3, 4, 7, 2, 1, 10, 12, 19};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingRollingBest(elements);

        //Assert
        assertThat(result.fst, is(5));
        assertThat(result.snd, is(8));
    }

    @Test
    public void testGetLongestIncreasingRollingUpAndDown() throws Exception {

        //Arrange
        int[] elements = {1, 0, 1, 0, 1, 0, 1, 0, 1};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingRollingBest(elements);

        //Assert
        assertThat(result.fst, is(1));
        assertThat(result.snd, is(2));
    }

    @Test
    public void testGetLongestIncreasingRollingWholeArray() throws Exception {

        //Arrange
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingRollingBest(elements);

        //Assert
        assertThat(result.fst, is(0));
        assertThat(result.snd, is(8));
    }


    @Test
    public void testGetLongestIncreasingOptimized() throws Exception {

        //Arrange
        int[] elements = {5, 3, 4, 7, 2, 1, 10, 12, 19};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingOptimized(elements);

        //Assert
        assertThat(result.fst, is(5));
        assertThat(result.snd, is(8));
    }

    @Test
    public void testGetLongestIncreasingOptimizedStartfromBeginning() throws Exception {

        //Arrange
        int[] elements = {1, 0, 1, 0, 1, 0, 1, 0, 1};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingOptimized(elements);

        //Assert
        assertThat(result.fst, is(7));
        assertThat(result.snd, is(8));
    }

    @Test
    public void testGetLongestIncreasingOptimizedUpAndDown() throws Exception {

        //Arrange
        int[] elements = {1, 2, 3, 3, 0, 1, 2, 0, 3};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingOptimized(elements);

        //Assert
        assertThat(result.fst, is(0));
        assertThat(result.snd, is(3));
    }

    @Test
    public void testGetLongestIncreasingOptimizedWholeArray() throws Exception {

        //Arrange
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingOptimized(elements);

        //Assert
        assertThat(result.fst, is(0));
        assertThat(result.snd, is(8));
    }

    @Test
    public void testGetLongestIncreasingCustom() throws Exception {

        //Arrange
        int[] elements = {5, 3, 4, 7, 2, 1, 10, 12, 19};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingCustom(elements);

        //Assert
        assertThat(result.fst, is(5));
        assertThat(result.snd, is(8));
    }

    @Test
    public void testGetLongestIncreasingCustomStartfromBeginning() throws Exception {

        //Arrange
        int[] elements = {1, 0, 1, 0, 1, 0, 1, 0, 1};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingCustom(elements);

        //Assert
        assertThat(result.fst, is(7));
        assertThat(result.snd, is(8));
    }

    @Test
    public void testGetLongestIncreasingCustomUpAndDown() throws Exception {

        //Arrange
        int[] elements = {1, 2, 3, 3, 0, 1, 2, 0, 3};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingCustom(elements);

        //Assert
        assertThat(result.fst, is(0));
        assertThat(result.snd, is(3));
    }

    @Test
    public void testGetLongestIncreasingCustomWholeArray() throws Exception {

        //Arrange
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Act
        Pair<Integer, Integer> result = increasing.getLongestIncreasingCustom(elements);

        //Assert
        assertThat(result.fst, is(0));
        assertThat(result.snd, is(8));
    }
}