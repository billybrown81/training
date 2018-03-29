package leetcode050_099;

public class N53 {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int[] sub = new int[size];
        sub[0] = nums[0];
        int max = sub[0];
        for (int i = 1; i < size; i++) {
			sub[i] = nums[i] + (sub[i - 1] > 0 ? sub[i - 1] : 0);
			max = Math.max(max, sub[i]);
		}
        return max;
    }
}
