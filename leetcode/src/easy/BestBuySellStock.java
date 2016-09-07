package easy;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author silent
 * Key points:
 * 1. Keep tracking lowest price of history;
 * 2. Keep calculating max profit of now;
 * 3. If current profit is bigger than maxProfit, substitute it
 */
public class BestBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int lowest = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] > lowest) {
                int profit = prices[i] - lowest;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                lowest = prices[i];
            }
        }
        return maxProfit;
    }
}
