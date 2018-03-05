
public class N213 {
    public int rob(int[] nums) {
    		if (nums == null || nums.length == 0) return 0;
    		if (nums.length == 1) return nums[0];
    		return Math.max(robline(nums, 0, nums.length - 2), robline(nums, 1, nums.length - 1));
    }
    
    public int robline(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0) return 0;
		int rob = 0, notrob = 0;
    for (int i = start; i <= end; i++) {
		int cur = notrob + nums[i];
		notrob = Math.max(notrob, rob);
		rob = cur;
	}
    return Math.max(rob, notrob);
}
}
