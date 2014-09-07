package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem2Test {

    Problem2 problem2 = new Problem2();

    @Test
    public void testDeleteWithMemory() throws Exception {

        String[] a = {"4", "d", "d", "d", "11", "23", "d", "24"};
        String[] expectedResult = {"4", "11", "23", "24"};

        String[] result = problem2.deleteWithMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithMemoryMultipleBackToBack() throws Exception {

        String[] a = {"4", "d", "d", "d", "3"};
        String[] expectedResult = {"4", "3"};

        String[] result = problem2.deleteWithMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithMemoryMultipleAtTheEnd() throws Exception {
        String[] a = {"4", "d", "d", "d", "d"};
        String[] expectedResult = {"4"};

        String[] result = problem2.deleteWithMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }


    @Test
    public void testDeleteWithMemoryMultipleAtTheBeginning() throws Exception {

        String[] a = {"d", "d", "3", "4", "5"};
        String[] expectedResult = {"3", "4", "5"};

        String[] result = problem2.deleteWithMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }

    }

    @Test
    public void testDeleteWithMemoryMultipleNoElement() throws Exception {

        String[] a = {"5", "2", "3", "4", "5"};
        String[] expectedResult = {"5", "2", "3", "4", "5"};

        String[] result = problem2.deleteWithMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithoutMemory() throws Exception {

        String[] a = {"4", "d", "d", "d", "11", "23", "d", "24"};
        String[] expectedResult = {"4", "11", "23", "24"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithoutMemoryMultipleBackToBack() throws Exception {

        String[] a = {"4", "d", "d", "d", "3"};
        String[] expectedResult = {"4", "3"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithoutMemoryMultipleAtTheEnd() throws Exception {

        String[] a = {"4", "3", "d", "d", "d", "d"};
        String[] expectedResult = {"4", "3"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }

    }

    @Test
    public void testDeleteWithoutMemoryMultipleAtTheBeginning() throws Exception {

        String[] a = {"d", "d", "3", "4", "5"};
        String[] expectedResult = {"3", "4", "5"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }

    }

    @Test
    public void testDeleteWithoutMemorySingleAtTheBeginning() throws Exception {

        String[] a = {"d", "2", "3", "4", "5"};
        String[] expectedResult = {"2", "3", "4", "5"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }

    }
    @Test
    public void testDeleteWithoutMemorySingleInTheMiddle() throws Exception {

        String[] a = {"1", "2", "d", "4", "5"};
        String[] expectedResult = {"1", "2", "4", "5"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithoutMemoryNoElement() throws Exception {

        String[] a = {"5", "2", "3", "4", "5"};
        String[] expectedResult = {"5", "2", "3", "4", "5"};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteWithoutMemoryAllElements() throws Exception {

        String[] a = {"d", "d", "d", "d", "d"};
        String[] expectedResult = {};

        String[] result = problem2.deleteWithoutMemory(a, "d");

        assertThat(result.length, is(expectedResult.length));

    }

    @Test
    public void testDeleteCustom() throws Exception {

        String[] a = {"4", "d", "d", "d", "11", "23", "d", "24"};
        String[] expectedResult = {"4", "11", "23", "24"};

        String[] result = problem2.deleteCustom(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteCustomMultipleBackToBack() throws Exception {

        String[] a = {"4", "d", "d", "d", "3"};
        String[] expectedResult = {"4", "3"};

        String[] result = problem2.deleteCustom(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

    @Test
    public void testDeleteCustomMultipleAtTheEnd() throws Exception {
        String[] a = {"4", "d", "d", "d", "d"};
        String[] expectedResult = {"4"};

        String[] result = problem2.deleteCustom(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }


    @Test
    public void testDeleteCustomMultipleAtTheBeginning() throws Exception {

        String[] a = {"d", "d", "3", "4", "5"};
        String[] expectedResult = {"3", "4", "5"};

        String[] result = problem2.deleteCustom(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }

    }

    @Test
    public void testDeleteCustomMultipleNoElement() throws Exception {

        String[] a = {"5", "2", "3", "4", "5"};
        String[] expectedResult = {"5", "2", "3", "4", "5"};

        String[] result = problem2.deleteCustom(a, "d");

        assertThat(result.length, is(expectedResult.length));
        for (int i = 0; i < expectedResult.length; i++) {
            assertThat(result[i], is(expectedResult[i]));
        }
    }

}