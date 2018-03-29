package leetcode001_049;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N46 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for (int n : nums) {
			int size = ans.size();
			for (int i = 0; i < size; i++) {
				List<Integer> cur = ans.pollFirst();
				for (int j = 0; j <= cur.size(); j++) {
					List<Integer> newCur = new ArrayList<Integer>(cur);
					newCur.add(j, n);
					ans.add(newCur);
				}
			}
		}
        return ans;
    }
    
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
			return res;
		}
        DFSHelper(res, nums, 0);
        return res;
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
