package leetcode;
import java.util.Arrays;

public class N64 {
    public int minPathSum(int[][] grid) {
    		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
    		int m = grid.length;
    		int n = grid[0].length;
    		int[][] map = new int[m + 1][n + 1];
    		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1) {
					map[i][j] = grid[i - 1][j - 1] + map[i][j - 1];
				} else if (j == 1) {
					map[i][j] = grid[i - 1][j - 1] + map[i - 1][j];
				} else {
					map[i][j] = grid[i - 1][j - 1] + Math.min(map[i - 1][j], map[i][j - 1]);
				}
			}
		}
    		return map[m][n];
    }
}
