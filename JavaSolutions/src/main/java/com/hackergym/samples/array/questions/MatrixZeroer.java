package com.hackergym.samples.array.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 7/30/14.
 * HackerGym.com
 */
public class MatrixZeroer {

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
