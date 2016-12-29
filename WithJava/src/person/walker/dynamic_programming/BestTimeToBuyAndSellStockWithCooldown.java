package person.walker.dynamic_programming;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2 )
            return 0;
        int[] sumProfit = new int[prices.length];
        sumProfit[1] = Math.max(0,prices[1] - prices[0]);
        int minValue = Math.min(prices[0],prices[1]);
        int preMinSum = 0;

        int secondMin = Integer.MAX_VALUE; //secondMin value 's

        for (int index = 2; index < prices.length; index ++){
            if (prices[index] <= minValue){
                minValue = prices[index];
                preMinSum  = sumProfit[index-2]; //记录最小值 之前的状态。
            }
                sumProfit[index] = Math.max(sumProfit[index-1],prices[index] - minValue+preMinSum);
            if (index >= 3)
                sumProfit[index] = Math.max(sumProfit[index],sumProfit[index - 3] + prices[index] - prices[index-1]);
        }
        return sumProfit[prices.length -1];
    }
    @Test
    public void test(){
        new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
}
