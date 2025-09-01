import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] w = s.split(" ");
        if (pattern.length() != w.length)
            return false;

        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();

        for (int i = 0; i < w.length; i++) {
            char p = pattern.charAt(i);
            String word = w[i];
            String mappedWord = p2w.get(p);
            Character mappedPat = w2p.get(word);

            if (mappedWord == null && mappedPat == null) {
                p2w.put(p, word);
                w2p.put(word, p);
            } else if (!word.equals(mappedWord) || (mappedPat == null || mappedPat != p)) {
                return false;
            }
        }
        return true;
        // approach 1
        /*
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
        */
    }
}