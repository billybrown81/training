package leetcode;

public class N280 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
			int prev = nums[i - 1];
			if ((i % 2 == 1) == (prev > nums [i])) {
				nums[i - 1] = nums[i];
				nums[i] = prev;
			}
		}
    }
}
