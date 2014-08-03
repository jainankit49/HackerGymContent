package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 8/2/14.
 * HackerGym.com
 */
public class StringMultiplicator {

    /**
     * This method assumes that all the inputs are well formed numbers
     * that are converted to the strings
     */
    public String multiply(String a, String b) {

        char[] smaller = a.toCharArray();
        char[] bigger = b.toCharArray();

        //first select the smaller string
        if (smaller.length > bigger.length) {
            char[] temp = smaller;
            smaller = bigger;
            bigger = temp;
        }

        int smallerIndex = smaller.length - 1;
        String onGoingResult = "0";
        //decimal points determines how many decimal digits we have processed
        //we will use this to add the extra zeros when we move between digits
        int decimalPoints = 0;
        do {
            int carry = 0;

            char fst = smaller[smallerIndex];
            int fstInt = Integer.valueOf(String.valueOf(fst));

            StringBuilder currentResult = new StringBuilder();

            //make sure that you add enough zero when you move to the next decimal point
            for(int i = 0; i < decimalPoints; i++) {
                currentResult.insert(0, "0");
            }

            //make sure that you add
            for (int biggerIndex = bigger.length - 1; biggerIndex >= 0; biggerIndex--) {

                char snd = bigger[biggerIndex];
                int sndInt = Integer.valueOf(String.valueOf(snd));

                int result = ((fstInt * sndInt) + carry) % 10;
                carry = ((fstInt * sndInt) + carry) / 10;
                currentResult.insert(0, result);
            }

            if(carry != 0) {
                currentResult.insert(0, carry);
            }
            onGoingResult = sum(currentResult.toString(), onGoingResult);
            smallerIndex--;
            decimalPoints++;
        } while (smallerIndex >= 0);

        return onGoingResult;
    }

    /**
     * This method assumes that all the inputs are well formed numbers
     * that are converted to the strings
     */
    public String sum(String a, String b) {

        char[] smaller = a.toCharArray();
        char[] bigger = b.toCharArray();

        //first select the smaller string
        if (smaller.length > bigger.length) {
            char[] temp = smaller;
            smaller = bigger;
            bigger = temp;
        }

        //We use this String builder to record the results
        StringBuilder builder = new StringBuilder();

        //position the the indexes at the end of the strings
        int smallerIndex = smaller.length - 1;
        int biggerIndex = bigger.length - 1;

        int carry = 0;
        while (smallerIndex >= 0) {
            char fst = smaller[smallerIndex];
            char snd = bigger[biggerIndex];
            int fstInt = Integer.valueOf(String.valueOf(fst));
            int sndInt = Integer.valueOf(String.valueOf(snd));
            int result = (fstInt + sndInt + carry) % 10;
            carry = fstInt + sndInt + carry >= 10 ? 1 : 0;
            builder.insert(0, result);
            smallerIndex--;
            biggerIndex--;
        }

        while (biggerIndex >= 0) {
            char snd = bigger[biggerIndex];
            int sndInt = Integer.valueOf(String.valueOf(snd));
            int result = (sndInt + carry) % 10;
            carry = carry + sndInt >= 10 ? 1 : 0;
            builder.insert(0, result);
            biggerIndex--;
        }

        return builder.toString();
    }
}
