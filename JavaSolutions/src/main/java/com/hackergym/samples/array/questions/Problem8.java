package com.hackergym.samples.array.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 7/30/14.
 * HackerGym.com
 */

/**
 * A matrix is an array of arrays.
 * Given a matrix, write an algorithm that if the value of the i-th row and j-th column is zero,
 * it puts zero for the whole i-th row and the whole j-th column.
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=8
 */

public class Problem8 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int[][] zeroMatrixCustom(int[][] matrix) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testZeroMatrixCustom
        return zeroMatrix(matrix);
    }

    public int[][] zeroMatrix(int[][] matrix) {

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        //first detect the zeros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
              if (matrix[i][j] == 0) {
                  zeroRows.add(i);
                  zeroCols.add(j);
              }
            }
        }

        //now apply the zeroing
        for(Integer row : zeroRows) {
            for(int j = 0 ; j < matrix[row].length; j ++) {
                matrix[row][j] = 0;
            }
        }
        for(Integer col : zeroCols) {
            for(int i = 0 ; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        return matrix;
    }
}
