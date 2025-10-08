import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else if(!st.isEmpty() && c==')' && st.peek()=='('){
                st.pop();
            }
            else if(!st.isEmpty() && c=='}' && st.peek()=='{'){
                st.pop();
            }
            else if(!st.isEmpty() && c==']' && st.peek()=='['){
                st.pop();
            }
            else{
               st.push(c);
            }
           
        }
        return st.isEmpty() ? true : false;
        
    }
}