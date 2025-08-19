class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = amount + 1;       
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x = 1; x <= amount; x++) {
            for (int c : coins) {
                if (x - c >= 0) {
                    dp[x] = Math.min(dp[x], dp[x - c] + 1);
                }
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
    // approach 1
 /*   public int coinChange(int[] coins, int amount) {
        int ans = dfs(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int[] coins, int remain) {
        if (remain == 0) return 0;
        if (remain < 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int res = dfs(coins, remain - c);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        return min;
    }

    */
}