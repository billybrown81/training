package leetcode200_249;

public class N215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low < high) {
			int j = partition(nums, low, high);
			if (j < k) low = j + 1;
			else if (j > k) high = j - 1;
			else break;
		}
        return nums[k];
    }

	private int partition(int[] nums, int low, int high) {
		int i = low, j = high + 1;
		while (true) {
			while (i < high && nums[++i] < nums[low]);
			while (i > low && nums[low] < nums[--j]);
			if (i >= j) break;
			exchange(nums, i, j);
		}
		exchange(nums, low, j);
		return j;
	}

	private void exchange(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
