import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> fin= new ArrayList<>();
        int x;
        for(int i=0;i<numRows;i++){
            List<Integer> li= new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    li.add(1);
                }
                else{
                   x=fin.get(i-1).get(j-1)+ fin.get(i-1).get(j);
                   li.add(x);
                }
            }
            fin.add(li);
        }
            return fin;
        }
        
    }
