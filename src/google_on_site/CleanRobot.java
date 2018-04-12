package google_on_site;

import java.util.concurrent.CountDownLatch;

public class CleanRobot {
	int dir_h;
	int dir_v;
	int pos_h;
	int pos_v;
	int[][] room;
	int numToClean;
	boolean[][] visited;
	public CleanRobot(int x, int y) {
		dir_h = 0;
		dir_v = 1;
		pos_h = x;
		pos_v = y;
		numToClean = 0;
	}
	public void setRoom(int[][] matrix) {
		room = matrix;
		visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					numToClean++;
				}
			}
		}
	}
	public boolean move() {
		int x = pos_h + dir_h, y = pos_v + dir_v;
		if (x < 0 || x >= room[0].length) return false;
		if (y < 0 || y >= room.length) return false;
		if (room[x][y] == -1) return false;
		pos_h = x;
		pos_v = y;
		return true;
	}
	public void turnLeft() {
		if (dir_h == 0) {
			if (dir_v == 1) dir_h = -1;
			else dir_h =  1;
			dir_v = 0;
		} else {
			if (dir_h == 1) dir_v = 1;
			else dir_v = -1;
			dir_h = 0;
		}
	}
	public void turnRight() {
		if (dir_h == 0) {
			if (dir_v == 1) dir_h = 1;
			else dir_h =  -1;
			dir_v = 0;
		} else {
			if (dir_h == 1) dir_v = -1;
			else dir_v = 1;
			dir_h = 0;
		}
	}
	public void clean() {
		System.out.println("Clean " + pos_h + pos_v);
	}
	public void cleanAll() {
		if (numToClean == 0) {
			System.out.println("Finish!");
			return;
		}
		
	}
}
