class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
      /* for(int i=m; i<m+n; i++){
        nums1[i] = nums2[i-m];
       }
       Arrays.sort(nums1);
       */

       int i=m;
       int j=0;
       while(i<m+n){
        nums1[i]= nums2[j];
        i++;
        j++;
       }

       Arrays.sort(nums1);

       
    
    }
}