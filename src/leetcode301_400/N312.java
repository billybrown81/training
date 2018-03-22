package leetcode301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N312 {
    public int maxCoins(int[] nums) {
    		if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int num : nums) list.add(num);
        list.add(1);
        Map<List<Integer>, Integer> map = new HashMap<>();
        return DFSHelper(list, map);
    }
	private int DFSHelper(List<Integer> list, Map<List<Integer>, Integer> map) {
		if (map.containsKey(list)) return map.get(list);
		int n = list.size();
		if (n == 2) return 0;
		int max = 0;
		for (int i = 1; i < n - 1; i++) {
			int coin = list.get(i);
			int tmp = coin * list.get(i - 1) * list.get(i + 1);
			list.remove(i);
			int sum = tmp + DFSHelper(list, map);
			list.add(i, coin);
			max = Math.max(sum, max);
		}
		map.put(list, max);
		return max;
	}

    public int maxCoins2(int[] nums) {
		int[] newNums = new int[nums.length + 2];
		int n = 1;
		for (int i : nums) {
			if (i > 0) newNums[n++] = i;
		}
		newNums[0] = newNums[n++] = 1;
		int[][] memo = new int[n][n];
		return burst(memo, newNums, 0, n - 1);
    }
	private int burst(int[][] memo, int[] nums, int left, int right) {
		if (left + 1 == right) return 0;
		if (memo[left][right] > 0) return memo[left][right];
		int ans = 0;
		for (int i = left + 1; i < right; i++) {
			ans = Math.max(ans, nums[i] * nums[left] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
		}
		memo[left][right] = ans;
		return ans;
	}
	
}
