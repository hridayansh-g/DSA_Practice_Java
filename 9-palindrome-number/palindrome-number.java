class Solution {
    public boolean isPalindrome(int x) {
        
        int temp=x;
        int sum=0;
        int y;
        while(x>0){
            y= x%10;
            sum = (sum*10) +y;
            x /= 10;
        }
        if(sum== temp)
        {
            return true;
        }
        return false;

        // by string
      /*  String s= Integer.toString(x);
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    */
    }
}