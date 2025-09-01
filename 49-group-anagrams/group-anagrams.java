import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] used = new boolean[n];
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (!used[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }
            res.add(group);
        }
        return res;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); i++)
            cnt[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++)
            if (--cnt[b.charAt(i) - 'a'] < 0)
                return false;
        return true;
    }
}