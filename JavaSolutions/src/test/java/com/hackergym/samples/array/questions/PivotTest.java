package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PivotTest {

    Pivot pivoter = new Pivot();
    @Test
    public void testPerformPivot() throws Exception {

        //arrange
        int[] array = {5 , 3 , 11, 2 , 8, 7, 9, 8, 1};

        //perform
        int[] result = pivoter.performPivot(array, 4);


        //Assert
        //Example Answer: {5, 3, 1, 2, 7, 8, 8, 9, 11}
        int i = 0;
        while(result[i] != 8) {
            assertThat(result[i] < 8, is(true));
            i++;
        }

        //assert that there are two eights in the middle
        assertThat(result[i], is(8));
        i++;
        assertThat(result[i], is(8));
        i++;

        //assert that the rest of the elements are bigger than 8
        while (i < result.length) {
            assertThat(result[i] > 8, is(true));
            i++;
        }

    }



    @Test
    public void testPerformPivotAllOnLeft() throws Exception {
        //arrange
        int[] array = {5 , 3 , 11, 2 , 8, 7, 9, 8, 1, 100};

        //perform
        int[] result = pivoter.performPivot(array, 9);

        //Assert
        //Example answer: {5, 3, 1, 2, 7, 8, 8, 9, 11, 100};
        int i = 0;
        while(result[i] != 100) {
            assertThat(result[i] < 100, is(true));
            i++;
        }

        //assert that there are two eights in the middle
        assertThat(result[i], is(100));
        assertThat(i, is(result.length - 1));
    }

    @Test
    public void testPerformPivotAllOnRight() throws Exception {

        //arrange
        int[] array = {1, 5 , 3 , 11, 2 , 8, 7, 9, 8, 2};

        //perform
        int[] result = pivoter.performPivot(array, 0);

        //Assert

        //assert that there are two eights in the middle
        assertThat(result[0], is(1));
        int i = 1;
        while(i < result.length ) {
            assertThat(result[i] > 1, is(true));
            i++;
        }

    }

    @Test
    public void testPerformPivotAlreadyPivoted() throws Exception {

        //arrange
        int[] array = {5 , 3 , 4, 11 , 12, 18, 13};

        //perform
        int[] result = pivoter.performPivot(array, 3);


        //Assert
        int i = 0;
        while(result[i] != 11) {
            assertThat(result[i] < 11, is(true));
            i++;
        }

        //assert that there are two eights in the middle
        assertThat(result[i], is(11));
        i++;
        //assert that the rest of the elements are bigger than 8
        while (i < result.length) {
            assertThat(result[i] > 11, is(true));
            i++;
        }
    }
}