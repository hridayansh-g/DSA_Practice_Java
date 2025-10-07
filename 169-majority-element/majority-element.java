import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hp.containsKey(nums[i])){
                hp.put(nums[i],(hp.get(nums[i]))+1);
            }
            else{
                hp.put(nums[i],1);
            }
        }
        for(int i=0; i<nums.length; i++){
            if((hp.get(nums[i])) > nums.length/2){
                return nums[i];
            }
        }
        return -1;

    }
}