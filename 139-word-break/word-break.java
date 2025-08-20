import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxLen = 0;
        for (String w : dict)
            maxLen = Math.max(maxLen, w.length());

        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - maxLen); j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    // approach 1
    /*  public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, new HashSet<>(wordDict));
    }
    
    private boolean dfs(String s, int i, Set<String> dict) {
        if (i == s.length())
            return true;
        for (int j = i + 1; j <= s.length(); j++) {
            if (dict.contains(s.substring(i, j)) && dfs(s, j, dict))
                return true;
        }
        return false;
    }
    */
}