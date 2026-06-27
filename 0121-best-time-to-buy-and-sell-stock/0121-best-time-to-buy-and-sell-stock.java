class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i=0;i<prices.length;i++){
            int curProfit = prices[i] - buyPrice;
            if(maxProfit<curProfit){
                maxProfit = curProfit;
            }
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}