package leetcode400_449;
//417. Pacific Atlantic Water Flow
//Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
//Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//
//Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
//
//Note:
//The order of returned grid coordinates does not matter.
//Both m and n are less than 150.
//Example:
//
//Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
//Return:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N417 {
	int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
    		List<int[]> res = new ArrayList<>();
    		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    		int m = matrix.length, n = matrix[0].length;
        Queue<int[]> qp = new LinkedList<>();
        Queue<int[]> qa = new LinkedList<>();
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; i++) {
			qp.offer(new int[] {i, 0});
			qa.offer(new int[] {i, n - 1});
			p[i][0] = true;
			a[i][n - 1] = true;
		}
        for (int i = 0; i < n; i++) {
			qp.offer(new int[] {0, i});
			qa.offer(new int[] {m - 1, i});
			p[0][i] = true;
			a[m - 1][i] = true;
		}
        BFSHelper(matrix, m, n, qp, p);
        BFSHelper(matrix, m, n, qa, a);
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (p[i][j] && a[i][j]) {
					res.add(new int[] {i, j});
				}
			}
		}
        return res;
    }

	private void BFSHelper(int[][] matrix, int m, int n, Queue<int[]> queue, boolean[][] visited) {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int x = cur[0] + dir[i][0];
				int y = cur[1] + dir[i][1];
				if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) continue;
				visited[x][y] = true;
				queue.offer(new int[] {x, y});
			}
		}
	}
}
