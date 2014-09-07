package com.hackergym.samples.array.questions;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem1Test {

    Problem1 palindromeFinder = new Problem1();

    @Test
    public void testFindPalindromSubstringsEnumerationEvenSize() throws Exception {
        String s = "aabbaa";
        Set<String> expectedResult = new HashSet<>(Arrays.asList("aa","bb", "abba",  "aabbaa"));
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsEnumeration(s);

        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void testFindPalindromSubstringsEnumerationOddSize() throws Exception {
        String s = "aabbbaa";
        Set<String> expectedResult = new HashSet(Arrays.asList("aa","bb", "bbb", "abbba",  "aabbbaa"));
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsEnumeration(s);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void testFindPalindromSubstringsEnumerationNoPalindrome() throws Exception {

        String s = "abcde";
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsEnumeration(s);

        assertThat(actualResult.size(), is(0));
    }

    @Test
    public void testFindPalindromeSubstringsEnumerationEmptyString() throws Exception {
        String s = "";
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsEnumeration(s);

        assertThat(actualResult.size(), is(0));
    }

    @Test
    public void testFindPalindromeSubstringsGenerationEvenSize() throws Exception {
        String s = "aabbaa";
        Set<String> expectedResult = new HashSet<>(Arrays.asList("aa","bb", "abba",  "aabbaa"));
        Set<String> actualResult = palindromeFinder.findPalindromeSubstringsGeneration(s);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void testFindPalindromeSubstringsGenerationOddSize() throws Exception {
        String s = "aabbbaa";
        Set<String> expectedResult = new HashSet<>(Arrays.asList("aa","bb", "bbb", "abbba",  "aabbbaa"));
        Set<String> actualResult = palindromeFinder.findPalindromeSubstringsGeneration(s);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void testFindPalindromeSubstringsGenerationNoPalindrome() throws Exception {
        String s = "abcde";
        Set<String> actualResult = palindromeFinder.findPalindromeSubstringsGeneration(s);

        assertThat(actualResult.size(), is(0));
    }

    @Test
    public void testFindPalindromSubstringsCustomEvenSize() throws Exception {
        String s = "aabbaa";
        Set<String> expectedResult = new HashSet<>(Arrays.asList("aa","bb", "abba",  "aabbaa"));
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsCustom(s);

        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void testFindPalindromSubstringsCustomOddSize() throws Exception {
        String s = "aabbbaa";
        Set<String> expectedResult = new HashSet(Arrays.asList("aa","bb", "bbb", "abbba",  "aabbbaa"));
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsCustom(s);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void testFindPalindromSubstringsCustomNoPalindrome() throws Exception {

        String s = "abcde";
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsCustom(s);

        assertThat(actualResult.size(), is(0));
    }

    @Test
    public void testFindPalindromeSubstringsCustomEmptyString() throws Exception {
        String s = "";
        Set<String> actualResult = palindromeFinder.findPalindromSubstringsCustom(s);

        assertThat(actualResult.size(), is(0));
    }

    public void testFindPalindromeSubstringsGenerationEmptyString() throws Exception {
        String s = "";
        Set<String> actualResult = palindromeFinder.findPalindromeSubstringsGeneration(s);

        assertThat(actualResult.size(), is(0));
    }
}