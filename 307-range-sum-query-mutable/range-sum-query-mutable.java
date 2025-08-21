class NumArray {
    private final int n;
    private final int[] bit;
    private final int[] nums;

    public NumArray(int[] arr) {
        n = arr.length;
        bit = new int[n + 1];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
            add(i + 1, arr[i]);
        }
    }

    private void add(int i, int delta) {
        while (i <= n) {
            bit[i] += delta;
            i += i & -i;
        }
    }

    private int prefix(int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & -i;
        }
        return s;
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        add(index + 1, delta);
    }

    public int sumRange(int left, int right) {
        return prefix(right + 1) - prefix(left);
    }

    // approach 1
    /*   private final int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int index, int val) {
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++)
            sum += nums[i];
        return sum;
    }
    
    */
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */