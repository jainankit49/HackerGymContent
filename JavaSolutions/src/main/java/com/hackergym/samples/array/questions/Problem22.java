package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/8/14.
 * HackerGym.com
 */

/**
 * Write a program that can convert an integer to a string and back.
 * You may NOT use dynamic array to hold the string.
 * You may use a helper method to convert a single digit character like ‘9’ to an integer.
 *
 * For more detailed solution see:
 * http://hackergym.com/#!/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=22
 */

public class Problem22 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public String toStringCustom(int number) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testToStringCustom
        return toString(number);
    }

    /*============================================
    *                Your Custom Solution
    ============================================*/
    public int fromStringCustom(String number) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testFromStringCustom
        return fromString(number);
    }

    public String toString(int number) {

        boolean isNegative = number < 0;


        int decimalOrder = 1;
        int numberTemp = number;
        int digitCount = 0;

        while (numberTemp / decimalOrder != 0) {
            numberTemp /= decimalOrder;
            decimalOrder *= 10;
            digitCount++;
        }

        StringBuilder result = new StringBuilder();

        if (isNegative) {
            number = -number;
            result.insert(0, "-");
        }


        decimalOrder = (int) Math.pow(10, (digitCount - 1));
        while (decimalOrder != 0) {
            int digit = number / decimalOrder;
            result.append(digit);
            number = number % decimalOrder;
            decimalOrder /= 10;
        }

        //make sure we don't return an empty string
        //when converting 0
        if (result.length() == 0) result.append(0);
        return result.toString();
    }

    public int fromString(String number) {

        //handle the negative
        boolean isNegative = number.charAt(0) == '-';
        int firstIndex = isNegative ? 1 : 0;
        int result = 0;
        for (int i = firstIndex; i < number.length(); i++) {
            int digit = Integer.valueOf(String.valueOf(number.charAt(i)));
            result += digit * ((int) Math.pow(10, number.length() - i - 1));
        }

        if (isNegative) result = -result;

        return result;
    }
}
