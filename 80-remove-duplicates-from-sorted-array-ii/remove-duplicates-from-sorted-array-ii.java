class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
            int times = Math.min(2, count);
            for (int j = 0; j < times; j++) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}