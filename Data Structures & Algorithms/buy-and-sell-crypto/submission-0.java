class Solution {
    public int maxProfit(int[] prices) {
    int l =0 ;
    int r = 1;

    int res = 0;
    while(l < r && r <= prices.length -1){
      if(prices[l] < prices[r]){
        int profit = prices[r] - prices[l];
        res = Math.max(res, profit);
      }else if(prices[l] > prices[r]){
        l = r;
      }
      r++;
    }
    return res;
  }
}
