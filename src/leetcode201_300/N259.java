package leetcode201_300;
import java.util.Arrays;

public class N259 {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
			int start = i + 1, end = n - 1;
			while (start < end) {
				if (nums[i] + nums[start] + nums[end] < target) {
					count += end - start;
					start++;
				} else {
					end--;
				}
			}
		}
        return count;
    }
}
