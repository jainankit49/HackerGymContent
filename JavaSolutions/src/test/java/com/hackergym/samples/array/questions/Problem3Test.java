package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem3Test {

    Problem3 shifter = new Problem3();

    @Test
    public void testShiftWithExtraMemory() throws Exception {


        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("3", "4", "5", "1", "2");

        Element[] result = shifter.shiftWithExtraMemory(array, 3);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }


    @Test
    public void testShiftWithExtraMemoryZeroShift() throws Exception {
        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5");

        Element[] result = shifter.shiftWithExtraMemory(array, 0);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }

    }

    @Test
    public void testShiftWithExtraMemoryBigShift() throws Exception {

        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("4", "5", "1", "2", "3");

        Element[] result = shifter.shiftWithExtraMemory(array, 12);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }

    @Test
    public void testShiftWithRotate() throws Exception {
        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("3", "4", "5", "1", "2");

        Element[] result = shifter.shiftWithRotate(array, 3);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }

    @Test
    public void testShiftWithRotateZeroShift() throws Exception {
        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5");

        Element[] result = shifter.shiftWithRotate(array, 0);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }

    @Test
    public void testShiftWithRotateBigShift() throws Exception {
        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("4", "5", "1", "2", "3");

        Element[] result = shifter.shiftWithRotate(array, 12);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }

    @Test
    public void testShiftCustom() throws Exception {


        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("3", "4", "5", "1", "2");

        Element[] result = shifter.shiftCustom(array, 3);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }


    @Test
    public void testShiftCustomZeroShift() throws Exception {
        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5");

        Element[] result = shifter.shiftCustom(array, 0);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }

    }

    @Test
    public void testShiftCustomMemoryBigShift() throws Exception {

        Element[] array =
                elementArrayFromtStringArray(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> expectedResult = Arrays.asList("4", "5", "1", "2", "3");

        Element[] result = shifter.shiftCustom(array, 12);

        assertThat(result.length, is(expectedResult.size()));
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getValue(), is(expectedResult.get(i)));
        }
    }

    private Element[] elementArrayFromtStringArray(List<String> strings) {

        Element[] result = new Element[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            result[i] = new Element(strings.get(i));
        }
        return result;
    }

}