package com.hackergym.samples.array.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fathalian on 7/30/14.
 * HackerGym.com
 */

/**
 * Given a string find all the substrings of it that are palindrome.
 * aabbbaa :
 * aa – bb – bbb- abbba- aabbbaa
 *
 * For more detailed answer see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=1
 */

public class Problem1 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public Set<String> findPalindromSubstringsCustom(String s) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFindPalindromeSubstringsCustom
        return findPalindromSubstringsEnumeration(s);
    }

    public Set<String> findPalindromSubstringsEnumeration(String s) {

        Set<String> result = new HashSet<>();
        Set<String> allSubStrings = findAllSubstrings(s);
        for (String subString : allSubStrings) {
            //we don't consider signle character strings palindromes in this problem
            if (isPalindrome(subString) && subString.length() != 1) {
                result.add(subString);
            }
        }

        return result;
    }

    private Set<String> findAllSubstrings(String s) {

        //using a set data structure will cause us not to include duplicates
        Set<String> allSubStrings = new HashSet<>();

        //although we could use the substring methods provided on
        //the String object itself, we are going to do it the hard way and
        //use a char array for educational purposes.In the real world, you should
        //always prefer a well tested native method to rolling something your own
        char[] sChars = s.toCharArray();
        //start from index 0 and generate all the substrings
        for (int i = 0; i < sChars.length; i++) {

            //generate all the substrings from length i to length sChars.length
            for (int substringStartIndex = i; substringStartIndex < sChars.length; substringStartIndex++) {

                //create the substring from the chars and append it to the result
                StringBuilder builder = new StringBuilder();
                for (int sliceIndex = i; sliceIndex <= substringStartIndex; sliceIndex++) {
                    builder.append(sChars[sliceIndex]);
                }
                allSubStrings.add(builder.toString());
            }
        }

        return allSubStrings;
    }

    private boolean isPalindrome(String s) {

        char[] charArray = s.toCharArray();
        int beginning = 0;
        int end = s.length() - 1;
        while (beginning <= end) {
            if (charArray[beginning] != charArray[end]) {
                return false;
            }
            beginning++;
            end--;
        }

        return true;
    }

    public Set<String> findPalindromeSubstringsGeneration(String s) {

        //using a set data structure will cause us not to include duplicates
        Set<String> result = new HashSet<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //for even sized palindromes,
            //Start the check from the element itself and its right neighbor
            expandForPalindromes(i, i + 1, charArray, result);
            //for odd sized palindromes,
            //ignore the current element and start the check from the
            //elements to its left and right
            expandForPalindromes(i - 1, i + 1, charArray, result);

        }
        return result;
    }

    private void expandForPalindromes(int leftIndex,
                                      int rightIndex,
                                      char[] array,
                                      Set<String> results) {


        StringBuilder builder = new StringBuilder();
        //for odd sized substrings we first add the middle string to
        //the String builder
        if (leftIndex == rightIndex -2 &&
                leftIndex > 0) {
            builder.append(array[leftIndex + 1]);
        }
        while (leftIndex >= 0 && rightIndex < array.length) {
            if (array[leftIndex] != array[rightIndex]) {
                break;
            }
            builder.insert(0, array[leftIndex]).append(array[rightIndex]);
            results.add(builder.toString());
            leftIndex--;
            rightIndex++;
        }

    }
}
