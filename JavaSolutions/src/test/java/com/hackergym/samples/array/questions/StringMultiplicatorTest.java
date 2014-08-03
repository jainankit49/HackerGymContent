package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringMultiplicatorTest {

    StringMultiplicator multiplicator = new StringMultiplicator();

    @Test
    public void testMultiplyDifferentSize() throws Exception {

        assertThat(multiplicator.multiply("912", "70"), is("63840"));
    }

    @Test
    public void testMultiplyOneMuchLarger() throws Exception {

        assertThat(multiplicator.multiply("91212352", "70"), is("6384864640"));

    }

    @Test
    public void testMultiplyEqualSize() throws Exception {

        assertThat(multiplicator.multiply("12", "30"), is("360"));
    }
}