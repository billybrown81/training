package leetcode101_200;

public class N189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        if (k >= nums.length) k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++; j--;
		}
	}
}
