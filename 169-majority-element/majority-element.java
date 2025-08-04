class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int maxMaj=0;
        int temp;
        int x=-1;
        int xj=0;
        for(int i=0;i<nums.length-1;i++){
            temp=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(temp== nums[j]){
                    count++;
                    x=j;
                }
            }
            if(count>maxMaj){
                maxMaj=count;
                xj=x;
            }
            count=0;
        }
        return nums[xj];
    }
}