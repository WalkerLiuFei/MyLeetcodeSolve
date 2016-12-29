package person.walker.greedy;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length < 1)
            return 0;
        int sumProfit = 0;
        int buyIndex = prices[0]; //assume buy
        int profit = 0;
        for (int index = 1; index < prices.length;index++){
            //可以求得局部最优解,得到的profit可以加入sumProfit中。并买下 下一个Index的商品
            if (prices[index] - buyIndex > 0){
                sumProfit += prices[index] - buyIndex;
                buyIndex = prices[index]; //买入下个Index 商品
                continue;
            }
            if (buyIndex > prices[index]) //convert buy
                buyIndex = prices[index];
        }
        return sumProfit;
    }
}
