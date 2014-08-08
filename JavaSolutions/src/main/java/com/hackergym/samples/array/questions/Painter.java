package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Fathalian on 8/7/14.
 * HackerGym.com
 */
public class Painter {

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
            Pair<Integer, Integer> point = queue.removeFirst();
            screen[point.fst][point.snd] = true;

            //top neighbor
            if (point.fst -1 >= 0 &&
                    screen[point.fst -1][point.snd] == false) {
                queue.addLast(new Pair<>(point.fst-1, point.snd));
            }

            //bottom neighbor
            if (point.fst + 1 < screen.length &&
                    screen[point.fst + 1][point.snd] == false) {
                queue.addLast(new Pair<>(point.fst + 1, point.snd));
            }

            //left neighbor
            if (point.snd -1 >= 0 &&
                    screen[point.fst][point.snd -1] == false) {
                queue.addLast(new Pair<>(point.fst, point.snd -1));
            }

            //right neighbor
            if (point.snd +1 < screen[0].length &&
                    screen[point.fst][point.snd + 1] == false) {
                queue.addLast(new Pair<>(point.fst, point.snd + 1));
            }
        }

        return screen;
    }
}
