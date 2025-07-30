class Solution {
   /* public void swap(int[] nums,int a,int b){
        int temp=0;
        temp=nums[a];
        nums[a]=nums[b];
        nums[b]= temp;
    }
    public void sorting(int[] nums, int a){
        for(int i=a;i<nums.length-1;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]>nums[j]){
                    swap(nums, i, j);
                }
            }
        }
    } */

    public void reverse(int[] nums, int a){
        int start=a;
        int end= nums.length-1;
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp= nums[a];
        nums[a]= nums[b];
        nums[b]= temp;
    }
    public void nextPermutation(int[] nums) {
        int idx1=-1;
        int idx2=0;
        for(int i=nums.length-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx1=i;
                break;
            }
        }
        if(idx1== -1){
            Arrays.sort(nums);
        }
        else{
            for(int i=nums.length-1;i>idx1;i--){
                if(nums[idx1]<nums[i]){
                    idx2=i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1);
        }




        /*int idx1=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx1=i;
                break;
            }
        }
        if(idx1==-1){
           Arrays.sort(nums);
        }
        else{
            sorting(nums, idx1+1);
            swap(nums,idx1, idx1+1);
        }*/
    }
}