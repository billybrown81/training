package leetcode001_049;

public class N48 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < (size + 1) / 2; i++) {
			int len = size - 2 * i;
			for (int j = 0; j < len - 1; j++) {
				rotateCircle(matrix, i, j, size);
			}
		}
    }

	private void rotateCircle(int[][] matrix, int i, int j, int size) {
		int row = i, col = i + j;
		int temp = matrix[row][col];
		matrix[row][col] = matrix[size - 1 -col][row];
		matrix[size - 1 -col][row] = matrix[size - 1 - row][size - 1 - col];
		matrix[size - 1 - row][size - 1 - col] = matrix[col][size - 1 - row];
		matrix[col][size - 1 - row] = temp;
	}
}
