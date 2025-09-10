import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> h= new HashMap<>();
        int diff=0;
        for(int i=0; i<nums.length;i++){
            diff= target- nums[i];
            if(h.containsKey(diff)){
                return new int[]{h.get(diff), i};
            }
            else{
                h.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};

        // approach 1
       /* for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                   return new int[]{i,j};   
                }
            }
        }
         return new int[]{-1,-1}; 
         */
    }
}