package com.hackergym.samples.stack;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *Reverse Polish Notation (RPN) is a way to express arithmetic expressions:

 * 12+3* 4/ is equivalent ((1+2) * 3)/ 4

 * More formally, operands are first presented, followed by the operator.

 * Given a string representing an RPN that only contains integers,
 * write an algorithm to calculate the result.
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/a7f47520-3945-11e4-916c-0800200c9a66?p=9
 */
public class Problem9 {

    /*============================================
    *                Your Custom Solution
    ============================================*/
    //should throw InvalidParameterException if expression is invalid
    public double calculateRPNCustom(String[] expression) {

        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testCalculateRPNStack
        return calculateRPNStack(expression);
    }

    /**
     * Throws InvalidParameterException if expression is invalid
     */
    public double calculateRPNStack(String[] expression) {

        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("/");
        operations.add("*");

        Stack<Double> results = new Stack<>();

        for(int i = 0 ; i < expression.length; i++) {
            String currentCharacter = expression[i];
            //if we have an operation
            if (operations.contains(currentCharacter)) {
                //if we don't have enough operands
                //then RPN is invalid
                if (results.size() < 2) {
                    throw new InvalidParameterException();
                }

                double operand2 = results.pop();
                double operand1 = results.pop();
                if (currentCharacter.equals("+")) {
                    results.push(operand1 + operand2);
                }
                if (currentCharacter.equals("-")) {
                    results.push(operand1 - operand2);
                }
                if (currentCharacter.equals("*")) {
                    results.push(operand1 * operand2);
                }
                if (currentCharacter.equals("/")) {
                    if (operand2 == 0) {
                        throw new InvalidParameterException();
                    }
                    results.push(operand1 / operand2);
                }

            }
            //we have an operand, so we push it into the stack
            else {
                results.push(Double.valueOf(currentCharacter));
            }
        }
        //if the stack still has elements left in it, then
        //we have an invalid RPN
        if (results.size() != 1) {
            throw new InvalidParameterException();
        }
        return results.pop();
    }


}
