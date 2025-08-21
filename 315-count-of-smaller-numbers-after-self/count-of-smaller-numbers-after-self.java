import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int m = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) sorted[m++] = sorted[i];
        }

        int[] bit = new int[m + 2];
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int r = rank(sorted, m, nums[i]); 
            ans[i] = query(bit, r - 1);      
            add(bit, r, 1);                  
        }

        List<Integer> out = new ArrayList<>(n);
        for (int v : ans) out.add(v);
        return out;
    }

    private int rank(int[] sorted, int m, int x) {
        int l = 0, r = m - 1, pos = m;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (sorted[mid] >= x) { pos = mid; r = mid - 1; }
            else l = mid + 1;
        }
        return pos + 1;
    }

    private void add(int[] bit, int idx, int delta) {
        for (int i = idx; i < bit.length; i += i & -i) bit[i] += delta;
    }

    private int query(int[] bit, int idx) {
        int s = 0;
        for (int i = idx; i > 0; i -= i & -i) s += bit[i];
        return s;
    }


    // apporach 1
 /*   public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] res = new Integer[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i])
                    cnt++;
            }
            res[i] = cnt;
        }
        return Arrays.asList(res);
    }
    */
}