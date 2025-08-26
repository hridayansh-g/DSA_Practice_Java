class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] c = new int[n];
        java.util.Arrays.fill(c, 1);

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && c[i] <= c[i - 1]) {
                    c[i] = c[i - 1] + 1;
                    changed = true;
                }
                if (i + 1 < n && ratings[i] > ratings[i + 1] && c[i] <= c[i + 1]) {
                    c[i] = c[i + 1] + 1;
                    changed = true;
                }
            }
        }

        int sum = 0;
        for (int v : c)
            sum += v;
        return sum;
    }
}