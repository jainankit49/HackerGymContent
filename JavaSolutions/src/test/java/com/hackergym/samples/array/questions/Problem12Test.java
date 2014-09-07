package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem12Test {

    Problem12 warrenBuffet = new Problem12();

    @Test
    public void testGetBestDealEnumeration() throws Exception {

        //arrange
        int[] stocks = {50, 23, 18, 25, 24, 28, 23};

        //act
        Problem12.Deal actualDeal = warrenBuffet.getBestDealEnumeration(stocks);

        //assert
        assertThat(actualDeal.buyDay, is(2));
        assertThat(actualDeal.sellDay, is(5));
        assertThat(actualDeal.profit, is(10));
    }

    @Test
    public void testGetBestDealEnumerationWithLoss() throws Exception {

        //arrange
        int[] stocks = {50, 45, 43, 30, 24, 20, 9, 5, 1};

        //act
        Problem12.Deal actualDeal = warrenBuffet.getBestDealEnumeration(stocks);

        //assert
        assertThat(actualDeal.profit, is(0));
    }

    @Test
    public void testGetBestDealOptimized() throws Exception {

        //arrange
        int[] stocks = {50, 23, 18, 25, 24, 28, 23};

        //act
        Problem12.Deal actualDeal = warrenBuffet.getBestDealOptimized(stocks);

        //assert
        assertThat(actualDeal.buyDay, is(2));
        assertThat(actualDeal.sellDay, is(5));
        assertThat(actualDeal.profit, is(10));
    }

    @Test
    public void testGetBestDealOptimizedWithLoss() throws Exception {

        //arrange
        int[] stocks = {50, 45, 43, 30, 24, 20, 9, 5, 1};

        //act
        Problem12.Deal actualDeal = warrenBuffet.getBestDealOptimized(stocks);

        //assert
        assertThat(actualDeal.profit, is(0));
    }

    @Test
    public void testGetBestDealCustom() throws Exception {

        //arrange
        int[] stocks = {50, 23, 18, 25, 24, 28, 23};

        //act
        Problem12.Deal actualDeal = warrenBuffet.getBestDealCustom(stocks);

        //assert
        assertThat(actualDeal.buyDay, is(2));
        assertThat(actualDeal.sellDay, is(5));
        assertThat(actualDeal.profit, is(10));
    }

    @Test
    public void testGetBestDealCustomWithLoss() throws Exception {

        //arrange
        int[] stocks = {50, 45, 43, 30, 24, 20, 9, 5, 1};

        //act
        Problem12.Deal actualDeal = warrenBuffet.getBestDealCustom(stocks);

        //assert
        assertThat(actualDeal.profit, is(0));
    }
}