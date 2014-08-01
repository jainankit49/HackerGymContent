package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StockPriceTest {

    StockPrice warrenBuffet = new StockPrice();

    @Test
    public void testGetBestDealEnumeration() throws Exception {

        //arrange
        int[] stocks = {50, 23, 18, 25, 24, 28, 23};

        //act
        StockPrice.Deal actualDeal = warrenBuffet.getBestDealEnumeration(stocks);

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
        StockPrice.Deal actualDeal = warrenBuffet.getBestDealEnumeration(stocks);

        //assert
        assertThat(actualDeal.profit, is(0));
    }

    @Test
    public void testGetBestDealOptimized() throws Exception {

        //arrange
        int[] stocks = {50, 23, 18, 25, 24, 28, 23};

        //act
        StockPrice.Deal actualDeal = warrenBuffet.getBestDealOptimized(stocks);

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
        StockPrice.Deal actualDeal = warrenBuffet.getBestDealOptimized(stocks);

        //assert
        assertThat(actualDeal.profit, is(0));
    }
}