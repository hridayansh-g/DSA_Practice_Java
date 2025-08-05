import java.util.*;
class Solution {
    public String reverseWords(String s) {
        String[] s1= s.split("\\s+");
        int i=0;
        int j= s1.length-1;
        String sb;
        StringBuilder sx= new StringBuilder();
        while(i<=j){
            //swap(i,j)
        sb= s1[i];
        s1[i]= s1[j];
        s1[j]= sb;
            i++;
            j--;
        }
        for(int x=0; x<=s1.length-1;x++){
            sx.append(s1[x]);
            if(x<s1.length-1){
                sx.append(" ");
            }

        }
        return sx.toString().trim();
    }
    
}