import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> has= new HashMap<>();
        int[] arr= new int[2];
        int diff=0;
        for(int i=0;i<nums.length;i++){
            
            diff= target-nums[i];
            if(has.containsKey(diff)){
                arr[0]=has.get(diff);
                arr[1]=i;
                break;
            }
            has.put(nums[i], i);
        }
        return arr;
        /*int[] arr= new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])== target){
                    arr[0]=i;
                    arr[1]=j;
                    break;
                }
            }
        }
        return arr;*/
    }
}