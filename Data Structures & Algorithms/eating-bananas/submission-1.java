class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int l =1;
    int r = 0;
    for(int pile: piles){
      r = Math.max(r, pile);
    }
    int minSpeed = Integer.MAX_VALUE;
    while(l<=r){
      int m = (l+r)/2;
      int time = 0;

      for(int pile: piles){
        time +=Math.ceil((double)pile/m);
      }
      if(time >h){
        l = m +1;
      }else if(time <= h){
        r = m-1;
        minSpeed = Math.min(minSpeed,m);
      }

    }
    return minSpeed;
  }
}
