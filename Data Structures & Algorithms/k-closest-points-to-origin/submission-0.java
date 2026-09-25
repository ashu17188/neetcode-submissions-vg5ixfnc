class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int dist = x * x + y * y;
            heap.offer(new int[] {dist, x, y});
        }
        int res[][] = new int[k][2];

        for (int i = 0; i < k; i++) {
            int point[] = heap.poll();
            res[i] = new int[] {point[1], point[2]};
        }
        return res;
    }
}
