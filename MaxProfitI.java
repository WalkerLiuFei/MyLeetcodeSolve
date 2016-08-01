package com.company;

/**
 * % 12.7 beat!.....
 */
public class MaxProfitI {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxProfit = 0;
        int minIndex = prices[0];
        for (int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit,prices[i] - minIndex);
            if (minIndex > prices[i])
                minIndex = prices[i];
        }
        return maxProfit;
    }
}
