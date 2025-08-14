class Solution {
     public String longestPalindrome(String s) {
        int n = s.length(), best = 1, bi = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (pal(s, i, j) && j - i + 1 > best) { best = j - i + 1; bi = i; }
        return s.substring(bi, bi + best);
    }
    private boolean pal(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}