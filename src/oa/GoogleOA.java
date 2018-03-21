package oa;
import java.util.TreeSet;

public class GoogleOA {
	public static String nextClosestTime(String time) {
		int digits[] = {time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
		int now = (digits[0] * 10 + digits[1]) * 60 + digits[2] * 10 + digits[3];
		boolean used[] = new boolean[4];
		int[] res = new int[1];
		res[0] = now;
		int path[] = new int[4];
		DFSHelper(res, digits, path, used, now, 0);
		return String.format("%02d", res[0] / 60) + ":" + String.format("%02d", res[0] % 60);
	}

	private static void DFSHelper(int[] res, int[] digits, int[] path, boolean[] used, int now, int depth) {
		if (depth == 4) {
			int path_hour = path[0] * 10 + path[1];
			int path_minute = path[2] * 10 + path[3];
			if (path_hour > 23 || path_minute > 59) return;
			int cur = path_hour * 60 + path_minute;
			if (timeDiff(now, cur) < timeDiff(now, res[0])) {
				res[0] = cur;
			}
			return;
		}
		for (int i = 0; i < digits.length; i++) {
			if (!used[i]) {
				path[depth] = digits[i];
				used[i] = true;
				DFSHelper(res, digits, path, used, now, depth + 1);
				used[i] = false;
			}
		}
		
	}

	private static  int timeDiff(int t1, int t2) {
		if (t1 == t2) return Integer.MAX_VALUE;
		if (t1 < t2) return t2 - t1;
		else return t2 - t1 + 24 * 60;
	}
	
	public static int kEmptySlots(int[] flowers, int k) {
		int n = flowers.length;
		if (n == 0 || n <= k) return -1;
		TreeSet<Integer> bst = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			int x = flowers[i];
			bst.add(x);	
			Integer low = bst.lower(x);
			Integer high = bst.higher(x);
			if (low != null && low == x - k - 1) return i + 1;
			if (high != null && high == x + k + 1) return i + 1;
		}
		return -1;
	}
	
	public static int kFlowerFirst(int[] flowers, int k) {
		int n = flowers.length;
		if (n == 0 || n <= k) return -1;
		TreeSet<Integer> bst = new TreeSet<>();
		bst.add(0);
		bst.add(n + 1);
		for (Integer flower : flowers) bst.add(flower);
		for (int i = 0; i < n; i++) {
			int x = flowers[i];
			Integer low = bst.lower(x);
			Integer high = bst.higher(x);
			if (high - low == k + 1) return i + 1;
			bst.remove(x);
		}
		return -1;
	}
	
	public static int kFlowerLast(int[] flowers, int k) {
		int n = flowers.length;
		if (n == 0 || n <= k) return -1;
		TreeSet<Integer> bst = new TreeSet<>();
		bst.add(0);
		bst.add(n + 1);
		for (int i = n - 1; i >= 0; i--) {
			int x = flowers[i];
			bst.add(x);	
			Integer low = bst.lower(x);
			Integer high = bst.higher(x);
			if (low == x - k - 1) return i;
			if (high == x + k + 1) return i;
		}
		return -1;
	}
	
	public static int kSlotsLast(int[] flowers, int k) {
		int n = flowers.length;
		if (n == 0 || n <= k) return -1;
		TreeSet<Integer> bst = new TreeSet<>();
		for (Integer flower : flowers) bst.add(flower);
		for (int i = n - 1; i >= 0; i--) {
			int x = flowers[i];
			Integer low = bst.lower(x);
			Integer high = bst.higher(x);
			if (low != null && high != null && high - low == k + 1) return i;
			bst.remove(x);
		}
		return -1;
	}
	
	
}
