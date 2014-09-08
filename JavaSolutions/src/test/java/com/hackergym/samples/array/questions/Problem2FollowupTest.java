package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem2FollowupTest {

    Problem2Followup remover = new Problem2Followup();

    @Test
    public void testRemoveWhiteSpaceInPlace() throws Exception {

//        assertThat(remover.removeWhiteSpaceInPlace("  My Cat    is   "),
//                is("My Cat is"));
        assertThat(remover.removeWhiteSpaceInPlace("    My  abs       are good    "),
                is("My abs are good"));
    }

    @Test
    public void testRemoveWhiteSpaceInPlaceNoWhitesapce() throws Exception {
        assertThat(remover.removeWhiteSpaceInPlace("My cat is sitting on the space bar"),
                is("My cat is sitting on the space bar"));
    }

    @Test
    public void testRemoveWhiteSpaceInPlaceAllWhiteSapce() throws Exception {
        assertThat(remover.removeWhiteSpaceInPlace("       "),
                is(""));
    }

    @Test
    public void testRemoveWhiteSpaceExtraMemory() throws Exception {
        assertThat(remover.removeWhiteSpaceExtraMemory("  My Cat  is  "),
                is("My Cat is"));

    }

    @Test
    public void testRemoveWhiteSpaceExtraMemoryNoWhitespace() throws Exception {
        assertThat(remover.removeWhiteSpaceExtraMemory("My cat is sitting on the space bar"),
                is("My cat is sitting on the space bar"));
    }

    @Test
    public void testRemoveWhiteSpaceExtraMemoryAllWhitespace() throws Exception {
        assertThat(remover.removeWhiteSpaceExtraMemory("       "),
                is(""));

    }

    @Test
    public void testRemoveWhiteSpaceCustom() throws Exception {

//        assertThat(remover.removeWhiteSpaceInPlace("  My Cat    is   "),
//                is("My Cat is"));
        assertThat(remover.removeWhiteSpaceCustom("    My  abs       are good    "),
                is("My abs are good"));
    }

    @Test
    public void testRemoveWhiteSpaceCustomNoWhitespace() throws Exception {
        assertThat(remover.removeWhiteSpaceCustom("My cat is sitting on the space bar"),
                is("My cat is sitting on the space bar"));
    }

    @Test
    public void testRemoveWhiteSpaceCustomAllWhiteSpace() throws Exception {
        assertThat(remover.removeWhiteSpaceCustom("       "),
                is(""));
    }
}