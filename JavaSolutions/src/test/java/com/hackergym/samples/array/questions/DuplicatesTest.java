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

    @Test
    public void testRemoveDuplicatesGrouping() {
        assertThat(duplicateRemover.removeDuplicatesGrouping("HACCKERRGYMM"), is("HACKERGYM"));
    }

    @Test
    public void testRemoveDuplicatesNoDuplicatesGrouping() {
        assertThat(duplicateRemover.removeDuplicatesGrouping("HACKERGYM"), is("HACKERGYM"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesGrouping() {
        assertThat(duplicateRemover.removeDuplicatesGrouping("hhhhhhhhh"), is("h"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesGroupingAtEnd() {
        assertThat(duplicateRemover.removeDuplicatesGrouping("1234567hh"), is("1234567h"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesGroupingAtBeginning() {
        assertThat(duplicateRemover.removeDuplicatesGrouping("aa1234567"), is("a1234567"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesGroupingSingle() {
        assertThat(duplicateRemover.removeDuplicatesGrouping("1234hh567"), is("1234h567"));
    }
}