package com.hackergym.samples.array.questions;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem23Test {

    private Problem23 mnemonic = new Problem23();

    @Test
    public void testFindMnemonics() throws Exception {
        int[] digits = {2, 0, 6};
        String[] expectedResult = {"cym", "cyn", "cyo", "czm", "czn", "czo", "dym", "dyn", "dyo", "dzm", "dzn", "dzo"};
        List<String> result = mnemonic.findMnemonics(digits);

        assertThat(result.size(), is(expectedResult.length));
        for(int i = 0 ; i < expectedResult.length ; i++) {
            assertThat(result.contains(expectedResult[i]), is(true));
        }
    }

    @Test
    public void testFindMnemonicsMemoization() throws Exception {

        int[] digits = {2, 0, 6};
        String[] expectedResult = {"cym", "cyn", "cyo", "czm", "czn", "czo", "dym", "dyn", "dyo", "dzm", "dzn", "dzo"};
        List<String> result = mnemonic.findMnemonicsMemoization(digits);

        assertThat(result.size(), is(expectedResult.length));
        for(int i = 0 ; i < expectedResult.length ; i++) {
            assertThat(result.contains(expectedResult[i]), is(true));
        }

        //now call the method with another argument
        int[] digits2 = {1, 0, 6};
        String[] expectedResult2 = {"aym", "ayn", "ayo", "azm", "azn", "azo", "bym", "byn", "byo", "bzm", "bzn", "bzo"};
        List<String> result2 = mnemonic.findMnemonicsMemoization(digits2);

        assertThat(result2.size(), is(expectedResult2.length));
        for(int i = 0 ; i < expectedResult2.length ; i++) {
            assertThat(result2.contains(expectedResult2[i]), is(true));
        }
    }

    @Test
    public void testFindMnemonicsCustom() throws Exception {
        int[] digits = {2, 0, 6};
        String[] expectedResult = {"cym", "cyn", "cyo", "czm", "czn", "czo", "dym", "dyn", "dyo", "dzm", "dzn", "dzo"};
        List<String> result = mnemonic.findMnemonicsCustom(digits);

        assertThat(result.size(), is(expectedResult.length));
        for(int i = 0 ; i < expectedResult.length ; i++) {
            assertThat(result.contains(expectedResult[i]), is(true));
        }
    }
}