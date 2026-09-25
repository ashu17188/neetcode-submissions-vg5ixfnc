class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return -1;
        }
        Queue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < stones.length; i++) {
            heap.offer(-1 * stones[i]);
        }

        while (heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();

            int diff = Math.abs(s1 - s2);
            if (diff > 0) {
                heap.offer(-1 * diff);
            }
        }
        return heap.isEmpty() ? 0 : -1 * heap.peek();
    }
}
