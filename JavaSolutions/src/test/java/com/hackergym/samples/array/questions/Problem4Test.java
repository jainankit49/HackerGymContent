package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem4Test {

    Problem4 anagramFinder = new Problem4();

    @Test
    public void testAreAnagramsHash() throws Exception {
        assertThat(anagramFinder.areAnagramsHash("ClintEastwood", "OldWestAction"),
                is(true));
    }

    @Test
    public void testAreAnagramsHashNotAnagramsSameLengthMissingChar() throws Exception {
        assertThat(anagramFinder.areAnagramsHash("HackerGym", "Haker Gym"),
                is(false));
    }

    @Test
    public void testAreAnagramsHashNotAnagramsSameLengthNewChar() throws Exception {
        assertThat(anagramFinder.areAnagramsHash("HackerGym", "HackerHym"),
                is(false));
    }


    @Test
    public void testAreAnagramsHashNotAnagramsDifferentLength() throws Exception {
        assertThat(anagramFinder.areAnagramsHash("HackerGym", "HaCk3r gyM"),
        is(false));
    }

    @Test
    public void testAreAnagramsSort() throws Exception {
        assertThat(anagramFinder.areAnagramsSort("ClintEastwood", "OldWestAction"),
                is(true));
    }

    @Test
    public void testAreAnagramsSortNotAnagramsSameLength() throws Exception {
        assertThat(anagramFinder.areAnagramsSort("HackerGym", "Haker Gym"),
                is(false));
    }

    @Test
    public void testAreAnagramsSortNotAnagramsDifferentLength() throws Exception {
        assertThat(anagramFinder.areAnagramsSort("HackerGym", "HaCk3r gyM"),
                is(false));
    }

    @Test
    public void testAreAnagramsCustom() throws Exception {
        assertThat(anagramFinder.areAnagramsCustom("ClintEastwood", "OldWestAction"),
                is(true));
    }

    @Test
    public void testAreAnagramsCustomNotAnagramsSameLengthMissingChar() throws Exception {
        assertThat(anagramFinder.areAnagramsCustom("HackerGym", "Haker Gym"),
                is(false));
    }

    @Test
    public void testAreAnagramsCustomNotAnagramsSameLengthNewChar() throws Exception {
        assertThat(anagramFinder.areAnagramsCustom("HackerGym", "HackerHym"),
                is(false));
    }


    @Test
    public void testAreAnagramsCustomNotAnagramsDifferentLength() throws Exception {
        assertThat(anagramFinder.areAnagramsCustom("HackerGym", "HaCk3r gyM"),
                is(false));
    }
}