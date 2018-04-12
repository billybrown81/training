package google_on_site;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class On_Site {
	public boolean isSubsequence(String a, String b) {
		int i = 0;
		for (int j = 0; i < a.length() && j < b.length(); j++) {
			if (a.charAt(i) == b.charAt(j)) i++;
		}
		return i == a.length();
	}
	
	public int minTwoes(int N) {
		int count = 0, n = N;
		while (n > 0) {
			if ((n & 1) == 1) count++;
			n >>>= 1;
		}
		return count;
	}
	
	public int minTwoesN(int N) {
		int res = minTwoes(N);
		int n = 1;
		while (n < N) {
			n *= 2;
		}
		res = Math.min(res, minTwoes(n) + minTwoes(n - N));
		return res;
	}
	
	public boolean containsSublist(List<Integer> list, Set<Integer> set) {
		int start = 0, end = 0;
		while (end < list.size() && set.size() > 0) {
			int cur = list.get(end);
			if (set.contains(cur)) {
				set.remove(cur);
			} else {
				while (start < end && !set.contains(cur)) {
					set.add(list.get(start));
					start++;
				}
				if (!set.contains(cur)) {
					start++;
				}
			}
			end++;
		}
		return set.size() == 0;
	}
	
//	class Pair{
//		int x;
//		int y;
//		public Pair(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
	public boolean hasRec(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					for (int k = j + 1; k < n; k++) {
						if (matrix[i][k] == 1) {
							if (map.containsKey(j) && map.get(j).contains(k)) return true;
							if (!map.containsKey(j)) map.put(j, new HashSet<>());
							map.get(j).add(k);
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean areBuddies(String a, String b) {
		int m = a.length(), n = b.length();
		if (m != n) return false;
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			char x = a.charAt(i), y = b.charAt(i);
			if (x != y) {
				count++;
				if (count > 2) return false;
				map.put(x, map.getOrDefault(x, 0) + 1);
				map.put(y, map.getOrDefault(y, 0) - 1);
			}
		}
		Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue() != 0) return false;
		}
		return true;
	}
	
	public boolean areBuddiesN(String a, String b, int N) {
		int m = a.length(), n = b.length();
		if (m != n) return false;
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			char x = a.charAt(i), y = b.charAt(i);
			if (x != y) {
				count++;
				if (count > N) return false;
				map.put(x, map.getOrDefault(x, 0) + 1);
				map.put(y, map.getOrDefault(y, 0) - 1);
			}
		}
		if (count != N) return false;
		Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue() != 0) return false;
		}
		return true;
	}
	
	public double p21() {
		double[] dp = new double[22];
		for (int i = 1; i <= 10; i++) {
			dp[i] = 1 / 10.0;
			for (int j = 1; j < i; j++) {
				dp[i] += dp[j] / 10.0;
			}
		}
		for (int i = 11; i <= 21; i++) {
			for (int j = i - 10; j < i; j++) {
				dp[i] += dp[j] / 10.0;
			}
		}
		return 1 - dp[17] - dp[18] - dp[19] - dp[20] - dp[21];
	}
}
