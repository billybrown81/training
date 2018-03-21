package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class N683 {
	public static int kEmptySlots(int[] flowers, int k) {
		int n = flowers.length;
		if (n == 0 || n <= k) return -1;
		k++;
		int buckets = (n + k - 1) / k;
		Map<Integer, Integer> high = new HashMap<>();
		Map<Integer, Integer> low = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int x = flowers[i];
			int p = x / k;
			if (!low.containsKey(p) || x < low.get(p)) {
				low.put(p, x);
				if (p > 0 &&
						high.containsKey(p - 1) && 
						high.get(p - 1) == x - k) return i + 1;
			}
			if (!high.containsKey(p) || x > high.get(p)) {
				high.put(p, x);
				if (p < buckets - 1 &&
						low.containsKey(p + 1) && 
						low.get(p + 1) == x + k) return i + 1;
			}
		}
		return -1;
	}
	
	public static int kEmptySlots2(int[] flowers, int k) {
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
}
