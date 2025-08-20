import java.util.*;
class Solution {
    public int combinationSum4(int[] nums, int target) {
        long[] dp = new long[target + 1];   
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            long ways = 0;
            for (int x : nums) if (t >= x) ways += dp[t - x];
            dp[t] = ways;
        }
        return (int) dp[target];
       // return dfs(nums, target);
    }

   // approach 1
    /*
    private int dfs(int[] nums, int rem) {
        if (rem == 0)
            return 1;
        if (rem < 0)
            return 0;
        int ways = 0;
        for (int x : nums)
            ways += dfs(nums, rem - x);
        return ways;
    }
    */
}