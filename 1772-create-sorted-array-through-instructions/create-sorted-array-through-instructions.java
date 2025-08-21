import java.util.*;
class Solution {
    private static final int MAX = 100000;          
    private static final int MOD = 1_000_000_007;

    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int[] bit = new int[MAX + 2];              
        long cost = 0;
        int inserted = 0;

        for (int x : instructions) {
            int less = query(bit, x - 1);
            int notGreaterOrEqual = query(bit, x);  
            int greater = inserted - notGreaterOrEqual;
            cost += Math.min(less, greater);
            add(bit, x, 1);
            inserted++;
        }
        return (int)(cost % MOD);
    }

    private void add(int[] bit, int i, int delta) {
        for (int idx = i; idx < bit.length; idx += idx & -idx) {
            bit[idx] += delta;
        }
    }

    private int query(int[] bit, int i) {
        if (i <= 0) return 0;
        int s = 0;
        for (int idx = i; idx > 0; idx -= idx & -idx) {
            s += bit[idx];
        }
        return s;
    }

    // approach 1
   /* public int createSortedArray(int[] instructions) {
         final int MOD = 1_000_000_007;
        List<Integer> arr = new ArrayList<>();
        long cost = 0;

        for (int x : instructions) {
            int less = 0, greater = 0;
            for (int v : arr) {
                if (v < x) less++;
                else if (v > x) greater++;
            }
            cost += Math.min(less, greater);

            int pos = 0;
            while (pos < arr.size() && arr.get(pos) <= x) pos++;
            arr.add(pos, x);
        }
        return (int)(cost % MOD);
    }
    */
}