class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), best = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[256];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (seen[c])
                    break;
                seen[c] = true;
                best = Math.max(best, j - i + 1);
            }
        }
        return best;
    }
}