class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
        //return dfs(nums, 0);
    }

    // approach 1
    /*
    private boolean dfs(int[] nums, int idx) {
        if (idx >= nums.length - 1)
            return true;
        for (int j = 1; j <= nums[idx]; j++) {
            if (dfs(nums, idx + j))
                return true;
        }
        return false;
    }
    */
}