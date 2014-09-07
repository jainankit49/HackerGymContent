package com.hackergym.samples.array.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem11Test {


    private Problem11 translator;
    @Before
    public void prepeare() {
        translator = new Problem11(createDictionary());
    }

    @Test
    public void testTranslateSingleWord() throws Exception {

        assertThat(translator.translateSingleWord("I Love Mondays"),
                is("man doost daram doshanbe"));
    }

    @Test
    public void testTranslateSingleWordSomeWordsWtihNoTranslation() throws Exception {
        assertThat(translator.translateSingleWord("I Love HackerGym alot"),
                is("man doost daram hackergym kheilee"));
    }

    @Test
    public void testTranslateMultipleWords() throws Exception {
        assertThat(translator.translateMultipleWords("That thing is huge"),
                is("oon bozorge"));
    }

    @Test
    public void testTranslateMultipleWordsSomeWordsWithNoTranslation() throws Exception {
        assertThat(translator.translateMultipleWords("Jack is huge"),
                is("jack bozorge"));
    }

    @Test
    public void testTranslateMultipleWordsLongWord() throws Exception {
        assertThat(translator.translateMultipleWords("Excuse me, can I help you with something?"),
                is("chete?"));
    }

    @Test
    public void testTranslateSingleWordCustom() throws Exception {

        assertThat(translator.translateSingleWordCustom("I Love Mondays"),
                is("man doost daram doshanbe"));
    }

    @Test
    public void testTranslateSingleWordCustomSomeWordsWtihNoTranslation() throws Exception {
        assertThat(translator.translateSingleWordCustom("I Love HackerGym alot"),
                is("man doost daram hackergym kheilee"));
    }

    @Test
    public void testTranslateMultipleWordsCustom() throws Exception {
        assertThat(translator.translateMultipleWordsCustom("That thing is huge"),
                is("oon bozorge"));
    }

    @Test
    public void testTranslateMultipleWordsCustomSomeWordsWithNoTranslation() throws Exception {
        assertThat(translator.translateMultipleWordsCustom("Jack is huge"),
                is("jack bozorge"));
    }

    @Test
    public void testTranslateMultipleWordsCustomLongWord() throws Exception {
        assertThat(translator.translateMultipleWordsCustom("Excuse me, can I help you with something?"),
                is("chete?"));
    }

    private Map<String, String> createDictionary() {

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("i", "man");
        dictionary.put("love", "doost daram");
        dictionary.put("mondays", "doshanbe");
        dictionary.put("alot", "kheilee");
        dictionary.put("that thing", "oon");
        dictionary.put("is huge", "bozorge");
        dictionary.put("excuse me, can i help you with something?", "chete?");

        return dictionary;
    }
}