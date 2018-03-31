package leetcode001_049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
        return new int[] {0, 0};
    }
    
    // return all
    public List<int[]> twoSum2(int[] nums, int target) {
    		List<int[]> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res.add(new int[] {map.get(target - nums[i]), i});
			}
			map.put(nums[i], i);
		}
        return res;
    }
    
    // duplicates
    public List<int[]> twoSum3(int[] nums, int target) {
		List<int[]> res = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
		if (map.containsKey(target - nums[i])) {
			res.add(new int[] {map.get(target - nums[i]), i});
			map.remove(target - nums[i]);
		} else {
			map.put(nums[i], i);
		}
	}
    return res;
}
}
