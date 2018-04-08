package leetcode300_349;

import java.util.LinkedList;
import java.util.Queue;

//490. The Maze
public class N490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});
        while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int x = cur[0], y = cur[1];
				while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
					x += dir[i][0];
					y += dir[i][1];
				}
				x -= dir[i][0];
				y -= dir[i][1];
				if (visited[x][y]) continue;
				visited[x][y] = true;
				if (x == destination[0] && y == destination[1]) return true;
				queue.offer(new int[] {x, y});
			}
        }
        return false;
    }
}
