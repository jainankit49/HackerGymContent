package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem22Test {

    Problem22 converter = new Problem22();

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

    @Test
    public void testToStringCustom() throws Exception {
        assertThat(converter.toStringCustom(1691), is("1691"));
    }

    @Test
    public void testToStringCustomNegative() throws Exception {
        assertThat(converter.toStringCustom(-1691), is("-1691"));
    }

    @Test
    public void testToStringCustomAllZero() throws Exception {

        assertThat(converter.toStringCustom(0), is("0"));
    }

    @Test
    public void testFromStringCustom() throws Exception {

        assertThat(converter.fromStringCustom("1691"), is(1691));
    }

    @Test
    public void testFromStringCustomNegative() throws Exception {

        assertThat(converter.fromStringCustom("-1691"), is(-1691));
    }

    @Test
    public void testFromStringCustomAllZero() throws Exception {

        assertThat(converter.fromStringCustom("0"), is(0));
    }
}