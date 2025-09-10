import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        HashSet<Character> h= new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0; right < s.length(); right++){
            if(h.contains(s.charAt(right))){
                h.remove(s.charAt(left));
                left++;
                right--;
            }
            else{
                h.add(s.charAt(right));
            }
            maxLength= Math.max(maxLength, right-left+1);
        }
        return maxLength;

    }
    // approach 1
    /*
    private boolean checkDuplicate(String s){
        for(int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i)== s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        int maxLength= 0;
        for(int i=0; i<s.length();i++){
            for(int j=i+1; j<=s.length();j++){
                String st= s.substring(i,j);
                if(checkDuplicate(st)){
                    maxLength= Math.max(st.length(), maxLength);
                }
            }
        }
        return maxLength;
    }
    */
}