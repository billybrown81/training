package leetcode201_300;

public class N268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0, sum2 = n;
        for (int i = 0; i < n; i++) {
			sum1 += nums[i];
			sum2 += i;
		}
        return sum2 - sum1;
    }
}
