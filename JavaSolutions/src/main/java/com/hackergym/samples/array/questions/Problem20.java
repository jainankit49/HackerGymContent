package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/6/14.
 * HackerGym.com
 */

/**
 * Given a search string s and another string t,
 * write an algorithm that returns the index of the first occurrence of s in t, if any at all.
 *
 * For more detailed solution:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=20
 */

public class Problem20 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int findSubstringCustom(String text, String search) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindSubStringCustom
        return findSubstringBruteForce(text, search);
    }

    public int findSubstringBruteForce(String text, String search) {

        if (search.length() > text.length()) return -1;


        char[] textChars = text.toCharArray();
        char[] searchChars = search.toCharArray();

        for (int i = 0; i < textChars.length - searchChars.length + 1; i++) {
            if (matchSubstring(textChars, i, searchChars)) {
                return i;
            }
        }
        return -1;
    }

    //returns true that search appeared in text, starting from index "start"
    private boolean matchSubstring(char[] text, int start, char[] search) {

        int matchedLength = 0;
        while (matchedLength < search.length) {
            if (text[start + matchedLength] != search[matchedLength]) {
                return false;
            }
            matchedLength++;
        }
        return true;
    }


    public int findSubstringRabinKarp(String text, String search) {

        if (search.length() > text.length()) return -1;

        char[] textChars = text.toCharArray();
        char[] searchChars = search.toCharArray();

        //calculate initial fingerprints
        double searchFingerprint = calculateHash(searchChars, 0, search.length() - 1);
        double rollingFingerprint = calculateHash(textChars, 0, search.length() - 1);

        //to keep a simpler while loop we do the initial iteration.
        //This is because the initial iteration does not need a hash.
        boolean didFind = true;
        if (rollingFingerprint == rollingFingerprint) {
            for (int i = 0; i < search.length(); i++) {
                if (searchChars[i] != textChars[i]) {
                    didFind = false;
                    break;
                }
                //we have found the answer
            }
            if (didFind) return 0;
        }

        int i = 1;
        //we don't need to compare all of test with search
        //after text.length() - searchChars + 1.length, there is no chance
        //that search is in text.
        while (i < textChars.length - searchChars.length + 1) {

            //calculate the rolling finger print
            //for the next section of the text array
            rollingFingerprint = calculateRollingHash(
                    rollingFingerprint,
                    textChars,
                    i + searchChars.length - 1,
                    i - 1,
                    searchChars.length);

            //check for equality one by one if the fingerprints are the same
            if (rollingFingerprint == searchFingerprint) {
                didFind = true;
                for (int j = 0; j < searchChars.length; j++) {
                    if (textChars[i + j] != searchChars[j]) {
                        didFind = false;
                        break;
                    }
                }
                //we have found the answer
                if (didFind) return i;
            }

            i++;
        }
        return -1;
    }


    //not the best possible hash function, but will do here
    //see here for more details:
    //http://en.wikipedia.org/wiki/Rabin-Karp_string_search_algorithm#Hash_function_used
    private double calculateHash(char[] s, int start, int end) {

        double hash = 0;
        for (int i = end; i >= start; i--) {
            double addedValue = (Math.pow(10, (end - i)) * s[i]);
            hash += addedValue;
        }

        return hash;
    }

    private double calculateRollingHash(double oldHash,
                                        char[] s,
                                        int addElementIndex,
                                        int removedElementIndex,
                                        int windowLength) {


        double addedValue = Math.pow(3, 0) * s[addElementIndex];
        double removedValue = Math.pow(10, windowLength - 1) * s[removedElementIndex];
        oldHash -= removedValue;
        oldHash *= 10;
        return oldHash
                + addedValue;
    }


}
