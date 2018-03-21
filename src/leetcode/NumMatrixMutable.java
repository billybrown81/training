package leetcode;
//308. Range Sum Query 2D - Mutable

public class NumMatrixMutable {
	int[][] nums;
	int[][] BIT;
	int m, n;
	
    public NumMatrixMutable(int[][] matrix) {
    		if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        
        BIT = new int[m + 1][n + 1];
        nums = matrix;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				updateBIT(i, j, nums[i][j]);
			}
		}
    }
    
    public void update(int row, int col, int val) {
    		if (m == 0 || n == 0) return;
        int diff = val - nums[row][col];
        nums[row][col] = val;
        updateBIT(row, col, diff);
    }
    
    private void updateBIT(int row, int col, int diff) {
		for (int i = row + 1; i <= m; i += i & -i) {
			for (int j = col + 1; j <= n; j += j & -j) {
				BIT[i][j] += diff;
			}
		}
	}	

    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    		if (m == 0 || n == 0) return 0;
        return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
    }
    
    private int getSum(int row, int col) {
		int sum = 0;
		for (int i = row + 1; i > 0; i -= i & -i) {
			for (int j = col + 1; j > 0; j -= j & -j) {
				sum += BIT[i][j];
			}
		}
		return sum;
	}
}
