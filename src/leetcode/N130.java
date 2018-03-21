package leetcode;
import java.awt.Checkbox;

public class N130 {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) return;
        int rowSize = board.length, colSize = board[0].length;
        for (int i = 0; i < rowSize; i++) {
        		check(board, i, 0, rowSize, colSize);
        		check(board, i, colSize - 1, rowSize, colSize);
        }
        for (int j = 0; j < colSize; j++) {
        		check(board, 0, j, rowSize, colSize);
        		check(board, rowSize - 1, j, rowSize, colSize);
        }
        for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X'; 
			}
		}
        for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (board[i][j] == '1') board[i][j] = 'O'; 
			}
		}
    }

	private void check(char[][] board, int i, int j, int rowSize, int colSize) {
		if (board[i][j] == 'O') {
			board[i][j] = '1';
			if (i > 0) check(board, i - 1, j, rowSize, colSize);
			if (i < rowSize - 1) check(board, i + 1, j, rowSize, colSize);
			if (j > 0) check(board, i, j - 1, rowSize, colSize);
			if (j < colSize - 1) check(board, i, j + 1, rowSize, colSize);
		}	
	}
}
