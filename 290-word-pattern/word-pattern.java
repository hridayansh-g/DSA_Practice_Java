class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] w = s.split(" ");
        if (pattern.length() != w.length)
            return false;
        int n = w.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean samePat = pattern.charAt(i) == pattern.charAt(j);
                boolean sameWord = w[i].equals(w[j]);
                if (samePat != sameWord)
                    return false;
            }
        }
        return true;
    }
}