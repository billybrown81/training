package leetcode201_300;

public class N221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, res = 0, helper[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					helper[i][j] = Math.min(Math.min(helper[i - 1][j - 1], helper[i - 1][j]), helper[i][j - 1]) + 1;
					res = Math.max(res, helper[i][j]);
				}
			}
		}
        return res * res;
    }
}
