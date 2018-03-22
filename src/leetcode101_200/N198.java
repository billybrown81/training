package leetcode101_200;

public class N198 {
    public int rob(int[] nums) {
    		if (nums == null || nums.length == 0) return 0;
    		int rob = 0, notrob = 0;
        for (int i = 0; i < nums.length; i++) {
			int cur = notrob + nums[i];
			notrob = Math.max(notrob, rob);
			rob = cur;
		}
        return Math.max(rob, notrob);
    }
}
