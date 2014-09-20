package com.hackergym.samples.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem10Test {

    Problem10 solver = new Problem10();

    @Test
    public void testFindMedianCustom() throws Exception {

        Problem6.IntegerStream stream = getStream();
        int median = solver.findMedianCustom(stream);

        assertThat(median, is(12));

    }

    @Test
    public void testFindMedianHeap() throws Exception {

        Problem6.IntegerStream stream = getStream();
        int median = solver.findMedianHeap(stream);

        assertThat(median, is(12));
    }

    public class ListIntegerStream implements Problem6.IntegerStream {

        ArrayList<Integer> list = new ArrayList<>();

        public ListIntegerStream(List<Integer> list) {
            this.list.addAll(list);
        }

        @Override
        public Integer read() {
            Integer value = list.get(0);
            list.remove(0);
            return value;
        }

        @Override
        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    private Problem6.IntegerStream getStream() {


        return new ListIntegerStream(

                Arrays.asList(12, 10, 5, 15, 20, 2, 100, 14, 9, 7, 12, 13, 15, 1, 92, 1, 20, 19)
        );

    }
}