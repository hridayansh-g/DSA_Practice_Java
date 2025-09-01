class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0)
            return res;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int n = s.length();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words)
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);

        for (int i = 0; i < wordLen; i++) { // shift window
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();
            for (int j = i; j + wordLen <= n; j += wordLen) {
                String word = s.substring(j, j + wordLen);
                if (wordCount.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == words.length) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;

        // approach 1
        /*    List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0)
            return res;
        
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int n = s.length();
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words)
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        
        for (int i = 0; i <= n - totalLen; i++) {
            String sub = s.substring(i, i + totalLen);
            if (isValid(sub, wordLen, wordCount)) {
                res.add(i);
            }
        }
        return res;
        */
    }

    /*
    private boolean isValid(String sub, int wordLen, Map<String, Integer> wordCount) {
        Map<String, Integer> seen = new HashMap<>();
        for (int j = 0; j < sub.length(); j += wordLen) {
            String word = sub.substring(j, j + wordLen);
            if (!wordCount.containsKey(word))
                return false;
            seen.put(word, seen.getOrDefault(word, 0) + 1);
            if (seen.get(word) > wordCount.get(word))
                return false;
        }
        return true;
    }
    */
}