package google_on_site;
//542. 01 Matrix

public class N542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        int m = matrix.length, n = matrix[0].length;
        int range = m * n;
        int update[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) update[i][j] = 0;
				else {
					int up = i > 0 ? update[i - 1][j] : range;
					int left = j > 0 ? update[i][j - 1] : range;
					update[i][j] = Math.min(up, left) + 1;
				}
			}
		}
        for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == 0) update[i][j] = 0;
				else {
					int down = i < m - 1 ? update[i + 1][j] : range;
					int right = j < n - 1 ? update[i][j + 1] : range;
					update[i][j] = Math.min(Math.min(down, right) + 1, update[i][j]);
				}
			}
		}
        return update;
    }
}
