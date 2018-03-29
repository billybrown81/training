package leetcode001_049;

public class N35 {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        if (nums.length == 0) {
			return 0;
		}
        while (i < nums.length && target > nums[i]) {
			i++;
		}
        return i;
    }
}
