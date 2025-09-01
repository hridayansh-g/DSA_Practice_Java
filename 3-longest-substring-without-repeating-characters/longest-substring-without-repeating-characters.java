class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];
        java.util.Arrays.fill(last, -1);
        int left = 0, best = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (last[c] >= left)
                left = last[c] + 1;
            last[c] = r;
            best = Math.max(best, r - left + 1);
        }
        return best;

        // approach 1
        /*    int n = s.length(), best = 0;
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
        */
    }
}