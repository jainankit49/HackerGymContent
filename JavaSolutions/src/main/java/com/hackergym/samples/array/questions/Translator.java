package com.hackergym.samples.array.questions;

import com.hackergym.samples.linkedlist.model.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Fathalian on 7/31/14.
 * HackerGym.com
 */
public class Translator {

    private Map<String, String> dictionary;

    public Translator(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public String translateSingleWord(String sentence) {

        //first make the sentence into lower case so that
        //it maps nicely to the dictionary entries
        sentence = sentence.toLowerCase();

        char[] chars = sentence.toCharArray();
        int charCount = 0;

        //first calculate the size of the translated string
        for (int i = 0; i < chars.length; i++) {
            //count the spaces and skip over them
            if (chars[i] == ' ') {
                charCount++;
            } else {
                String word = getNextWord(chars, i);
                i = i + word.length() - 1;
                if (dictionary.containsKey(word)) {
                    charCount += dictionary.get(word).length();
                }
                //if the word does not have a translation in the dictionary
                //it translates to itself.
                else {
                    charCount += word.length();
                }

            }
        }

        //now make a translated char array of the correct size
        char[] translatedArray = new char[charCount];


        //now go over the words one by one and put the translation
        //in the translated array
        int translatedIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            //count the spaces and skip over them
            if (chars[i] == ' ') {
                translatedArray[translatedIndex] = ' ';
                translatedIndex++;
            } else {
                String word = getNextWord(chars, i);

                i = i + word.length() - 1;

                char[] translatedWord = word.toCharArray();

                if (dictionary.containsKey(word)) {
                    translatedWord = dictionary.get(word).toCharArray();
                }

                //copy the translated word into the translated array
                for (int t = 0; t < translatedWord.length; t++) {
                    translatedArray[translatedIndex] = translatedWord[t];
                    translatedIndex++;
                }
            }
        }

        return String.valueOf(translatedArray);
    }

    /*
     Gets the next word in the sentence starting from index i.
     A word is a sequence of non space character that are separate by whitespace
     */
    private String getNextWord(char[] chars, int i) {

        StringBuilder builder = new StringBuilder();

        while (i < chars.length && chars[i] != ' ') {
            builder.append(chars[i]);
            i++;
        }
        return builder.toString();
    }

    public String translateMultipleWords(String sentence) {

        sentence = sentence.toLowerCase();

        char[] chars = sentence.toCharArray();
        List<String> translations = new ArrayList<>();

        int i = 0;
        while (i < chars.length) {
            Pair<Boolean, String> translationResult = getLongestTranslation(chars, i);
            boolean shouldTranslate = translationResult.fst;
            String phraseToTranslate = translationResult.snd;

            i += phraseToTranslate.length();
            if (shouldTranslate) {
                phraseToTranslate = dictionary.get(phraseToTranslate);
            }

            translations.add(phraseToTranslate);

            //and skipp over the spaces
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < translations.size(); t++) {
            result.append(translations.get(t));
            //add space between each translated word, except the last word
            if (t != translations.size() - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    /*
    Gets the longest sequence of the characters that appear in the dictionary,
    from index i of chars.
    This method does not translate the sequence itself.

    This method returns a pair of (shouldTranslate, wordToTranslate).
    In case that no translation was found for any sequence didTranslate is false
    and translation is the first word in the char starting from i.
    Otherwise, didTranslate is true and the wordToTranslate is the longest sequence
    that is in the dictionary

    Returning a Pair may not be the best design here from the object oriented
    perspective but its good enough for this question
     */
    private Pair<Boolean, String> getLongestTranslation(char[] chars, int i) {

        String result = getNextWord(chars, i);
        boolean didTranslate = false;

        StringBuilder builder = new StringBuilder();
        while (i < chars.length) {
            if (chars[i] == ' ') {
                builder.append(' ');
                i++;
            } else {
                String nextWord = getNextWord(chars, i);
                builder.append(nextWord);
                if (dictionary.containsKey(builder.toString())) {
                    result = builder.toString();
                    didTranslate = true;
                }
                i += nextWord.length();
            }
        }
        return new Pair<>(didTranslate, result);
    }

}
