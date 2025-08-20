class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.length() < text2.length()) {
            String t = text1;
            text1 = text2;
            text2 = t;
        }
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prevDiag = 0;
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (c1 == text2.charAt(j - 1))
                    dp[j] = 1 + prevDiag;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prevDiag = temp;
            }
        }
        return dp[n];
        //return rec(text1, text2, 0, 0);
    }
    // approach 1
    /*
    private int rec(String a, String b, int i, int j) {
        if (i == a.length() || j == b.length())
            return 0;
        if (a.charAt(i) == b.charAt(j))
            return 1 + rec(a, b, i + 1, j + 1);
        return Math.max(rec(a, b, i + 1, j), rec(a, b, i, j + 1));
    }
    */
}