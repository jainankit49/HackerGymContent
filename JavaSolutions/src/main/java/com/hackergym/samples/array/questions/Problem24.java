package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/8/14.
 * HackerGym.com
 */

/**
 * Imagine you have an n x n matrix of numbers.
 * Write an algorithm to print the Matrix in a spiral order.
 *
 * More detailed solution see:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=24
 */
public class Problem24 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public String traverseSpiralCustom(int[][] matrix) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testTraverseSpiralCustom
        return traverseSpiral(matrix);
    }

    public String traverseSpiral(int[][] matrix) {

        int layerLength = matrix.length;

        //the matrix should have the same number of rows and columns
        if (matrix.length != matrix[0].length) throw new IllegalArgumentException();

        //handle the edge case of a 1x1 matrix here
        if (matrix.length == 1) return String.valueOf(matrix[0][0]) ;

        StringBuilder result = new StringBuilder();
        int row = 0;
        int col = 0;
        while(layerLength >= 0) {

            //print layerLength - 1 elements from left to right
            for(int i = 0; i < layerLength - 1; i++) {
                result.append(matrix[row][col]);
                result.append("-");
                col++;
            }

            //print layerLength - 1 elements from top to bottom
            for(int i = 0 ; i < layerLength - 1; i++) {
                result.append(matrix[row][col]);
                result.append("-");
                row++;
            }

            //print layerLength - 1 elements from left to right
            for(int i = 0 ; i < layerLength - 1 ; i++) {
                result.append(matrix[row][col]);
                result.append("-");
                col--;
            }

            //print layerLength - 1 elements from bottom to top
            for(int i = 0 ; i < layerLength - 1; i++) {
                result.append(matrix[row][col]);
                result.append("-");
                row--;
            }

            //When we reach here, we are already back to the point we started
            //the iteration. To make sure that we traverse the matrix correctly
            //we need to come one element down and on element to the right.
            row++;
            col++;
            //at the end of each iteration, two rows one on the left and one on the right
            //have been processed. Similarly, two columns one on the top and one on the
            //bottom have been processed. For this reason, the length of the next layer
            //needs to be decreased by two.
            layerLength -= 2;
        }

        return result.toString();
    }
}
