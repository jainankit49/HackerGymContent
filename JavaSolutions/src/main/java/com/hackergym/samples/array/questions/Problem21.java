package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Fathalian on 8/7/14.
 * HackerGym.com
 */

/**
 * In this problem, we are going to implement the fill function of a paint program.
 * Imagine a two dimensional array representing the screen.
 * The element at the i-th row and j-th column is represented by s[i][j] and is
 * set to true if the corresponding cell on the screen has a color.
 * Given a cell, s[i][j], color the area that bounds that point.
 *
 * For more detailed solution see:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=21
 */

public class Problem21 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public boolean[][] paintCustom(boolean[][] screen,
                                   int startRow,
                                   int startCol) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testPainCustom
        return paintRecursive(screen, startRow, startCol);
    }

    public boolean[][] paintRecursive(boolean[][] screen,
                                      int startRow,
                                      int startCol) {

        if (screen.length == 0 ||
                startRow >= screen.length ||
                startCol >= screen[0].length) {
            throw new IllegalArgumentException();
        }


        recursivePaint(screen, startRow, startCol);
        return screen;
    }

    public void recursivePaint(boolean[][] screen,
                                int startRow,
                                int startCol) {


        if (startRow < 0 ||
                startRow >= screen.length ||
                startCol < 0 ||
                startCol >= screen[0].length) {
            return;
        }
        if (screen[startRow][startCol] == true) return;

        screen[startRow][startCol] = true;
        recursivePaint(screen, startRow + 1, startCol);
        recursivePaint(screen, startRow - 1, startCol);
        recursivePaint(screen, startRow, startCol + 1);
        recursivePaint(screen, startRow, startCol - 1);
    }

    public boolean[][] paintQueue(boolean[][] screen,
                                  int startRow,
                                  int startCol) {

        if (screen.length == 0 ||
                startRow >= screen.length ||
                startCol >= screen[0].length) {
            throw new IllegalArgumentException();
        }

        //we use a pair object to hold a pair of <Row, Column>
        //We also use the java Deque data structure to represent our
        //queue. You can easily use any array for this purpose
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        //we only add elements that need to be painted to the queue
        if (screen[startRow][startCol] != true) {
            queue.addLast(new Pair<>(startRow, startCol));
        }

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.removeFirst();
            screen[cell.fst][cell.snd] = true;

            //top neighbor
            if (cell.fst -1 >= 0 &&
                    screen[cell.fst -1][cell.snd] == false) {
                queue.addLast(new Pair<>(cell.fst-1, cell.snd));
            }

            //bottom neighbor
            if (cell.fst + 1 < screen.length &&
                    screen[cell.fst + 1][cell.snd] == false) {
                queue.addLast(new Pair<>(cell.fst + 1, cell.snd));
            }

            //left neighbor
            if (cell.snd -1 >= 0 &&
                    screen[cell.fst][cell.snd -1] == false) {
                queue.addLast(new Pair<>(cell.fst, cell.snd -1));
            }

            //right neighbor
            if (cell.snd +1 < screen[0].length &&
                    screen[cell.fst][cell.snd + 1] == false) {
                queue.addLast(new Pair<>(cell.fst, cell.snd + 1));
            }
        }

        return screen;
    }
}
