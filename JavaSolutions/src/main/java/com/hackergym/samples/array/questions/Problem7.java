package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 7/30/14.
 * HackerGym.com
 */

/**
 * Run Length Encoding (RLE) is an algorithm for compressing strings,
 *which is specifically useful in compressing binary values.
 * aabccaabaad <--> 2a1b2c2a1b2a1d
 * Implement RLE algorithm for compression and decompression of strings.
 *
 * For more detailed solution see:
 * http://stage.hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=7
 */

public class Problem7 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public String compressCustom(String s) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testCompressCustom
        return compress(s);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public String decompressCustom(String s) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testDecompressCustom
        return decompress(s);
    }

    public String compress(String s) {

        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int count = 1;
            while (i + 1 < charArray.length &&
                    charArray[i] == charArray[i + 1]) {
                count++;
                i++;
            }
            builder.append(count).append(c);
        }

        return builder.toString();
    }

    public String decompress(String s) {

        StringBuilder result = new StringBuilder();
        char[] charArray = s.toCharArray();

        int i = 0;
        while (i < charArray.length) {

            boolean isNumber = true;
            //we use this boolean to detect ill formed compressed String
            //at each loop we expect to see a number at first followed by
            // a single character
            boolean isExpectingNo = true;

            //we use this index to mark the start of our number sequence
            int numberStartIndex = i;
            while (isNumber) {
                char countChar = charArray[i];
                try {
                    Integer.parseInt(String.valueOf(countChar));
                    i++;
                    isExpectingNo = false;
                }
                //if we the character wasn't the number we break out of the while
                //and look up the next character
                //however if it was the first iteration of the while and we
                //were expecting a number, then we throw an exception
                catch (NumberFormatException e) {
                    if (isExpectingNo) {
                        throw new IllegalArgumentException("Invalid Compressed String" + s);
                    }
                    break;
                }
            }

            //we are now at the end of the while loop with characters
            //from numberStartIndex to i - 1, indicating our count number
            int charCount = getNumberFromArray(numberStartIndex, i-1, charArray);
            //we are not expecting a character,
            //because we have caught all the digits in the past while loop
            //the only case that we cannot get a character here is when i is
            //at the end of the string
            if (i == charArray.length) {
                throw new IllegalArgumentException("Invalid Compressed String" + s);
            }

            //finally append decompress the character
            char c = charArray[i];
            for( int j = 0 ; j < charCount; j++) {
                result.append(c);
            }
            i++;
        }
        return result.toString();
    }

    private int getNumberFromArray(int startIndex, int endIndex, char[] array) {
        StringBuilder builder = new StringBuilder();
        for(int i = startIndex; i <= endIndex; i++) {
           builder.append(array[i]) ;
        }
        return Integer.parseInt(builder.toString());
    }
}
