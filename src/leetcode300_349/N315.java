package leetcode300_349;
//315. Count of Smaller Numbers After Self

import java.util.ArrayList;
import java.util.List;

public class N315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int n = nums.length;
        int count[] = new int[n], index[] = new int[n];
        for (int i = 0; i < n; i++) index[i] = i;
        sort(nums, index, count, 0, n - 1);
        for (int i : count) res.add(i);
        return res;
    }

	private void sort(int[] nums, int[] index, int[] count, int i, int j) {
		if (i == j) return;
		int m = (i + j) / 2;
		sort(nums, index, count, i, m);
		sort(nums, index, count, m + 1, j);
		merge(nums, index, count, i, m, j);
	}

	private void merge(int[] nums, int[] index, int[] count, int i, int m, int j) {
		int countRight = 0;
		int left = i, right = m + 1, k = 0;
		int new_index[] = new int[j - i + 1];
		while (left <= m && right <= j) {
			if (nums[index[left]] <= nums[index[right]]) {
				new_index[k] = index[left];
				count[index[left]] += countRight;
				left++;
			} else {
				new_index[k] = index[right];
				countRight++;
				right++;
			}
			k++;
		}
		
		while (left <= m) {
			new_index[k] = index[left];
			count[index[left]] += countRight;
			left++;
			k++;
		}
		
		while (right <= j) {
			new_index[k++] = index[right++];
		}
		
		for (int l = i; l <= j; l++) {
			index[l] = new_index[l - i];
		}
	}
}
