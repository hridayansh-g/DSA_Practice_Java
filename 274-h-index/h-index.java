class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int c : citations) {
                if (c >= i)
                    count++;
            }
            if (count >= i)
                h = i;
        }
        return h;
    }
}