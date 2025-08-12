class Solution {
    public double myPow(double x, int n) {

         long e = n;
        if (e < 0) { x = 1.0 / x; e = -e; }
        double ans = 1.0, cur = x;
        while (e > 0) {
            if ((e & 1L) == 1L) ans *= cur;
            cur *= cur;
            e >>= 1;
        }
        return ans;

      /*  long exp = n;
        double res = 1.0;
        if (exp < 0) {
            exp = -exp;
            x = 1 / x;
        }
        for (long i = 0; i < exp; i++) {
            res *= x;
        }
        return res; */
    }
}