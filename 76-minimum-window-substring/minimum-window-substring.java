class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";
        int[] need = new int[128];
        for (char c: t.toCharArray()) need[c]++;
        int req = t.length(), best = Integer.MAX_VALUE, bi = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (need[c]-- > 0) req--;
            while (req == 0) {
                if (r - l + 1 < best) { best = r - l + 1; bi = l; }
                char d = s.charAt(l++);
                if (++need[d] > 0) req++;
            }
        }
        return best == Integer.MAX_VALUE ? "" : s.substring(bi, bi + best);

        // approach 1
       /* if (t.length() > s.length()) return "";
        int[] need0 = new int[128];
        for (char c: t.toCharArray()) need0[c]++;
        int n = s.length(), best = Integer.MAX_VALUE, bi = 0;

        for (int i = 0; i < n; i++) {
            int[] need = need0.clone();
            int rem = t.length();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (need[c] > 0) rem--;
                need[c]--;
                if (rem == 0) {
                    if (j - i + 1 < best) { best = j - i + 1; bi = i; }
                    break;
                }
            }
        }
        return best == Integer.MAX_VALUE ? "" : s.substring(bi, bi + best); */
    }
}