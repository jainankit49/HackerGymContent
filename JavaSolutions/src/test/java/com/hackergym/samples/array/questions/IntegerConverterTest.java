package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntegerConverterTest {

    IntegerConverter converter = new IntegerConverter();

    @Test
    public void testToString() throws Exception {
        assertThat(converter.toString(1691), is("1691"));
    }

    @Test
    public void testToStringNegative() throws Exception {
        assertThat(converter.toString(-1691), is("-1691"));
    }

    @Test
    public void testToStringAllZero() throws Exception {

        assertThat(converter.toString(0), is("0"));
    }

    @Test
    public void testFromString() throws Exception {

        assertThat(converter.fromString("1691"), is(1691));
    }

    @Test
    public void testFromStringNegative() throws Exception {

        assertThat(converter.fromString("-1691"), is(-1691));
    }

    @Test
    public void testFromStringAllZero() throws Exception {

        assertThat(converter.fromString("0"), is(0));
    }
}