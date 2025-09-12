import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {

        /*
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (i < last.length() && first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
        */


        
         if(strs.length == 1){
            return strs[0];
        }
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        StringBuilder sb= new StringBuilder();
        String first= strs[0];

       
        for(int i=0; i<first.length(); i++){
            if(first.charAt(i) == strs[strs.length-1].charAt(i)){
                sb.append(first.charAt(i));
            }
            else{
                break;
            }
        }
        return sb.toString();
    
    }

} 