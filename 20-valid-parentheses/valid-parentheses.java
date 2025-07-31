class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && ((c=='}' && st.peek()=='{') || (c==')' && st.peek()=='(') || (c==']' && st.peek()=='[') ) ){
                st.pop();
            }
            else{
                st.push(c);
            }
            
        }
        return st.isEmpty();

       /* Stack<Character> st= new Stack<>();
        char c;
        for(int i=0;i<s.length();i++){
            c= s.charAt(i);
            if(!st.isEmpty() && st.peek()=='(' && c==')'){
                st.pop();
            }
            else if(!st.isEmpty() && st.peek()=='{' && c=='}'){
                st.pop();
            }
            else if(!st.isEmpty() && st.peek()=='[' && c==']'){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false; */
    }
}