package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DuplicatesTest {

    private Duplicates duplicateRemover = new Duplicates();
    @Test
    public void testDetectDuplicatesHashNormal() {

        assertThat(duplicateRemover.detectDuplicatesHash("HACCERGYMM"), is(true));
    }

    @Test
    public void testDetectDuplicatesHashEmptyString() {
        assertThat(duplicateRemover.detectDuplicatesHash(""), is(false));
    }

    @Test
    public void testDetectDuplicatesHashNoDuplicates() {
        assertThat(duplicateRemover.detectDuplicatesHash("HackerGym"), is(false));
    }

    @Test
    public void testDetectDuplicatesSortNormal() {
        assertThat(duplicateRemover.detectDuplicatesSort("HACCERGYMM"), is(true));
    }

    @Test
    public void testDetectDuplicatesSortEmptyString() {
        assertThat(duplicateRemover.detectDuplicatesSort(""), is(false));

    }

    @Test
    public void testDetectDuplicatesSortNoDuplicates() {
        assertThat(duplicateRemover.detectDuplicatesSort("HACKERGYM"), is(false));
    }

    @Test
    public void testRemoveDuplicates() {
        assertThat(duplicateRemover.removeDuplicates("HACCKERRGYMM"), is("HACKERGYM"));
    }

    @Test
    public void testRemoveDuplicatesNoDuplicates() {
        assertThat(duplicateRemover.removeDuplicates("HACKERGYM"), is("HACKERGYM"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicates() {
        assertThat(duplicateRemover.removeDuplicates("hhhhhhhhh"), is("h"));
    }

}