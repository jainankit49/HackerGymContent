package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem17Test {

    Problem17 multiplicator = new Problem17();

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

    @Test
    public void testMultiplyCustomDifferentSize() throws Exception {

        assertThat(multiplicator.multiplyCustom("912", "70"), is("63840"));
    }

    @Test
    public void testMultiplyCustomOneMuchLarger() throws Exception {

        assertThat(multiplicator.multiplyCustom("91212352", "70"), is("6384864640"));

    }

    @Test
    public void testMultiplyCustomEqualSize() throws Exception {

        assertThat(multiplicator.multiplyCustom("12", "30"), is("360"));
    }
}