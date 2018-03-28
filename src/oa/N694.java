package oa;
//694. Number of Distinct Islands

import java.util.HashSet;
import java.util.Set;

public class N694 {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					DFSHelper(grid, i, j, sb, 'o');
					set.add(sb.toString());
				}
			}
		}
        return set.size();
    }

	private void DFSHelper(int[][] grid, int i, int j, StringBuilder sb, char dir) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
		sb.append(dir);
		grid[i][j] = 0;
		DFSHelper(grid, i - 1, j, sb, 'u');
		DFSHelper(grid, i + 1, j, sb, 'd');
		DFSHelper(grid, i, j - 1, sb, 'l');
		DFSHelper(grid, i, j + 1, sb, 'r');
		sb.append('b');
	}
}
