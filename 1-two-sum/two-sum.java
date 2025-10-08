class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr= new int[2];
        HashMap<Integer, Integer> hp= new HashMap<>();
        int sum=0;
        for(int i=0; i<nums.length; i++){
           
        
            if(hp.containsKey(target-nums[i])){
                arr[0]= hp.get(target-nums[i]);
                arr[1]= i;
                break;
            }
             hp.put(nums[i], i);
        }

        
        
       /* int i=0; 
        int j=i+1;
        while(j<nums.length){
             if((nums[i]+nums[j])== target){
                    arr[0]= i;
                    arr[1]=j;
                    break;
                }
            i++;
            j++;
        }
        */


        /*for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if((nums[i]+nums[j])== target){
                    arr[0]= i;
                    arr[1]=j;
                }
            }
        }
        */
        return arr;
    }
}