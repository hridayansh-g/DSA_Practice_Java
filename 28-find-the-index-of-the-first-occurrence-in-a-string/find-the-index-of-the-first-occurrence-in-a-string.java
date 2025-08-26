class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int n = haystack.length(), m = needle.length();
        if (m > n)
            return -1;

        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m;) {
            if (needle.charAt(i) == needle.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        for (int i = 0, j = 0; i < n;) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m)
                    return i - j;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;

        // approach 1
        /*    if (needle.length() == 0)
            return 0;
        int n = haystack.length(), m = needle.length();
        if (m > n)
            return -1;
        for (int i = 0; i + m <= n; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            if (j == m)
                return i;
        }
        return -1;
        */
    }
}