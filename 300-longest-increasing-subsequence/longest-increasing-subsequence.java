class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        // return dfs(nums, 0, Integer.MIN_VALUE);
    }
    // approach 1
    /*
    private int dfs(int[] a, int i, int prev) {
        if (i == a.length)
            return 0;
        int skip = dfs(a, i + 1, prev);
        int take = 0;
        if (a[i] > prev)
            take = 1 + dfs(a, i + 1, a[i]);
        return Math.max(skip, take);
    }
    */
}