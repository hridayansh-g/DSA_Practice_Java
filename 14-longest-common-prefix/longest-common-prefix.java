import java.util.*;
class Solution {
    public String CommonPrefix(String s1, String s2){
      /*  if(s2.contains(s1)){
            return s1;
        }
        return CommonPrefix(s1.substring(0,s1.length()-1), s2);
        */
        int minLength= Math.min(s1.length(), s2.length());
        int x=-1;

        for(int i=0; i<minLength;i++){
            if(!(s1.charAt(i)== s2.charAt(i))){
                x=i;
                break;
            }
        }
        if(x==-1){
            return s1.substring(0, minLength);
        }

        return s1.substring(0, x);

    }
    public String longestCommonPrefix(String[] strs) {
      
        if(strs.length==1){
            return strs[0];
        }
        String s= strs[0];
        for(int i=1;i<strs.length;i++){
            s= CommonPrefix(s, strs[i]);
            if(s.isEmpty()){
                break;
            }

        }
        
        return s;
    }
}