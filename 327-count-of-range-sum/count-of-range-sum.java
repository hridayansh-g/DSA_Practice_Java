class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        long ans = sortCount(pre, 0, n, lower, upper, new long[n + 1]);
        return (int) ans;
    }

    private long sortCount(long[] pre, int l, int r, int lower, int upper, long[] buf) {
        if (l >= r) return 0;                  
        int m = (l + r) >>> 1;
        long cnt = 0;
        cnt += sortCount(pre, l, m, lower, upper, buf);
        cnt += sortCount(pre, m + 1, r, lower, upper, buf);

        int lo = m + 1, hi = m + 1;
        for (int i = l; i <= m; i++) {
            while (lo <= r && pre[lo] - pre[i] < lower) lo++;
            while (hi <= r && pre[hi] - pre[i] <= upper) hi++;
            cnt += hi - lo; 
        }

        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (pre[i] <= pre[j]) buf[k++] = pre[i++];
            else buf[k++] = pre[j++];
        }
        while (i <= m) buf[k++] = pre[i++];
        while (j <= r) buf[k++] = pre[j++];
        for (i = l; i <= r; i++) pre[i] = buf[i];

        return cnt;
    }

    // approach 1
   /* public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + nums[i];

        long cnt = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                long sum = pre[r + 1] - pre[l];
                if (sum >= lower && sum <= upper)
                    cnt++;
            }
        }
        return (int) cnt;
    }
    */
}