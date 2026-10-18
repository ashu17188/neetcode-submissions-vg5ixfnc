class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            arr.add(new int[]{value, key});
        }
        arr.sort((a,b) -> b[0] - a[0]);

        int res[] = new int[k];
        for(int i=0; i< k; i++){
            res[i] = arr.get(i)[1];
        }
        return res;

    }
}
