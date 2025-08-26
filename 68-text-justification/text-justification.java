class Solution {

    private void appendSpaces(StringBuilder sb, int cnt) {
        for (int i = 0; i < cnt; i++)
            sb.append(' ');
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length, i = 0;
        while (i < n) {
            int j = i, lineWordsLen = words[i].length();
            while (j + 1 < n && lineWordsLen + 1 + words[j + 1].length() <= maxWidth) {
                j++;
                lineWordsLen += 1 + words[j].length();
            }
            boolean last = (j == n - 1);
            int gaps = j - i;

            if (last || gaps == 0) {
                StringBuilder sb = new StringBuilder(words[i]);
                for (int k = i + 1; k <= j; k++)
                    sb.append(' ').append(words[k]);
                while (sb.length() < maxWidth)
                    sb.append(' ');
                res.add(sb.toString());
            } else {
                int totalSpaces = maxWidth - (lineWordsLen - gaps);
                int base = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                StringBuilder sb = new StringBuilder(maxWidth);
                for (int k = 0; k < gaps; k++) {
                    sb.append(words[i + k]);
                    appendSpaces(sb, base + (k < extra ? 1 : 0));
                }
                sb.append(words[j]);
                res.add(sb.toString());
            }
            i = j + 1;
        }
        return res;

        // approach 1
        /*    List<String> res = new ArrayList<>();
        int n = words.length, i = 0;
        while (i < n) {
            int j = i, len = words[i].length();
            while (j + 1 < n && len + 1 + words[j + 1].length() <= maxWidth) {
                j++;
                len += 1 + words[j].length();
            }
            boolean last = (j == n - 1);
            if (last || i == j) {
                StringBuilder sb = new StringBuilder(words[i]);
                for (int k = i + 1; k <= j; k++)
                    sb.append(' ').append(words[k]);
                while (sb.length() < maxWidth)
                    sb.append(' ');
                res.add(sb.toString());
            } else {
                int gaps = j - i;
                StringBuilder[] between = new StringBuilder[gaps];
                for (int g = 0; g < gaps; g++)
                    between[g] = new StringBuilder(" ");
                int currLen = len;
                int p = 0;
                while (currLen < maxWidth) {
                    between[p].append(' ');
                    currLen++;
                    p = (p + 1) % gaps;
                }
                StringBuilder line = new StringBuilder(maxWidth);
                for (int k = 0; k < gaps; k++) {
                    line.append(words[i + k]).append(between[k]);
                }
                line.append(words[j]);
                res.add(line.toString());
            }
            i = j + 1;
        }
        return res;
        */
    }
}