import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> h1= new HashMap<>();
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            if(h1.containsKey(nums[i])){
                h1.put(nums[i], h1.get(nums[i])+1);
                //h1 value ++
            }
            else{
                h1.put(nums[i],1);
            }
            if(h1.get(nums[i])>(n/2)){
                return nums[i];
            }
        }
        return -1;
        /*Arrays.sort(nums);
        int n= nums.length;
        return nums[n/2];
*/

        /*int count=0;
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
        return nums[xj]; */
    }
}