class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

    int row = selectRow(matrix, target);
    if(row == -1){
      return false;
    }
    int col = matrix[0].length;

    int l = 0;
    int r = matrix[0].length;
    while (l <= r) {
      int m = (l + r) / 2;

      if (matrix[row][m] > target) {
        r--;
      } else if (matrix[row][m] < target) {
        l++;
      } else {
        return true;
      }
    }
    return false;
  }

  private int selectRow(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;

    int top = 0;
    int bot = row - 1;

    while (top <= bot) {
      int m = (top + bot) / 2;
      if (matrix[m][col - 1] < target) {
        top++;
      } else if (matrix[m][0] > target) {
        bot--;
      } else {
        return m;
      }
    }
    return -1;
  }
}
