class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (pal(s, i, j)) ans++;
        return ans;
    }
    private boolean pal(String s, int l, int r) {
        while (l < r) 
        {if (s.charAt(l++) != s.charAt(r--))
        {
         return false;
         }
         }

        return true;
    }
}