class Solution {
    public void moveZeroes(int[] nums) {
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
    }
}