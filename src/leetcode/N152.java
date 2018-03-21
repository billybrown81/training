package leetcode;

public class N152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = res, min = res;
        for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(max * nums[i], nums[i]);
			min = Math.min(min * nums[i], nums[i]);
			res = Math.max(res, max);
		}
        return res;
    }
}
