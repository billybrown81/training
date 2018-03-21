package leetcode301_400;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N305 {
	int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    		List<Integer> res = new ArrayList<>();
        if (m < 0 || n < 0) return res;
        
        int count = 0;
        int roots[] = new int[m * n];
        Arrays.fill(roots, -1);
        
        for (int[] p : positions) {
			int root = p[0] * n + p[1];
			roots[root] = root;
			count++;
			
			for (int[] d : direction) {
				int x = p[0] + d[0], y = p[1] + d[1];
				int tmp = n * x + y;
				if (x < 0 || x >= m || y < 0 || y >= n || roots[tmp] == -1) continue;
				int rootTmp = findRoot(roots, tmp);
				if (rootTmp != root) {
					roots[root] = rootTmp;
					root = rootTmp;
					count--;
				}
			}
			res.add(count);
		}
        return res;
    }
	private int findRoot(int[] roots, int tmp) {
		while (roots[tmp] != tmp) {
			roots[tmp] = roots[roots[tmp]];
			tmp = roots[tmp];
		}
		return tmp;
	}
}
