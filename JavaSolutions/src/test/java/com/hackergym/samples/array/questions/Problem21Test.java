package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem21Test {

    Problem21 painter = new Problem21();

    @Test
    public void testPaintRecursive() throws Exception {

        String[] screen =
                {
                        "--****---*-*",
                        "--*----****-",
                        "--*-------*-",
                        "--*-****----",
                        "--*-*--*---*",
                        "--*-*--****-",
                        "--*-*------*",
                        "--***-------",
                };

        String[] result =
                {
                        "--********-*",
                        "--**********",
                        "--**********",
                        "--**********",
                        "--***--*****",
                        "--***--****-",
                        "--***------*",
                        "--***-------",
                };


        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintRecursive(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));
    }

    @Test
    public void testPaintRecursiveEmpty() throws Exception {

        String[] screen =
                {
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                };

        String[] result =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintRecursive(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));

    }

    @Test
    public void testPaintRecursiveFull() throws Exception {

        String[] screen =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        String[] result =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintRecursive(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));

    }

    @Test
    public void testPaintQueue() throws Exception {

        String[] screen =
                {
                        "--****---*-*",
                        "--*----****-",
                        "--*-------*-",
                        "--*-****----",
                        "--*-*--*---*",
                        "--*-*--****-",
                        "--*-*------*",
                        "--***-------",
                };

        String[] result =
                {
                        "--********-*",
                        "--**********",
                        "--**********",
                        "--**********",
                        "--***--*****",
                        "--***--****-",
                        "--***------*",
                        "--***-------",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintQueue(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));
    }

    @Test
    public void testPaintQueueEmpty() throws Exception {

        String[] screen =
                {
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                };

        String[] result =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintQueue(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));

    }

    @Test
    public void testPaintQueueFull() throws Exception {

        String[] screen =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        String[] result =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintQueue(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));

    }

    @Test
    public void testPaintCustom() throws Exception {

        String[] screen =
                {
                        "--****---*-*",
                        "--*----****-",
                        "--*-------*-",
                        "--*-****----",
                        "--*-*--*---*",
                        "--*-*--****-",
                        "--*-*------*",
                        "--***-------",
                };

        String[] result =
                {
                        "--********-*",
                        "--**********",
                        "--**********",
                        "--**********",
                        "--***--*****",
                        "--***--****-",
                        "--***------*",
                        "--***-------",
                };


        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintCustom(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));
    }

    @Test
    public void testPaintCustomEmpty() throws Exception {

        String[] screen =
                {
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                        "------------",
                };

        String[] result =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintCustom(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));

    }

    @Test
    public void testPaintCustomFull() throws Exception {

        String[] screen =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        String[] result =
                {
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                        "************",
                };

        boolean[][] converted = convertString(screen);
        boolean[][] actual = painter.paintCustom(converted, 2, 6);

        String[] actualConverted = convertToString(actual);

        assertThat(actualConverted, is(result));

    }

    public boolean[][] convertString(String[] convert) {
        int rowSize = convert.length;
        int colSize = convert[0].length();
        boolean[][] result = new boolean[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            char[] rowChars = convert[row].toCharArray();
            for (int col = 0; col < colSize; col++) {
                result[row][col] = rowChars[col] == '-' ? false : true;
            }
        }
        return result;
    }

    public String[] convertToString(boolean[][] convert) {

        String[] result = new String[convert.length];
        for (int row = 0; row < convert.length; row++) {
            StringBuilder resultBuilder = new StringBuilder();
            for (int col = 0; col < convert[0].length; col++) {
                resultBuilder.append(convert[row][col] ? "*" : "-");
            }
            result[row] = resultBuilder.toString();
        }
        return result;
    }

    public void printScreen(String[] screen) {
        for (int i = 0; i < screen.length; i++) {
            System.out.println(screen[i]);
        }
    }

}