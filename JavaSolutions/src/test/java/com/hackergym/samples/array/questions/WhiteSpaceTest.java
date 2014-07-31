package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhiteSpaceTest {

    WhiteSpace remover = new WhiteSpace();
    @Test
    public void testRemoveWhiteSpaceInPlace() throws Exception {

        assertThat(remover.removeWhiteSpaceInPlace("  My Cat    is   "),
                is("My Cat is"));
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
}