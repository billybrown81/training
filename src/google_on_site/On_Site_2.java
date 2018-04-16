package google_on_site;

import java.util.HashMap;
import java.util.Map;

public class On_Site_2 {
	public int lengthOfSubfixEqualsPrefix(int[] A, int[] B) {
		int a = A.length, b = B.length;
		int[] kmp = new int[a + b];
		int len = 0;
		int i = 1;
		while (i < a + b) {
			int[] cur = i < b ? B: A;
			int idx = i < b? i : i - b;
			if (cur[idx] == B[len]) {
				len++;
				kmp[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = kmp[len - 1];
				} else {
					kmp[i] = len;
					i++;
				}
			}
		}
		return kmp[a + b - 1];
	}
	
	public int countSquares(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] dp = grid;
		int count = 0;
		for (int len = 1; len < Math.min(m, n); len++) {
			for (int i = len; i < m; i++) {
				for (int j = len; j < n; j++) {
					if (grid[i][j] == 0 && grid[i - 1][j] == 0 && grid[i][j - 1] == 0 && grid[i - 1][j - 1] == 0) {
						count++;
					} else {
						dp[i][j] = 1;
					}
				}
			}
			grid = dp;
			dp = new int[m][n];
		}
		return count;
	}
	
	public boolean canDivideByK(int[] arr, int k) {
		int n = arr.length;
		if (n % k != 0) return false;
		Map<Integer, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : arr) {
			min = Math.min(min, i);
			max = Math.max(max, i);
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		while (!map.isEmpty()) {
			int tmp = min;
			for (int i = 0; i < k; i++) {
				if (!map.containsKey(tmp + i)) return false;
				map.put(tmp + i, map.get(tmp + i) - 1);
				if (map.get(tmp + i) == 0) map.remove(tmp + i);
			}
			if (!map.containsKey(min) && map.containsKey(max)) {
				while (min < max && !map.containsKey(min)) {
					min++;
				}
			}
		}
		return true;
	}
}
