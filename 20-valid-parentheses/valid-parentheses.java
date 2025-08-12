class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        char c;
        for(int i=0; i<s.length();i++){
            c= s.charAt(i);
            if(!st.isEmpty()){
                if(st.peek()=='(' && c==')'){
                    st.pop();
                } else if(st.peek()=='{' && c=='}'){
                    st.pop();
                } else if(st.peek()=='[' && c==']'){
                    st.pop();
                } else{
                    st.push(c);
                }

                
            }
            else{
                st.push(c);
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}