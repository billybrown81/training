package google_on_site;

import java.util.ArrayList;
import java.util.List;

public class RandomBS {
	public List<Integer> validElements(int[] arr) {
		int n = arr.length;
		boolean[] valid = new boolean[n];
		int leftMax = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > leftMax) {
				valid[i] = true;
				leftMax = arr[i];
			}
		}
		int rightMin = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] < rightMin) {
				rightMin = arr[i];
			} else {
				valid[i] = false;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < valid.length; i++) {
			if (valid[i]) {
				res.add(arr[i]);
			}
		}
		return res;
	}
}
