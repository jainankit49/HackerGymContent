package com.hackergym.samples.array.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */

/**
 * Detect if a string is an anagram of another.
 * An anagram of a string is another string that is created by changing the position of the characters of the first string.
 * For example: HamCryKeg is an anagram of HackerGym.
 *
 * For More Detailed Answer See:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=4
 */

public class Problem4 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public boolean areAnagramsCustom(String a, String b) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testAreAnagramsCustom
        return areAnagramsHash(a, b);
    }

    public boolean areAnagramsHash(String a, String b) {
        //Strings are not anagrams if they have different lengths
        if (a.length() != b.length()) return false;

        //we consider lower case and upper case characters the same

        a = a.toLowerCase();
        b = b.toLowerCase();

        //create the hash from the first String
        Map<Character, Integer> hash = new HashMap<>();
        char[] aCharArray = a.toCharArray();
        for (int i = 0; i < aCharArray.length; i++) {
            Character c = Character.valueOf(aCharArray[i]);
            if (!hash.containsKey(c)) {
                hash.put(c, 1);
            } else {
                hash.put(c, hash.get(c) + 1);
            }
        }

        //verify that the string are anagram by going over the second string
        //and the hash
        char[] bCharArray = b.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            Character c = Character.valueOf(bCharArray[i]);
            if (!hash.containsKey(c)) return false;
            else {
                Integer charCount = hash.get(c);
                if (charCount == 0) return false;
                hash.put(c, charCount - 1);
            }
        }

        for (Integer counts : hash.values()) {
            if (counts != 0) return false;
        }

        return true;
    }

    public boolean areAnagramsSort(String a, String b) {
        //Strings are not anagrams if they have different lengths
        if (a.length() != b.length()) return false;

        //create the hash from the first String
        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        Arrays.sort(aCharArray);
        Arrays.sort(bCharArray);

        for (int i = 0; i < aCharArray.length; i++) {
            if (aCharArray[i] != bCharArray[i]) return false;
        }
        return true;
    }
}
