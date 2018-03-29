package leetcode050_099;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
    		List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        DFSHelper(res, path, nums, 0);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
		if (index <= nums.length) {
			res.add(path);
		}
		int i = index;
		while (i < nums.length) {
			path.add(nums[i]);
			DFSHelper(res, new ArrayList<Integer>(path), nums, i + 1);
			path.remove(path.size() - 1);
			i++;
			while (i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			}
		}
	}
}
