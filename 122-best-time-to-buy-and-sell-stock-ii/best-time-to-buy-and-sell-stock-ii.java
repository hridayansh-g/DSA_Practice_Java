class Solution {
    public int maxProfit(int[] prices) {
         int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
        // return dfs(prices, 0, false);
        }
       /* private int dfs(int[] prices, int i, boolean holding) {
        if (i == prices.length) return 0;

        int skip = dfs(prices, i + 1, holding); // skip today

        if (holding) {
            // Try selling today
            int sell = prices[i] + dfs(prices, i + 1, false);
            return Math.max(sell, skip);
        } else {
            // Try buying today
            int buy = -prices[i] + dfs(prices, i + 1, true);
            return Math.max(buy, skip);
        }*/
    }
    

