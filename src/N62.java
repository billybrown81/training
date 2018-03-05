
public class N62 {
    public int uniquePaths(int m, int n) {
        int row = 1, col = 1;
        return countPaths(row, col, m, n);
    }

	private int countPaths(int row, int col, int m, int n) {
		if (row == m || col == n) {
			return 1;
		}
		return countPaths(row + 1, col, m, n) + countPaths(row, col + 1, m, n);
	}
	
	public int uniquePaths2(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					grid[i][j] = 1;
				} else {
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
				}
			}
		}
        return grid[m - 1][n - 1];
    }
}
