class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        java.util.Arrays.fill(left, 1);
        java.util.Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.max(left[i], right[i]);
        return sum;

        // approach 1
        /*    int n = ratings.length;
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
        */
    }
}