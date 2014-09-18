package com.hackergym.samples.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem6Test {

    Problem6 solver = new Problem6();

    @Test
    public void testTopKCustom() throws Exception {

        //{100, 92, 20, 19, 15}
        Problem6.IntegerStream stream = getStream();
        List<Integer> actual = solver.topKCustom(5, stream);
        List<Integer> expected = Arrays.asList(19, 20, 20, 92, 100);

        assertThat(actual, is(expected));
    }

    @Test
    public void testTopK() throws Exception {

        Problem6.IntegerStream stream = getStream();
        List<Integer> actual = solver.topK(5, stream);
        List<Integer> expected = Arrays.asList(19, 20, 20, 92, 100);

        assertThat(actual, is(expected));
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

        //{100, 92, 20, 19, 15}
        return new ListIntegerStream(
                Arrays.asList(12, 10, 5, 15, 20, 2, 100, 14, 9, 7, 12, 13, 15, 1, 92, 1, 20, 19)
        );

    }

    private Problem6.IntegerStream getStreamRepeated() {

        return new ListIntegerStream(
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        );
    }
}