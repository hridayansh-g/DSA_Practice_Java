class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hp= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!hp.containsKey(nums[i])){
                hp.put(nums[i], i);
            }
            else{
                int x= hp.get(nums[i]);
                if(Math.abs(x-i)<=k){
                    return true;
                }
                else{
                    hp.put(nums[i], i);
                }
            }
        }
        return false;
    }
}