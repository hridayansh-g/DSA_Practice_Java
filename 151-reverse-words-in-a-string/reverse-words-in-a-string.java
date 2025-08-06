import java.util.*;
class Solution {
    /*public String reverse(char[] c2){
        int x=0; 
        int y=c2.length-1;
        char temp;
        while(x<y){
            //swap(c[x],c[y])
            temp= c2[x];
            c2[x]=c2[y];
            c2[y]=temp;
            x++;
            y--;
        }
        return new String(c2);


    } */
    public void reverse(char[] c, int start, int end){
        char temp;
        while(start<end){
            //swap(c[start], c[end])
            temp= c[start];
            c[start]= c[end];
            c[end]= temp;
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        char[] c= s.trim().replaceAll("\\s+"," ").toCharArray();

        reverse(c, 0, c.length-1);
        int start=0;
        for(int i=0;i<=c.length;i++){
            if(i== c.length || c[i]==' ' ){
                reverse(c,start, i-1);
                start= i+1;
               
            }
        }
 

        return new String(c);



       /* String[] s1= s.trim().split("\\s+");
        for(int i=0;i<s1.length;i++){
            s1[i]=reverse(s1[i].toCharArray());
        }

        String joined = String.join(" ", s1);        
        char[] c = joined.trim().toCharArray(); 
        int x=0; 
        int y=c.length-1;
        char temp;
        while(x<y){
            //swap(c[x],c[y])
            temp= c[x];
            c[x]=c[y];
            c[y]=temp;
            x++;
            y--;
        }

       String str = new String(c);
       return str;
*/
        //Using Stack
      /*  String[] s1= s.trim().split("\\s+");
        StringBuilder sb= new StringBuilder();
        Stack<String> st= new Stack<>();

        for(int i=0; i<s1.length;i++){
            st.push(s1[i]);

        }

        for(int i=0;i<s1.length;i++){
            sb.append(st.pop());
            if(i<s1.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();

        */

        /*
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
        return sx.toString().trim(); */
    }
    
}