class Solution {
    public int romanToInt(String s) {
        int n = s.length(), i = 0, ans = 0;
        while (i < n) {
            if (i + 1 < n) {
                String two = s.substring(i, i + 2);
                if (two.equals("CM")) {
                    ans += 900;
                    i += 2;
                    continue;
                }
                if (two.equals("CD")) {
                    ans += 400;
                    i += 2;
                    continue;
                }
                if (two.equals("XC")) {
                    ans += 90;
                    i += 2;
                    continue;
                }
                if (two.equals("XL")) {
                    ans += 40;
                    i += 2;
                    continue;
                }
                if (two.equals("IX")) {
                    ans += 9;
                    i += 2;
                    continue;
                }
                if (two.equals("IV")) {
                    ans += 4;
                    i += 2;
                    continue;
                }
            }
            char c = s.charAt(i++);
            if (c == 'M')
                ans += 1000;
            else if (c == 'D')
                ans += 500;
            else if (c == 'C')
                ans += 100;
            else if (c == 'L')
                ans += 50;
            else if (c == 'X')
                ans += 10;
            else if (c == 'V')
                ans += 5;
            else
                ans += 1; 
        }
        return ans;
    }
}