class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length ==0){
            return 0;
        }
        int maxProfit = 0;
        int minBuy = prices[0];
        for(int price : prices){
            int profit = price - minBuy;
            maxProfit = Math.max(maxProfit, profit);
            minBuy = Math.min(minBuy, price);
        }
        return maxProfit;
    }
}
