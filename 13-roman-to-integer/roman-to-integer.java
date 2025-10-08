class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hp = new HashMap<>();
        hp.put('I', 1);
        hp.put('V', 5);
        hp.put('X', 10);
        hp.put('L', 50);
        hp.put('C', 100);
        hp.put('D', 500);
        hp.put('M', 1000);
        int sum = 0;
        char current;
        char next;
        for (int i = 0; i < s.length()-1; i++) {
            current = s.charAt(i);
            
            next =  s.charAt(i + 1);

            if (hp.get(current) < hp.get(next)) {
                sum -= hp.get(current);
            } else {
                sum += hp.get(current);
            }

        }
        sum += hp.get(s.charAt(s.length() - 1));
        return sum;
    }
}