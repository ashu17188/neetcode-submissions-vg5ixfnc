class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    if(nums.length == 0){
      return Collections.emptyList();
    }

    Arrays.sort(nums);
    Set<List<Integer>> res = new LinkedHashSet<>();

    for(int i=0; i<nums.length; i++){
      int a = nums[i];

      int l = i+1;
      int r = nums.length -1;

      while(l<r){


        int threeSum = a + nums[l] + nums[r];
        if(threeSum > 0){
          r--;
        }else if(threeSum < 0){
          l++;
        }else{
          List<Integer> temp = new ArrayList<>();
          temp.add(a);
          temp.add(nums[l]);
          temp.add(nums[r]);
          res.add(temp);
          l++;
          r--;
        }

      }
    }
    return res.stream().toList();
  }
}
