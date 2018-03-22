package leetcode201_300;
//289. Game of Life
public class N289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int lives = countLives(board, row, col, i, j);
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3;
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] >>>= 1;
			}
        }
    }

	private int countLives(int[][] board, int row, int col, int i, int j) {
		int count = 0;
		for (int k = i > 0? i - 1 : 0; k <= (i < row - 1? i + 1 : row - 1); k++) {
			for (int l = j > 0? j - 1 : 0; l <= (j < col - 1? j + 1 : col - 1); l++) {
				count += board[k][l] & 1;
			}
		}
		count -= board[i][j] & 1;
		return count;
	}
}
