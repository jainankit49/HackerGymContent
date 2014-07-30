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
        for(int i = 0 ; i < chars.length; i++) {
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
        for (int i = 0 ; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
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
        for(int i = 0 ; i < chars.length; i++) {
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
}
