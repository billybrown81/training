package leetcode201_300;
import java.util.ArrayList;
import java.util.List;

//296. Best Meeting Point
public class N296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					I.add(i);
				}
			}
		}
        for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == 1) {
					J.add(i);
				}
			}
		}
        return minDistance(I) + minDistance(J);
    }

	private int minDistance(List<Integer> list) {
		int start = 0, end = list.size() - 1;
		int res = 0;
		while (start < end) {
			res += list.get(end--) - list.get(start++);
		}
		return res;
	}
}
