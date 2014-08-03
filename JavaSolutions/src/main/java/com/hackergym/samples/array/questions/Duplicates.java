package com.hackergym.samples.array.questions;

import java.util.*;

/**
 * Created by Fathalian on 7/29/14.
 * HackerGym.com
 */
public class Duplicates {

    public boolean detectDuplicatesHash(String s) {

        if (s == null) throw new IllegalArgumentException();

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = Character.valueOf(chars[i]);
            if (set.contains(c)) {
                return true;
            } else {
                set.add(c);
            }
        }
        return false;
    }

    public boolean detectDuplicatesSort(String s) {

        if (s == null) throw new IllegalArgumentException();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public String removeDuplicates(String s) {

        if (s == null) throw new IllegalArgumentException();

        List<Character> result = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = Character.valueOf(chars[i]);
            if (!set.contains(c)) {
                set.add(c);
                result.add(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        //append each element of the result to the builder
        result.forEach(builder::append);
        return builder.toString();
    }

    public String removeDuplicatesGrouping(String s) {

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int current = 0;
        int candidate = 0;
        while (candidate < chars.length) {
            //If the candidate pointer is pointing to something that is in the hash,
            //move it until the first element that is not in the hash.
            while (candidate < chars.length &&
                    set.contains(chars[candidate])) {
                candidate++;
            }

            if (candidate >= chars.length) {
                break;
            }
            //If the element under pointers is in the hash,
            // swap it with the candidate.

            if (set.contains(chars[current])) {
                char temp = chars[current];
                chars[current] = chars[candidate];
                chars[candidate] = temp;
            }

            //If the element under current is not in the hash
            //add it to the hash.
            if (!set.contains(chars[current])) {
                set.add(chars[current]);
            }

            candidate++;
            current++;
        }

        return String.valueOf(chars).substring(0, current);

    }
}
