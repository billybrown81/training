package leetcode;

public class N713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0;
        int count = 0, l = 0, r = 0, cur = 1;
        while (r < nums.length) {
			cur *= nums[r];
			while (l <= r && cur >= k) {
				cur /= nums[l++];
			}
			count += r - l + 1;
			r++;
		}
        return count;
    }
}
