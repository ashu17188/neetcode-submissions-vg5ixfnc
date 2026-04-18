class Solution {
    public int findMin(int[] nums) {
    int l =0;  int r = nums.length -1;
    int res = Integer.MAX_VALUE;
    while(l<=r && l< nums.length && r>= 0 ) {
        if(nums[l] <nums[r]){
            res = Math.min(res, nums[l]);
            break;
        }

      int m = (l + r)/2;
      res = Math.min(res, nums[m]);

      if(nums[l] <= nums[m]){
        l = m+1;
      }else{
        r = m-1;
      }

    }
    return res;
  }
}
