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
	
	public boolean isIn(int[][] arr, int[] point) {
		int x = point[0], y = point[1];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int x1 = arr[i][0], y1 = arr[i][1];
			int x2 = i < arr.length - 1? arr[i + 1][0] : arr[0][0];
			int y2 = i < arr.length - 1? arr[i + 1][1] : arr[0][1];
			if (y > Math.min(y1, y2) && y <= Math.max(y1, y2)) {
				if (y1 == y2) {
					if (x >= Math.min(x1, x2) && x <= Math.max(x1, x2)) return true;
					if (x < Math.min(x1, x2)) count++;
				} else if (x1 == x2) {
					if (x == x1) return true;
					if (x < x1) count++;
				} else {
					double k = ((double)y1 - (double)y2) / ((double)x1 - (double)x2), b = y1 - k * x1;
					double xCross = (y - b) / k;
					if (x == xCross) return true;
					if (x < xCross) count ++;
				}
			}
		}
		return count == 1;
	}
	
	public int numberOfClusters(List<List<Integer>> videoPlaylists) {
		Map<List<Integer>, List<Integer>> map = new HashMap<>();
		int count = videoPlaylists.size();
		for (List<Integer> list : videoPlaylists) {
			map.put(list, list);
		}
		for (int i = 0; i < videoPlaylists.size(); i++) {
			for (int j = 0; j < videoPlaylists.size(); j++) {
				if (i != j) {
					Set<Integer> tmp = new HashSet<>();
					for (Integer integer : videoPlaylists.get(i)) tmp.add(integer);
					for (Integer integer : videoPlaylists.get(j)) {
						if (tmp.contains(integer)) {
							if (!find(videoPlaylists.get(i), map).equals(find(videoPlaylists.get(j), map))) {
								map.put(find(videoPlaylists.get(i), map), find(videoPlaylists.get(j), map));
								count--;
							}
						}
					}
				}
			}
		}
		return count;		
	}

	private List<Integer> find(List<Integer> list, Map<List<Integer>, List<Integer>> map) {
		if (map.get(list) == list) {
			return list;
		}
		return find(map.get(list), map);
	}
	
	public int numberOfClusters2(List<List<Integer>> videoPlaylists)  {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> list : videoPlaylists) {
			int tmp = find2(list.get(0), map);
			for (int i = 1; i < list.size(); i++) {
				int cur = find2(list.get(i), map);
				if (tmp != cur) {
					map.put(cur, tmp);
					count--;
				}
			}
		}
		return count + map.size();
	}

	private int find2(Integer integer, Map<Integer, Integer> map) {
		if (!map.containsKey(integer)) map.put(integer, integer);
		if (integer == map.get(integer)) {
			return integer;
		}
		return find2(map.get(integer), map);
	}
}
