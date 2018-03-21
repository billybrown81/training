package leetcode;

public class N209 {
    public int minSubArrayLen(int s, int[] nums) {
    		if (nums == null || nums.length == 0) return 0;
        int len = nums.length, start = 0, end = 0, sum = nums[0], res = Integer.MAX_VALUE;
        while (true) {
			if (sum < s) {
				if (++end == len) break;
				sum += nums[end];
			} else {
				res = Math.min(res, end - start + 1);
				sum -= nums[start];
				start++;
				if (start > end) end++;
				if (start == len || end == len) break;
			}
		}
        if (res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}
