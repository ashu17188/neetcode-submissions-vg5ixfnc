class Solution {
    public int maxArea(int[] heights) {
        int l =0;
        int r = heights.length-1;
        int res = 0 ;
        while(l<r){
          int lHeight = heights[l];
          int rHeight = heights[r];

          int vol = (r -l) * (Math.min(lHeight, rHeight));
          res = Math.max(res, vol);
          if(lHeight < rHeight){
            l++;
          }else if(lHeight > rHeight){
            r--;
          }else{
            l++;
            r--;
          }

        }
        return res;
    }
}
