class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row[] = new int[9];
        int col[] = new int[9];
        int square[] = new int[9];

        for(int r=0; r< board.length; r++){
            for(int c=0; c< board[0].length; c++){
                if(board[r][c] == '.'){
                    continue;
                }

                int val = board[r][c] - '1';

                if((row[r] & (1<< val)) >0 ||
                (col[c] & (1<<val)) >0 ||
                (square[(r/3)*3 + c/3] & (1 << val)) >0 ){
                    return false;
                }

                row[r] |= 1<<val;
                col[c] |= 1<< val;
                square[ (r/3)*3 + c/3] |= 1<<val;

            }
            
        }
        return true;
    }
}
