class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m = nums.length;
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
        return ans;
    }
}