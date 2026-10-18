class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }        
        
        PriorityQueue<int []> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            heap.offer(new int[]{value, key});
            if(heap.size() > k ){
                heap.poll();
            }
        }

        int res [] = new int[k];
        for(int i=0; i< k ; i++){
            int [] arr = heap.poll();
            res[i] = arr[1];
        }
        return res;
    }
    
}