class Solution {
    
    public void sortColors(int[] nums) {
        int low= 0;
        int high= nums.length-1;
        int x= 0;
        int temp;
        while(x<=high){
            if(nums[x]==0){
                //swap(low,x);
                temp= nums[low];
                nums[low]= nums[x];
                nums[x]= temp;
                
                low++;
                x++;
            }
            else if(nums[x]==2){
                //swap(high,x);
                temp= nums[high];
                nums[high]= nums[x];
                nums[x]= temp;
                high--;
            }
            else{
                x++;
            }
        }
        
    }
}