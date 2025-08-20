class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp0 = 1;                               
        int dp1 = s.charAt(0) == '0' ? 0 : 1;      
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            char c1 = s.charAt(i - 1);
            if (c1 != '0') cur += dp1;            

            int two = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (two >= 10 && two <= 26) cur += dp0; 

            dp0 = dp1;
            dp1 = cur;
        }
        return dp1;

        //approach 1
      /*  if (s.length() == 0) return 1;
        if (s.charAt(0) == '0') return 0;

        int ways = numDecodings(s.substring(1));  
        if (s.length() >= 2) {
            int val = Integer.parseInt(s.substring(0, 2));
            if (val >= 10 && val <= 26) ways += numDecodings(s.substring(2));
        }
        return ways;
        */
    }
}