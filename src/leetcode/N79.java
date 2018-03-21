package leetcode;

public class N79 {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exist1(board, i, j, w, 0)) {
					return true;
				}
			}
		}
        return false;
    }

	private boolean exist1(char[][] board, int i, int j, char[] w, int index) {
		if (index == w.length) {
			return true;
		}
		if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
			return false;
		}
		if (board[i][j] != w[index]) {
			return false;
		}
		char tmp = board[i][j];
		boolean exist;
		board[i][j] = '!';
		exist =  exist1(board, i - 1, j, w, index + 1) || exist1(board, i + 1, j, w, index + 1) || exist1(board, i, j - 1, w, index + 1) || exist1(board, i, j + 1, w, index + 1);	
		board[i][j] = tmp;
		return exist;
	}
}
