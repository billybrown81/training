package leetcode001_049;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
			return res;
		}
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, Boolean.FALSE);
        DFSHelper(res, path, nums, used);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
				continue;
			}
			used[i] = true;
			path.add(nums[i]);
			DFSHelper(res, path, nums, used);
			used[i] = false;
			path.remove(path.size() - 1);
		}
		
	}

	private void DFSHelper(List<List<Integer>> res, int[] nums, int index) {
		if (index == nums.length - 1) {
			List<Integer> cur = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				cur.add(nums[i]);
			}
			res.add(cur);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (index != i && (nums[index] == nums[i] || nums[i] == nums[i - 1])) {
				continue;
			}
			swap(nums, index, i);
			DFSHelper(res, nums, index + 1);
			swap(nums, index, i);
		}
		
	}

	private void swap(int[] nums, int index, int i) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}
}
