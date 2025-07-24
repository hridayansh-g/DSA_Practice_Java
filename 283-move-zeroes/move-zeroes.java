class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        int temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                //swap i,j
                temp=nums[i];
                nums[i]= nums[j];
                nums[j]=temp;
                j++;
               
            }
        }
        
        
        
        /*int i=0;

        int j=0;
        int temp;
        while(i<nums.length-1 && j< nums.length){
            if(nums[i]==0 && nums[j]!=0){
                temp= nums[i];
                nums[i]= nums[j];
                nums[j]= temp;
                i++;
            }
            else if(nums[i] != 0){
                i++;
            }
            j++;
        }
        */
    }
}