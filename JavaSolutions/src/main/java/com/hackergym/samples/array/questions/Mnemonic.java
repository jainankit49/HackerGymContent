package com.hackergym.samples.array.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fathalian on 8/8/14.
 * HackerGym.com
 */
public class Mnemonic {

    private Map<Integer, String> digitMnemonic;

    public Mnemonic() {
        digitMnemonic = new HashMap<>();
        digitMnemonic.put(0, "yz");
        digitMnemonic.put(1, "ab");
        digitMnemonic.put(2, "cd");
        digitMnemonic.put(3, "ef");
        digitMnemonic.put(4, "ghi");
        digitMnemonic.put(5, "jkl");
        digitMnemonic.put(6, "mno");
        digitMnemonic.put(7, "pqr");
        digitMnemonic.put(8, "stu");
        digitMnemonic.put(9, "vwx");
    }
    public List<String> findMnemonics(int[] number) {
        return findMnemonicsRecursive(number, 0, number.length - 1);
    }

    private List<String> findMnemonicsRecursive(int[] number, int start, int end) {

        List<String> result = new ArrayList<>();

        String charMnemonic = digitMnemonic.get(number[start]);

        //if there is only one character left, look into the
        //mnemonic hash an return all the single character mnemonics
        if (start == end) {
            for (int i = 0; i < charMnemonic.length(); i++) {
                String mnemonic = String.valueOf(charMnemonic.charAt(i));
                result.add(mnemonic);
            }
            return result;
        }

        //Find the mnemonics for the digits that come after the current digit
        List<String> partialResult = findMnemonicsRecursive(number, start + 1, end);

        //now apply the current digit mnemonics to the result
        for (int i = 0; i < charMnemonic.length(); i++) {
            String mnemonic = String.valueOf(charMnemonic.charAt(i));
            for (String s : partialResult) {
                result.add(mnemonic + s);
            }
        }
        return result;
    }


    //we use this hash map to store the results of expensive operations
    private Map<String, List<String>> cache = new HashMap<>();

    public List<String> findMnemonicsMemoization(int[] number) {
        return findMnemonicsRecursiveMemoized(number, 0, number.length - 1);
    }

    private List<String> findMnemonicsRecursiveMemoized(int[] number, int start, int end) {

        List<String> result = new ArrayList<>();

        String charMnemonic = digitMnemonic.get(number[start]);

        //if there is only one character left, look into the
        //mnemonic hash an return all the single character mnemonics
        if (start == end) {
            for (int i = 0; i < charMnemonic.length(); i++) {
                String mnemonic = String.valueOf(charMnemonic.charAt(i));
                result.add(mnemonic);
            }
            return result;
        }


        //first check the cache to see if we have calculated the
        //mnemonic before
        String cacheKey = getCacheKey(number, start, end);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        //We haven't calculated the mnemonics before
        // Find the mnemonics for the digits that come after the current digit
        List<String> partialResult = findMnemonicsRecursiveMemoized(number, start + 1, end);


        //now apply the current digit mnemonics to the result
        for (int i = 0; i < charMnemonic.length(); i++) {
            String mnemonic = String.valueOf(charMnemonic.charAt(i));
            for (String s : partialResult) {
                result.add(mnemonic + s);
            }
        }

        //put the calculated result in the cache so that it can be used later
        cache.put(cacheKey, result);
        return result;
    }

    //Returns the string value of the digits in number from index "start"
    //to index "end"
    private String getCacheKey(int[] number, int start, int end) {

        StringBuilder cacheKey = new StringBuilder();
        for(int i= start; i <= end; i++) {
            cacheKey.append(number[i]);
        }

        return cacheKey.toString();
    }
}
