class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        HashMap<Character, Character> h1= new HashMap<>();
        HashMap<Character, Character> h2= new HashMap<>();
        char c1,c2;
        for(int i=0; i<s.length();i++){
            c1= s.charAt(i);
            c2= t.charAt(i);

            //ascending
            if(!h1.containsKey(c1)){
                h1.put(c1,c2);
            }
            else{
                if(h1.get(c1) != c2){
                    return false;
                }
            }

            //descending
             if(!h2.containsKey(c2)){
                h2.put(c2,c1);
            }
            else{
                if(h2.get(c2) != c1){
                    return false;
                }
            }


        }
        return true;
    }
}