class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int steps = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }

                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                        && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] {nr, nc});
                        fresh--;
                    }
                }
            }
            steps++;
        }
        return fresh == 0 ? steps : -1;
    }
}
