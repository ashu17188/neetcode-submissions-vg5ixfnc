class Solution {
    int ROWS = 0;
    int COLS = 0;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if ((r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1) && board[r][c] == 'O') {
                    capture(r, c, board);
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(int r, int c, char[][] board) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(r + 1, c, board);
        capture(r - 1, c, board);
        capture(r, c + 1, board);
        capture(r, c - 1, board);
    }
}
