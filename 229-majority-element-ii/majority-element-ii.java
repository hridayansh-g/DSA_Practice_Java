class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m = nums.length;
        int p = 0, q = 0, c1 = 0, c2 = 0;

        for (int v : nums) {
            if (p == v) c1++;
            else if (q == v) c2++;
            else if (c1 == 0) { p = v; c1 = 1; }
            else if (c2 == 0) { q = v; c2 = 1; }
            else { c1--; c2--; }
        }

        c1 = 0; c2 = 0;
        for (int v : nums) {
            if (v == p) c1++;
            else if (v == q) c2++;
        }

        List<Integer> ans = new ArrayList<>(2);
        int thr = m / 3;
        if (c1 > thr) ans.add(p);
        if (c2 > thr && q != p) ans.add(q);
        return ans;

      /*  int m = nums.length;
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int v = nums[i];
            if (seen.contains(v)) continue;
            seen.add(v);

            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (nums[j] == v) cnt++;
            }
            if (cnt > m / 3) ans.add(v);
        }
        return ans; */
    }
}