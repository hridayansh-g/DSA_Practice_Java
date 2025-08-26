class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prevDiag = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] = prevDiag + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prevDiag = temp;
            }
        }
        return dp[n] == m;
    }
}