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
        /*
      int size= nums.length;
      if(size < 2){
        return;
      }

      int i=0;
      int j=i+1;
      while(i<size && j<size){
        if(nums[i] == 0 && nums[j]==0){
            j++;
        }
        else if(nums[i]==0 && nums[j] !=0){
            // swap
            int temp= nums[i];
            nums[i]= nums[j];
            nums[j]= temp;
            i++;
            j++;
        }
        else{
            i++;
            j++;
        }
      }
      */
    }
}