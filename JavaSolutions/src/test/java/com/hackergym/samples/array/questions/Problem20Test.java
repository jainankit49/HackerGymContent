package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem20Test {

    Problem20 finder =new Problem20();
    @Test
    public void testFindSubstringBruteForce() throws Exception {

        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "forgotten";

        //Act
        int index = finder.findSubstringBruteForce(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));
    }

    public void testFindSubstringBruteForceAtTheEnd() throws Exception {

        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "today";

        //Act
        int index = finder.findSubstringBruteForce(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));
    }

    @Test
    public void testFindSubstringBruteForceNonExistance() throws Exception {

        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "Coffee";

        //Act
        int index = finder.findSubstringBruteForce(text, searchString);

        //Assert
        assertThat(index, is(-1));
    }

    @Test
    public void testFindSubstringBruteForceRepeatingCharacters() throws Exception {

        //Assert
        String text = "It seems that I have ppppppp to take a shower today";
        String searchString = "ppppppp";

        //Act
        int index = finder.findSubstringBruteForce(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));

    }

    @Test
    public void testFindSubstringBruteForceLongerSubstring() throws Exception {

        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "Well, maybe you shouldn't have taken that pill last night";

        //Act
        int index = finder.findSubstringBruteForce(text, searchString);

        //Assert
        assertThat(index, is(-1));
    }

    @Test
    public void testFindSubstringRabinKarp() throws Exception {
        //Assert
        String text = "I Have forgotten my brain";
//        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "forgotten";

        //Act
        int index = finder.findSubstringRabinKarp(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));
    }


    @Test
    public void testFindSubstringRabinKarpAtThEnd() throws Exception {
        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "today";

        //Act
        int index = finder.findSubstringRabinKarp(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));
    }
    @Test
    public void testFindSubstringRabinKarpNonExisting() throws Exception {
        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "Coffee";

        //Act
        int index = finder.findSubstringRabinKarp(text, searchString);

        //Assert
        assertThat(index, is(-1));
    }

    @Test
    public void testFindSubstringRabinKarpRepeatingCharacters() throws Exception {
        //Assert
        String text = "It seems that I have PPPPPPP to take a shower today";
        String searchString = "PPPPPPP";

        //Act
        int index = finder.findSubstringRabinKarp(text, searchString);

        //Assert
        //Assert
        assertThat(index, is(text.indexOf(searchString)));

    }

    @Test
    public void testFindSubstringRabinKarpLongerSubstring() throws Exception {

        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "Well, maybe you shouldn't have taken that pill last night";

        //Act
        int index = finder.findSubstringRabinKarp(text, searchString);

        //Assert
        assertThat(index, is(-1));
    }

    @Test
    public void testFindSubstringCustom() throws Exception {
        //Assert
        String text = "I Have forgotten my brain";
//        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "forgotten";

        //Act
        int index = finder.findSubstringCustom(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));
    }


    @Test
    public void testFindSubstringCustomAtThEnd() throws Exception {
        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "today";

        //Act
        int index = finder.findSubstringCustom(text, searchString);

        //Assert
        assertThat(index, is(text.indexOf(searchString)));
    }
    @Test
    public void testFindSubstringCustomNonExisting() throws Exception {
        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "Coffee";

        //Act
        int index = finder.findSubstringCustom(text, searchString);

        //Assert
        assertThat(index, is(-1));
    }

    @Test
    public void testFindSubstringCustomRepeatingCharacters() throws Exception {
        //Assert
        String text = "It seems that I have PPPPPPP to take a shower today";
        String searchString = "PPPPPPP";

        //Act
        int index = finder.findSubstringCustom(text, searchString);

        //Assert
        //Assert
        assertThat(index, is(text.indexOf(searchString)));

    }

    @Test
    public void testFindSubstringCustomLongerSubstring() throws Exception {

        //Assert
        String text = "It seems that I have forgotten to take a shower today";
        String searchString = "Well, maybe you shouldn't have taken that pill last night";

        //Act
        int index = finder.findSubstringCustom(text, searchString);

        //Assert
        assertThat(index, is(-1));
    }
}