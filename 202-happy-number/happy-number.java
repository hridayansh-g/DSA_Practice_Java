class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> h= new HashSet<>();

        while(n >0){
            n= extra(n);
            if(n==1){
                return true;
            }

            if(h.contains(n)){
                break;
            }
            else{
                h.add(n);
            }

           
            
        }
        return false;
    }
    private int extra(int n){
        int sum=0;
        while(n > 0){
            int x= n%10;
            sum += x*x;
            n=n/10;
        }
        return sum;
    }
}