package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem8Test {

    Problem8 zeroer = new Problem8();

    @Test
    public void testZeroMatrix() throws Exception {
        List<Pair<Integer, Integer>> zeroElements = Arrays.asList(
                new Pair<>(0, 1),
                new Pair<>(2, 0));

        int size = 3;
        int[][] matrix = matrixWithZerosAt(size, zeroElements);
        matrix = zeroer.zeroMatrix(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == 2 || j == 1 || j == 0) {
                    assertThat(matrix[i][j], is(0));
                } else {
                    assertThat(matrix[i][j], not(0));
                }
            }
        }
    }

    @Test
    public void testZeroMatrixConsecutiveZeros() throws Exception {

        List<Pair<Integer, Integer>> zeroElements = Arrays.asList(
                new Pair<>(0, 1),
                new Pair<>(0, 2));

        int size = 3;
        int[][] matrix = matrixWithZerosAt(size, zeroElements);
        matrix = zeroer.zeroMatrix(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 1 || j == 2) {
                    assertThat(matrix[i][j], is(0));
                } else {
                    assertThat(matrix[i][j], not(0));
                }
            }
        }
    }

    @Test
    public void testZeroMatrixNoZeros() throws Exception {

        List<Pair<Integer, Integer>> zeroElements = Arrays.asList();

        int size = 3;
        int[][] matrix = matrixWithZerosAt(size, zeroElements);
        matrix = zeroer.zeroMatrix(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertThat(matrix[i][j], not(0));
            }
        }

    }

    @Test
    public void testZeroMatrixCustom() throws Exception {
        List<Pair<Integer, Integer>> zeroElements = Arrays.asList(
                new Pair<>(0, 1),
                new Pair<>(2, 0));

        int size = 3;
        int[][] matrix = matrixWithZerosAt(size, zeroElements);
        matrix = zeroer.zeroMatrixCustom(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == 2 || j == 1 || j == 0) {
                    assertThat(matrix[i][j], is(0));
                } else {
                    assertThat(matrix[i][j], not(0));
                }
            }
        }
    }

    @Test
    public void testZeroMatrixCustomConsecutiveZeros() throws Exception {

        List<Pair<Integer, Integer>> zeroElements = Arrays.asList(
                new Pair<>(0, 1),
                new Pair<>(0, 2));

        int size = 3;
        int[][] matrix = matrixWithZerosAt(size, zeroElements);
        matrix = zeroer.zeroMatrixCustom(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 1 || j == 2) {
                    assertThat(matrix[i][j], is(0));
                } else {
                    assertThat(matrix[i][j], not(0));
                }
            }
        }
    }

    @Test
    public void testZeroMatrixCustomNoZeros() throws Exception {

        List<Pair<Integer, Integer>> zeroElements = Arrays.asList();

        int size = 3;
        int[][] matrix = matrixWithZerosAt(size, zeroElements);
        matrix = zeroer.zeroMatrixCustom(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertThat(matrix[i][j], not(0));
            }
        }

    }

    private int[][] matrixWithZerosAt(int size, List<Pair<Integer, Integer>> zeros) {

        int[][] matix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matix[i][j] = 2 * i + 3 * j + 4;
            }
        }
        for (Pair<Integer, Integer> zeroIndex : zeros) {
            matix[zeroIndex.fst][zeroIndex.snd] = 0;
        }

        return matix;

    }
}