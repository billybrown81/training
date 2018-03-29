package leetcode200_249;

public class N200 {
    public int numIslands(char[][] grid) {
        if (grid == null ||grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					connect(grid, i ,j ,rows, cols); 
					count += 1;
				}
			}
		}
        return count;
    }

	private void connect(char[][] grid, int i, int j, int rows, int cols) {
		if (grid[i][j] == '1') {
			grid[i][j] = 'X';
			if (i > 0) connect(grid, i - 1, j, rows, cols);
			if (i < rows - 1) connect(grid, i + 1, j, rows, cols);
			if (j > 0) connect(grid, i, j - 1, rows, cols);
			if (j < cols - 1) connect(grid, i, j + 1, rows, cols);
		}
	}
}
