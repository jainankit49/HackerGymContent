package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem10Test {

    private Problem10 duplicateRemover = new Problem10();

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
    public void testDetectDuplicatesCustomNormal() {

        assertThat(duplicateRemover.detectDuplicatesCustom("HACCERGYMM"), is(true));
    }

    @Test
    public void testDetectDuplicatesCustomEmptyString() {
        assertThat(duplicateRemover.detectDuplicatesCustom(""), is(false));
    }

    @Test
    public void testDetectDuplicatesCustomNoDuplicates() {
        assertThat(duplicateRemover.detectDuplicatesCustom("HackerGym"), is(false));
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
    public void testRemoveDuplicatesCustom() {
        assertThat(duplicateRemover.removeDuplicatesCustom("HACCKERRGYMM"), is("HACKERGYM"));
    }

    @Test
    public void testRemoveDuplicatesNoDuplicatesCustom() {
        assertThat(duplicateRemover.removeDuplicatesCustom("HACKERGYM"), is("HACKERGYM"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesCustom() {
        assertThat(duplicateRemover.removeDuplicatesCustom("hhhhhhhhh"), is("h"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesCustomAtEnd() {
        assertThat(duplicateRemover.removeDuplicatesCustom("1234567hh"), is("1234567h"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesCustomAtBeginning() {
        assertThat(duplicateRemover.removeDuplicatesCustom("aa1234567"), is("a1234567"));
    }

    @Test
    public void testRemoveDuplicatesAllDuplicatesCustomSingle() {
        assertThat(duplicateRemover.removeDuplicatesCustom("1234hh567"), is("1234h567"));
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