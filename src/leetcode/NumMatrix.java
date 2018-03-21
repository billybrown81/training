package leetcode;
//304. Range Sum Query 2D - Immutable

public class NumMatrix {
	int[][] board;
	
    public NumMatrix(int[][] matrix) {
    		board = matrix;
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int left = j == 0? 0 : board[i][j - 1];
				int top = i == 0? 0: board[i - 1][j];
				int diagnol = (i == 0 || j == 0)? 0 : board[i - 1][j - 1];
				board[i][j] += left + top - diagnol;
			}
		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1 == 0? 0 : board[row2][col1 - 1];
        int top = row1 == 0? 0 : board[row1 - 1][col2];
        int diagnol = (row1 == 0 || col1 == 0)? 0 : board[row1 - 1][col1 - 1];
        return board[row2][col2] - left - top + diagnol;
    }
}
