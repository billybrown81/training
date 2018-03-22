package leetcode301_400;

//311. Sparse Matrix Multiplication

public class N311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length;
        int l = A[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int k = 0; k < l; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < n; j++) {
						if (B[k][j] != 0) res[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
        return res;
    }
}
