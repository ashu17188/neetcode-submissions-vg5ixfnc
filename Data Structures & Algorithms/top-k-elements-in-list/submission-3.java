class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
    }

    List<Integer>[] freq = new List[nums.length + 1];
    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }

    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();

      freq[value].add(key);
    }

    int res[] = new int[k];
    int index = 0;
    for (int i = freq.length - 1; i > 0; i--) {

      for (int n : freq[i]) {
        res[index++] = n;
        if (index >= k) {
          return res;
        }

      }
    }
    return res;
  }
   
}
    
