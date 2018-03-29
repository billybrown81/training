package leetcode250_299;

public class N283 {
    public void moveZeroes(int[] nums) {
        int i = 0, start = 0;
        while (i < nums.length) {
			while (i < nums.length && nums[i] == 0) i++;
			if (i != start && i < nums.length) swap(nums, i, start);
			start++;
			i++;
		}
    }

	private void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
