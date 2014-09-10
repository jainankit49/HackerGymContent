package com.hackergym.samples.stack;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem9Test {

    Problem9 solver = new Problem9();

    @Test
    public void testCalculateRPNCustom() throws Exception {
        //(( (3+4) + (8 - 3) ) * ( ( 10 / 2 ) + 3))  / 15 = 6.4
        String[] expression = {"3","4","+","8","3","-","+","10","2","/", "3", "+", "*", "15","/"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(6.4));
    }

    @Test
    public void testCalculateRPNCustomNegativeNumbers() throws Exception {

        //( (3+4) + (8 - 3) ) * -10 = -120
        String[] expression = {"3","4","+","8","3","-","+","-10","*"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120.0));
    }

    @Test
    public void testCalculateRPNCustomSingleNumber() throws Exception {

        String[] expression = {"3"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(3.0));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNCustomDivisionByZero() throws Exception {

        String[] expression = {"3", "0", "/"};
        double result = solver.calculateRPNCustom(expression);

    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNCustomOrphanedOperator() throws Exception {

        String[] expression = {"+", "3"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120.0));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNCustomTooManyOperands() throws Exception {

        String[] expression = {"4", "3", "+", "1", "2", "3", "*"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120.0));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNCustomTooManyOperations() throws Exception {

        String[] expression = {"4", "3", "+", "1", "2", "*", "-", "+" , "*"};
        double result = solver.calculateRPNCustom(expression);

    }

    @Test
    public void testCalculateRPNStack() throws Exception {
        //(( (3+4) + (8 - 3) ) * ( ( 10 / 2 ) + 3))  / 15 = 6.4
        String[] expression = {"3","4","+","8","3","-","+","10","2","/", "3", "+", "*", "15","/"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(6.4));
    }

    @Test
    public void testCalculateRPNStackNegativeNumbers() throws Exception {

        //( (3+4) + (8 - 3) ) * -10 = -120
        String[] expression = {"3","4","+","8","3","-","+","-10","*"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120.0));
    }

    @Test
    public void testCalculateRPNStackingleNumber() throws Exception {

        String[] expression = {"3"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(3.0));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNStackDivisionByZero() throws Exception {

        String[] expression = {"3", "0", "/"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(3));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNStackOrphanedOperator() throws Exception {

        String[] expression = {"+", "3"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNStackTooManyOperands() throws Exception {

        String[] expression = {"4", "3", "+", "1", "2", "3", "*"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRPNStackTooManyOperations() throws Exception {

        String[] expression = {"4", "3", "+", "1", "2", "*", "-", "+" , "*"};
        double result = solver.calculateRPNCustom(expression);

        assertThat(result, is(-120));
    }

}