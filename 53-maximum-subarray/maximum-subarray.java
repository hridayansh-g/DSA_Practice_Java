class Solution {
    public int maxSubArray(int[] nums) {
        //Kandane's algo
        int currentSum=0;
        int maxSum= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currentSum= Math.max(nums[i], nums[i]+currentSum);
            maxSum= Math.max(currentSum, maxSum);

        }
return maxSum;

        /*int sum=0;
        int maxSum= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum= 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                maxSum= Math.max(maxSum, sum);
                
            }
        

        }
        return maxSum;*/
    }
}