package com.hackergym.samples.array.questions;

/**
 * Created by Fathalian on 7/31/14.
 * HackerGym.com
 */

/**
 * You have an array that contains stock prices for a sequence of days.
 * The value at index i of this array is the price of a stock on day i.
 * Given this array, you can buy only a single stock.
 * Find the best pair of purchase and sale days that yields the most profits.
 *
 * For more detailed solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=12
 */
public class Problem12 {

    /**
     * You may design a better class for this, here for the
     * sake of brevity we have chosen to simulate a c like struct
     */
    public class Deal {
        public int profit;
        public int buyDay;
        public int sellDay;

        public Deal(int buyDay, int sellDay, int profit) {
            this.buyDay = buyDay;
            this.sellDay = sellDay;
            this.profit = profit;
        }
    }


    /*============================================
    *                Your Custom Solution
    ============================================*/
    public Deal getBestDealCustom(int[] stockChart) {
        //comment out the line below and add your own solution
        //unit tests will be run automatically against your solution
        //the tests for your custom solution start with testGetBestDealCustom
        return getBestDealEnumeration(stockChart);
    }

    public Deal getBestDealEnumeration(int[] stockChart) {


        Deal bestDeal = new Deal(0, 0, 0);
        for (int i = 0; i < stockChart.length; i++) {
            //calculate the best deals for each day
            Deal bestDealForTheDay = new Deal(i, i, 0);
            for (int j = i; j < stockChart.length; j++) {
                int profit = stockChart[j] - stockChart[i];
                if (profit >= bestDealForTheDay.profit) {
                    bestDealForTheDay = new Deal(i, j, profit);
                }
            }
            if (bestDealForTheDay.profit >= bestDeal.profit) {
                bestDeal = bestDealForTheDay;
            }
        }
        return bestDeal;
    }

    private class Offer {

        int day;
        int price;

        public Offer(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    public Deal getBestDealOptimized(int[] stockChart) {

        Deal bestDealSoFar = new Deal(0, 0, 0);
        Offer bestBuySoFar = new Offer(0, stockChart[0]);
        for (int i = 0; i < stockChart.length; i++) {
            int bestDealToday = stockChart[i] - bestBuySoFar.price;
            if (bestDealToday >= bestDealSoFar.profit) {
                bestDealSoFar = new Deal(bestBuySoFar.day, i, bestDealToday);
            }

            int todaysBuy = stockChart[i];
            if (todaysBuy < bestBuySoFar.price) {
                bestBuySoFar = new Offer(i, todaysBuy);
            }
        }
        return bestDealSoFar;
    }

}
