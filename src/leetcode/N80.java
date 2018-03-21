package leetcode;

public class N80 {
    public int removeDuplicates(int[] nums) {
    		int len = nums.length;
    		if (len <= 2) {
				return len;
			}
        int res = 2;
        for (int i = 2; i < len; i++) {
			if (nums[i] != nums[i - 1]) {
				res += 1;
				if (i != res - 1) {
					nums[res - 1] = nums[i];
				}
			} else if (nums[i] != nums[i - 2]) {
				res += 1;
				if (i != res - 1) {
					nums[res - 1] = nums[i];
				}
			}
		}
        return res;
    }
}