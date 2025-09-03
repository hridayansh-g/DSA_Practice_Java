class Solution {
    public int maxProfit(int[] prices) { 
       int buy, sell;
        buy= prices[0];
        int maxProfit=0;
        int profit=0;
        for(int i=1;i<prices.length;i++){
            sell=prices[i];
            if(buy<sell){
                profit= sell-buy;
                maxProfit= Math.max(maxProfit, profit);
            }
            else{
                buy=sell;
            }

        }
return maxProfit;

    /*    int min= prices[0];
        int profit=0;
        int maxProfit=0;
        for(int i=1; i<prices.length;i++){
            profit= prices[i]-min;
            maxProfit= Math.max(profit, maxProfit);
            if(prices[i]<min){
                min= prices[i];
            }
        }
        return maxProfit;
        */
    

    /*    int min=Integer.MAX_VALUE;
        int minIndex=-1;
        int maxProfit=0;
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min= prices[i];
                minIndex=i;
            }
        }
        for(int i=  minIndex+1;i<prices.length;i++){
            profit=prices[i]- min;
            maxProfit= Math.max(profit, maxProfit);
        }
        return maxProfit;

        */

/*
        int maxProfit=0;
        int profit=0;
        int i=0;
        int j=prices.length-1;
        while(i<=j){
            if(prices[i]<prices[j]){
                profit= prices[j]- prices[i];
                maxProfit= Math.max(maxProfit, profit);
                j--;
            }
            else if(prices[i]>prices[j]){
                i++;
                continue;
            }
            else{
                j--;
            }
        }
    return maxProfit;
    */

    /*    int maxP=0;
        int diff;
        for(int i=0; i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                diff= prices[j]- prices[i];
                maxP= Math.max(maxP, diff);
            }
        }
        return maxP;
        */
    }
}