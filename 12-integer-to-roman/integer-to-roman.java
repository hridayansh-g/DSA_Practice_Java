class Solution {
    public String intToRoman(int num) {
         int[] numbers={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        int count=0;

        for(int i=0;i<numbers.length;i++){
            count = num/numbers[i];

            if(count>0){
                int c=count;
                while(c>0){
                    sb.append(symbols[i]);
                    c--;
                }

                num = num - numbers[i]*count;
            }

        }

        return sb.toString();
        // approach 2
        /*
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
        */


        // approach 1
      /*  int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] sym = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                sb.append(sym[i]);
                num -= vals[i];
            }
        }
        return sb.toString();
        */
    }
}