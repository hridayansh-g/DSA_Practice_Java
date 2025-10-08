import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hp= new HashMap<>();
        for(String s: strs){
            int[] arr= new int[26];
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                arr[c-'a']++;
            }
            StringBuilder sb= new StringBuilder();
            for(int x: arr){
                sb.append('#');
                sb.append(x+"");
            }
            String key= sb.toString();
            if(!hp.containsKey(key)){
                hp.put(key, new ArrayList<String>());
            }
            hp.get(key).add(s);
            
        }
        return new ArrayList<>(hp.values());
    }
}