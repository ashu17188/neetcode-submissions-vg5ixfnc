class Solution {
    record Pair<T, U>(T first, U second) {}

    Set<Pair<Integer, Integer>> visit = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
            || visit.contains(new Pair(r, c)) || board[r][c] !=word.charAt(i)) {
            return false;
        }
        visit.add(new Pair(r, c));

        boolean res = dfs(board, word, r + 1, c, i + 1) || dfs(board, word, r - 1, c, i + 1)
            || dfs(board, word, r, c + 1, i + 1) || dfs(board, word, r, c - 1, i + 1);

        visit.remove(new Pair(r, c));

        return res;
    }
}
