package leetcode300_349;
//327. Count of Range Sum

public class N327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long sums[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
			sums[i] += sums[i - 1] + nums[i - 1];
		}
        return countMergeSort(sums, 0, n + 1, lower, upper);
    }

	private int countMergeSort(long sums[], int start, int end, int lower, int upper) {
		if (end <= start + 1) return 0;
		int mid = (start + end) / 2;
		int count = countMergeSort(sums, start, mid, lower, upper) + countMergeSort(sums, mid, end, lower, upper);
		int j = mid, k = mid, l = mid;
		long cache[] = new long[end - start];
		for (int i = start, r = 0; i < mid; i++, r++) {
			while (k < end && sums[k] - sums[i] < lower) k++;
			while (j < end && sums[j] - sums[i] <= upper) j++;
			while (l < end && sums[l] < sums[i]) cache[r++] = sums[l++];
			cache[r] = sums[i];
			count += j - k;
		}
		System.arraycopy(cache, 0, sums, start, l - start);
		return count;
	}
}
