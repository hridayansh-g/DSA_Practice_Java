class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> s = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                s.add("FizzBuzz");
            } 
            else if (i % 5 == 0 ) {
                s.add("Buzz");
            }
            else if (i % 3 == 0 ) {
                s.add("Fizz");
                
            }  
            else {
                s.add(Integer.toString(i));
            }

        }
        return s;
    }
}