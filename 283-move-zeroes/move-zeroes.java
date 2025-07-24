class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;

        int j=0;
        int temp;
        while(i<nums.length-1 && j< nums.length){
            /*if(nums[i]==0 && nums[j]==0){
                j++;
            }*/

            if(nums[i]==0 && nums[j]!=0){
                //swap
                temp= nums[i];
                nums[i]= nums[j];
                nums[j]= temp;
                i++;
                //j++;
            }
            else if(nums[i] != 0){
                i++;
            }
            j++;
        }
    }
}