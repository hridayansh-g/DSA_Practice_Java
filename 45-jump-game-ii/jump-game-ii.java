class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
        // return dfs(nums, 0);
    }

    // approach 1

    /*  private int dfs(int[] nums, int idx) {
        if (idx >= nums.length - 1)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[idx]; j++) {
            int next = dfs(nums, idx + j);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }
        return min;
    }
    */
}