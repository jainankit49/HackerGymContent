package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 7/30/14.
 * HackerGym.com
 */
public class WhiteSpace {

    public String removeWhiteSpaceInPlace(String s) {

        char[] charArray = s.toCharArray();
        //The size of the array is changing by removal of empty spaces
        //however the array.length doesn't change in java
        //we keep track of the effective size using this index
        int endOfArrayIndex = charArray.length - 1;
        for (int i = 0; i <= endOfArrayIndex; i++) {
            if (charArray[i] == ' ') {
                //see if there are following spaces and remove them
                int whitespaceCount = 0;
                int j = i + 1;
                while (j <= endOfArrayIndex &&
                        charArray[j] == ' ') {

                    whitespaceCount++;
                    j++;

                }

                boolean needsTrimming = whitespaceCount > 0 || i == 0 || j == endOfArrayIndex + 1;
                int startOfWhiteSpaces = i + 1;
                //if we are the beginning or end of the String, everything is extra whitespace
                if (i == 0 || j == endOfArrayIndex + 1) {
                    startOfWhiteSpaces = i;
                    whitespaceCount++;
                }

                if (needsTrimming) {
                    //now remove the whitespace
                    for (int shiftIndex = startOfWhiteSpaces;
                         shiftIndex + whitespaceCount <= endOfArrayIndex;
                         shiftIndex++) {
                        charArray[shiftIndex] = charArray[shiftIndex + whitespaceCount];
                    }

                    //finally reduce the effective size by the number of whitespaces that was removed
                    endOfArrayIndex -= whitespaceCount;
                }

            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= endOfArrayIndex; i++) {
            builder.append(charArray[i]);
        }
        return builder.toString();
    }

    public String removeWhiteSpaceExtraMemory(String s) {

        char[] chars = s.toCharArray();

        //first find the number of extra whitespaces
        int extraWhitespaceCount = 0;
        int currentIndex = 0;
        while (currentIndex < chars.length) {
            if (chars[currentIndex] == ' ') {
                //see if there are following spaces and remove them
                int j = currentIndex + 1;
                while (j < chars.length &&
                        chars[j] == ' ') {

                    extraWhitespaceCount++;
                    j++;

                }
                if (currentIndex == 0 || j == chars.length) {
                    extraWhitespaceCount++;
                }
                currentIndex = j;
            } else {
                currentIndex++;
            }
        }

        //now build an appropriate sized array
        char[] resultArray = new char[chars.length - extraWhitespaceCount];

        //now copy elements from the first array while skipping over extra whitespaces
        int resultIndex = 0;
        for (int i = 0; i < chars.length; i++) {

            int skipWhitespaces = 0;
            if (chars[i] == ' ') {
                int j = i + 1;
                while (j < chars.length &&
                        chars[j] == ' ') {

                    skipWhitespaces++;
                    j++;

                }
                //if we are dealing with whitespaces at the beginning and end
                //everything should be considered whitespace
                if (i != 0 && j != chars.length) {
                    resultArray[resultIndex] = chars[i];
                    resultIndex++;
                }
                i = i + skipWhitespaces;

            } else {
                resultArray[resultIndex] = chars[i];
                resultIndex++;
            }
        }

        return String.valueOf(resultArray);

    }
}
